package com.ude.obligatorio.grafica.controladores;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.Fachada;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.excepciones.RevisionesException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;

public class AgregarFolioControlador {
	
	private Fachada fachada;
	
	public GraficaModel addFolio(String cod,String car, int pag) {
		
		GraficaModel grafica =  new GraficaModel();
		VOFolio voFolio = new VOFolio(cod, car, pag);
		try {
			fachada.agregarFolio(voFolio);
			grafica.setMensajeExito("La ejecucion se realizo con exito");
		} catch (PersistenciaException  | FolioException e) {
			grafica.setMensajeError(e.getMessage());
		}
		return grafica;
	}

}
