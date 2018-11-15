package com.ude.obligatorio.grafica.controladores;

import java.util.ArrayList;
import java.util.List;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.Fachada;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.LogicaException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VORevision;

public class ListarRevisionesControlador {
	
	private Fachada fachada;
	
	public GraficaModel getRevisiones(String codF){
		GraficaModel grafica =  new GraficaModel();
		List<VORevision> voRev = new ArrayList<>();
		try {
			voRev = fachada.listarRevisiones(codF);
			grafica.setListRev(voRev);
		} catch (PersistenciaException | LogicaException | FolioException e) {
			grafica.setMensajeError(e.getMessage());
		}
		return grafica;
	}

}
