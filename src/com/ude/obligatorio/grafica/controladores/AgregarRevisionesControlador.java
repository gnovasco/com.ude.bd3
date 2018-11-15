package com.ude.obligatorio.grafica.controladores;

import java.io.IOException;
import java.rmi.NotBoundException;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.Fachada;
import com.ude.obligatorio.logica.IFachada;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.LogicaException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;

public class AgregarRevisionesControlador {
	
	
	public GraficaModel addRevision(String codF,String desc) {
		
		GraficaModel grafica =  new GraficaModel();
		try {
			IFachada fachada = FachadaWraper.getInstance().getFachada();
			fachada.agregarRevision(codF, desc);
			grafica.setMensajeExito("La ejecucion se realizo con exito");
		} catch (PersistenciaException  | FolioException | LogicaException | IOException | NotBoundException e) {
			grafica.setMensajeError(e.getMessage());
		}
		return grafica;
	}

}
