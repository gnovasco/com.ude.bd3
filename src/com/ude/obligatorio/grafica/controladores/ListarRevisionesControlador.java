package com.ude.obligatorio.grafica.controladores;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.List;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.Fachada;
import com.ude.obligatorio.logica.IFachada;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.LogicaException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VORevision;

public class ListarRevisionesControlador {
	
	
	public GraficaModel getRevisiones(String codF){
		GraficaModel grafica =  new GraficaModel();
		List<VORevision> voRev = new ArrayList<>();
		try {
			IFachada fachada = FachadaWraper.getInstance().getFachada();
			voRev = fachada.listarRevisiones(codF);
			grafica.setListRev(voRev);
		} catch (PersistenciaException | LogicaException | FolioException | IOException | NotBoundException e) {
			grafica.setMensajeError(e.getMessage());
		}
		return grafica;
	}

}
