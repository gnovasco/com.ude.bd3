package com.ude.obligatorio.grafica.controladores;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.Fachada;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.excepciones.RevisionesException;

public class DarDescripcionControlador {
	
	private Fachada fachada;
	
	public GraficaModel getDescription(String codF,int numR) {
		
		GraficaModel grafica =  new GraficaModel();
		String desc = "";
		
		try {
			desc = fachada.darDescripcion(codF, numR);
			grafica.setDesc(desc);
		} catch (PersistenciaException  | FolioException | RevisionesException e) {
			grafica.setMensajeError(e.getMessage());
		}
		return grafica;
	}

}
