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

public class Fachada {
	private IDAOFolios diccioFol;
	private IDAORevisiones diccioRev;
	
	public Fachada () throws LogicaException {
		try {
			
			String nomFab = "FabricaMySQL";
			
			IPersistenciaFabrica fabFol = (IPersistenciaFabrica) Class.forName(nomFab).newInstance();
			diccioFol = fabFol.crearFolios();
			
			IPersistenciaFabrica fabRev = (IPersistenciaFabrica) Class.forName(nomFab).newInstance();
			diccioRev = fabRev.crearRevisiones();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new LogicaException("Hubo un error interno, intente mas tarde");
		}
		
	}
	
	public void agregarFolio(VOFolio vof) throws PersistenciaException, FolioException {
		
		String cod = vof.getCodigo();
		String car = vof.getCaratula();
		int pag = vof.getPaginas();
	
		if(!diccioFol.member(cod)) {
			
			Folio folio = new Folio(cod, car, pag);
			diccioFol.insert(folio);
			
		} else {
			throw new FolioException("Ya existe un folio con ese codigo");
		}
		
	}
	
	public void agregarRevision(String codF,String desc) throws PersistenciaException, FolioException {
		//Revision rev = new Revision(codF, desc); TODO Vuelve la duda que tenia !!!! 
		Revision rev =  null;
		diccioRev.insBack(rev);
	}
	
	public void borrarFolioRevisiones(String codF) {
		//TODO lo mismo que arriba 
	}
	
	public String darDescripcion(String codF, int numR) throws PersistenciaException, RevisionesException {
		
		String desc = "";
		
		Revision rev = diccioRev.kesimo(numR);
		if(rev != null) {
			desc = rev.getDescripcion();
		} else {
			throw new RevisionesException("No existe revision con el numero dado");
		}
		return desc;
	}
	
	public List<VOFolio> listarFolios() throws PersistenciaException{
		List<VOFolio> folios = diccioFol.listarFolios();
		return folios;
	}
	public List<VORevision> listarRevisiones() throws PersistenciaException{
		List<VORevision> revisiones = diccioRev.listarRevisiones();
		return revisiones;
	}
	
	public VOFolioMaxRev folioMasRevisado() throws PersistenciaException {
		VOFolioMaxRev masRev = diccioFol.folioMasRevisado();
		return masRev;
	}
	
}
