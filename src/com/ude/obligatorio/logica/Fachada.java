package com.ude.obligatorio.logica;

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
import com.ude.obligatorio.poolConexiones.PoolConexiones;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;

public class Fachada {
	private IDAOFolios diccioFol;
	private IDAORevisiones diccioRev;
	private IPoolConexiones iPoolConexiones;
	
	public Fachada () throws LogicaException {
		try {
			
			//TODO llamar archivo de configurtacion
			String nomFab = "FabricaMySQL";
			
			IPersistenciaFabrica fabFol = (IPersistenciaFabrica) Class.forName(nomFab).newInstance();
			diccioFol = fabFol.crearFolios();
			
			IPersistenciaFabrica fabRev = (IPersistenciaFabrica) Class.forName(nomFab).newInstance();
			diccioRev = fabRev.crearRevisiones();
			
			//TODO: traer los datos correspondientes y completarlos
	        iPoolConexiones = PoolConexiones.getPoolConexiones("","","",10,"");
	        
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
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
			
			int numR = diccioRev.largo(iConexion);
			Revision rev = new Revision(numR, desc);
			
			folio.addRevision(rev);
			
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
	
	public String darDescripcion(String codF, int numR) throws PersistenciaException, RevisionesException {
		
		String desc = "";
		
		IConexion iConexion = iPoolConexiones.obtenerConexion(true);
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
	public List<VORevision> listarRevisiones() throws PersistenciaException{
		IConexion iConexion = iPoolConexiones.obtenerConexion(true);
		List<VORevision> revisiones = diccioRev.listarRevisiones(iConexion);
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
