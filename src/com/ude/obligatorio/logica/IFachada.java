package com.ude.obligatorio.logica;

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

	public void agregarFolio(VOFolio vof) throws PersistenciaException, FolioException,RemoteException;
	public void agregarRevision(String codF,String desc) throws PersistenciaException, FolioException, LogicaException,RemoteException;
	public void borrarFolioRevisiones(String codF) throws PersistenciaException, FolioException,RemoteException;
	public String darDescripcion(String codF, int numR) throws PersistenciaException, RevisionException, FolioException,RemoteException;
	public List<VOFolio> listarFolios() throws PersistenciaException,RemoteException;
	public List<VORevision> listarRevisiones(String codF) throws PersistenciaException, LogicaException, FolioException,RemoteException;
	public VOFolioMaxRev folioMasRevisado() throws PersistenciaException,RemoteException;
	

}
