package com.ude.obligatorio.grafica.controladores;

import java.io.IOException;
import java.rmi.NotBoundException;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.IFachada;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.excepciones.RevisionException;

public class DarDescripcionControlador {
	
	
	public GraficaModel getDescription(String codF,int numR) {
		
		GraficaModel grafica =  new GraficaModel();
		String desc = "";
		
			try {
				IFachada fachada = FachadaWraper.getInstance().getFachada();
				desc = fachada.darDescripcion(codF, numR);
				grafica.setDesc(desc);
			} catch (PersistenciaException | RevisionException | FolioException | IOException | NotBoundException e) {
				grafica.setMensajeError(e.getMessage());
			}
			
		
			
		return grafica;
	}

}
