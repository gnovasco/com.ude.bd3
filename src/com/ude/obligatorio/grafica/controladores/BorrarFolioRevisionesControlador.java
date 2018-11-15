package com.ude.obligatorio.grafica.controladores;

import java.io.IOException;
import java.rmi.NotBoundException;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.IFachada;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;

public class BorrarFolioRevisionesControlador {
	
	
	public GraficaModel deleteRev(String codF) {
		
		GraficaModel grafica =  new GraficaModel();
		
		try {
			IFachada fachada = FachadaWraper.getInstance().getFachada();
			fachada.borrarFolioRevisiones(codF);
			grafica.setMensajeExito("La ejecucion se realizo con exito");
		} catch (PersistenciaException  | FolioException | IOException | NotBoundException e) {
			grafica.setMensajeError(e.getMessage());
		}
		return grafica;
	}

}
