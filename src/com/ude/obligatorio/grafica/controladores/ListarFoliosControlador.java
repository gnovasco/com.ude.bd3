package com.ude.obligatorio.grafica.controladores;

import java.util.ArrayList;
import java.util.List;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.logica.Fachada;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.LogicaException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VORevision;

public class ListarFoliosControlador {
	
	private Fachada fachada;
	
	public GraficaModel getFolios(){
		GraficaModel grafica =  new GraficaModel();
		List<VOFolio> voFol = new ArrayList<>();
		try {
			voFol = fachada.listarFolios();
			grafica.setListFol(voFol);
		} catch (PersistenciaException e) {
			grafica.setMensajeError(e.getMessage());
		}
		return grafica;
	}

}
