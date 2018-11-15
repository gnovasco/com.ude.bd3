package com.ude.obligatorio.grafica.controladores;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.Fachada;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.excepciones.RevisionesException;

public class BorrarFolioRevisionesControlador {
	
	private Fachada fachada;
	
	public GraficaModel deleteRev(String codF) {
		
		GraficaModel grafica =  new GraficaModel();
		
		try {
			fachada.borrarFolioRevisiones(codF);
			grafica.setMensajeExito("La ejecucion se realizo con exito");
		} catch (PersistenciaException  | FolioException e) {
			grafica.setMensajeError(e.getMessage());
		}
		return grafica;
	}

}
