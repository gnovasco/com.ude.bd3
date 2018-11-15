package com.ude.obligatorio.grafica.controladores;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.Fachada;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;

public class FolioMasRevisadoControlador {
	
	private Fachada fachada;
	
	public GraficaModel getFolioMasRevisado(){
		GraficaModel grafica =  new GraficaModel();
		VOFolioMaxRev folMax = null;
		try {
			folMax = fachada.folioMasRevisado();
			grafica.setVoMaxRev(folMax);
		} catch (PersistenciaException  e) {
			grafica.setMensajeError(e.getMessage());
		}
		return grafica;
	}

}
