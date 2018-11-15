package com.ude.obligatorio.grafica.controladores;

import java.io.IOException;
import java.rmi.NotBoundException;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.IFachada;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;

public class AgregarFolioControlador {
	
	
	public GraficaModel addFolio(String cod,String car, int pag) {
		
		
		
		GraficaModel grafica =  new GraficaModel();
		VOFolio voFolio = new VOFolio(cod, car, pag);
		try {
			IFachada fachada = FachadaWraper.getInstance().getFachada();
			fachada.agregarFolio(voFolio);
			grafica.setMensajeExito("La ejecucion se realizo con exito");
		} catch (PersistenciaException  | FolioException | IOException | NotBoundException e) {
			grafica.setMensajeError(e.getMessage());
		}
		return grafica;
	}

}
