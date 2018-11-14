package com.ude.obligatorio.logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.LogicaException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.excepciones.RevisionesException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;
import com.ude.obligatorio.logica.valueObjects.VORevision;
import com.ude.obligatorio.persistencia.daos.IDAOFolios;
import com.ude.obligatorio.persistencia.daos.IDAORevisiones;
import com.ude.obligatorio.persistencia.factories.IPersistenciaFabrica;
import com.ude.obligatorio.poolConexiones.PoolConexionesMySQL;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;

import com.ude.obligatorio.configuracion.Configuracion;

public class Fachada {
	private IDAOFolios diccioFol;
	private IPoolConexiones iPoolConexiones;
	
	public Fachada () throws LogicaException {
		try {

			String driver = Configuracion.getProperty("driver");   
			String url = Configuracion.getProperty("url");
            String user = Configuracion.getProperty("user");
            String password = Configuracion.getProperty("pass");
            String nomFab = Configuracion.getProperty("nomFab");
 
            Class.forName(driver);						
			
			IPersistenciaFabrica fabFol = (IPersistenciaFabrica) Class.forName(nomFab).newInstance();
			diccioFol = fabFol.crearFolios();
			
	        iPoolConexiones = PoolConexionesMySQL.getPoolConexiones(url,user,password,10,driver);
	        
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new LogicaException("Hubo un error interno, intente mas tarde");
		} 
		catch (FileNotFoundException e) {
			throw new LogicaException("Hubo un error interno, intente mas tarde");
		} 
		catch (IOException e) {
			throw new LogicaException("Hubo un error interno, intente mas tarde");
		}
		
	}
	
	public void agregarFolio(VOFolio vof) throws PersistenciaException, FolioException {
		
		IConexion iConexion = iPoolConexiones.obtenerConexion(true);
		
		String cod = vof.getCodigo();
		String car = vof.getCaratula();
		int pag = vof.getPaginas();
	
		if(!diccioFol.member(iConexion,cod)) {
			
			Folio folio = new Folio(cod, car, pag);
			diccioFol.insert(iConexion,folio);
			
			iPoolConexiones.liberarConexion(iConexion, true);
		} else {
			iPoolConexiones.liberarConexion(iConexion, true);
			throw new FolioException("Ya existe un folio con ese codigo");
		}
		
	}
	
	public void agregarRevision(String codF,String desc) throws PersistenciaException, FolioException, LogicaException {
		
		IConexion iConexion = iPoolConexiones.obtenerConexion(true);
		
		if(diccioFol.member(iConexion,codF)) {
			
			Folio folio = diccioFol.find(iConexion,codF);
			
			IDAORevisiones diccioRev = folio.getSecuencia();
			
			int numR = diccioRev.largo(iConexion);
			Revision rev = new Revision(numR, desc);
			
			folio.addRevision(iConexion,rev);
			
			diccioFol.insert(iConexion,folio);
			iPoolConexiones.liberarConexion(iConexion, true);
		} else {
			iPoolConexiones.liberarConexion(iConexion, true);
			throw new FolioException("No existe un folio con ese codigo");
		}
		
	}
	
	public void borrarFolioRevisiones(String codF) throws PersistenciaException, FolioException {
		
		IConexion iConexion = iPoolConexiones.obtenerConexion(true);
		if(diccioFol.member(iConexion,codF)) {
			diccioFol.delete(iConexion,codF);
			iPoolConexiones.liberarConexion(iConexion, true);
		} else {
			iPoolConexiones.liberarConexion(iConexion, true);
			throw new FolioException("No existe un folio con ese codigo");
		}
		
	}
	
	public String darDescripcion(String codF, int numR) throws PersistenciaException, RevisionesException, FolioException {
		
		String desc = "";
		
		IConexion iConexion = iPoolConexiones.obtenerConexion(true);
		
		Folio folio = diccioFol.find(iConexion,codF);
		IDAORevisiones diccioRev = folio.getSecuencia();
		Revision rev = diccioRev.kesimo(iConexion,numR);
		
		if(rev != null) {
			desc = rev.getDescripcion();
			iPoolConexiones.liberarConexion(iConexion, true);
		} else {
			iPoolConexiones.liberarConexion(iConexion, true);
			throw new RevisionesException("No existe revision con el numero dado");
		}
		return desc;
	}
	
	public List<VOFolio> listarFolios() throws PersistenciaException{
		IConexion iConexion = iPoolConexiones.obtenerConexion(true);
		List<VOFolio> folios = diccioFol.listarFolios(iConexion);
		iPoolConexiones.liberarConexion(iConexion, true);
		return folios;
	}
	public List<VORevision> listarRevisiones(String codF) throws PersistenciaException, LogicaException, FolioException{
		IConexion iConexion = iPoolConexiones.obtenerConexion(true);
		
		Folio folio = diccioFol.find(iConexion,codF);
		List<VORevision> revisiones = folio.listarRevisiones(iConexion);
		iPoolConexiones.liberarConexion(iConexion, true);
		return revisiones;
	}
	
	public VOFolioMaxRev folioMasRevisado() throws PersistenciaException {
		IConexion iConexion = iPoolConexiones.obtenerConexion(true);
		VOFolioMaxRev masRev = diccioFol.folioMasRevisado(iConexion);
		iPoolConexiones.liberarConexion(iConexion, true);
		return masRev;
	}
	
}
