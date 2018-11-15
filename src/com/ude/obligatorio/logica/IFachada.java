package com.ude.obligatorio.logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.LogicaException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.excepciones.RevisionException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;
import com.ude.obligatorio.logica.valueObjects.VORevision;



public interface IFachada extends Remote {

	public void agregarFolio(VOFolio vof) throws PersistenciaException, FolioException;
	public void agregarRevision(String codF,String desc) throws PersistenciaException, FolioException, LogicaException;
	public void borrarFolioRevisiones(String codF) throws PersistenciaException, FolioException;
	public String darDescripcion(String codF, int numR) throws PersistenciaException, RevisionException, FolioException;
	public List<VOFolio> listarFolios() throws PersistenciaException;
	public List<VORevision> listarRevisiones(String codF) throws PersistenciaException, LogicaException, FolioException;
	public VOFolioMaxRev folioMasRevisado() throws PersistenciaException;
	

}
