package com.ude.obligatorio.grafica.controladores;

import java.io.IOException;
import java.rmi.NotBoundException;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.IFachada;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;

public class FolioMasRevisadoControlador {
	
	public GraficaModel getFolioMasRevisado(){
		GraficaModel grafica =  new GraficaModel();
		VOFolioMaxRev folMax = null;
		try {
			IFachada fachada = FachadaWraper.getInstance().getFachada();
			folMax = fachada.folioMasRevisado();
			grafica.setVoMaxRev(folMax);
		} catch (PersistenciaException | IOException | NotBoundException  e) {
			grafica.setMensajeError(e.getMessage());
		}
		return grafica;
	}

}
