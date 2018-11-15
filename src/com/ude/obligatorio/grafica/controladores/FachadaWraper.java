package com.ude.obligatorio.grafica.controladores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import com.ude.obligatorio.configuracion.Configuracion;
import com.ude.obligatorio.logica.IFachada;

public class FachadaWraper {
	
	private static FachadaWraper instance;
	
	private IFachada fachada;
	
	private FachadaWraper() throws FileNotFoundException, IOException, NotBoundException  {
		obtenerFachadaRemota();
	}
	
	private void obtenerFachadaRemota() throws FileNotFoundException, IOException, NotBoundException  {
		String ipServidor = Configuracion.getProperty("ipServidor");
		String puertoServidor = Configuracion.getProperty("puertoServidor");
		fachada = (IFachada) Naming.lookup("//" + ipServidor + ":" + puertoServidor + "/fachada");
	}
	
	public synchronized static FachadaWraper getInstance() throws FileNotFoundException, IOException, NotBoundException  {
		if (instance == null) {
			instance = new FachadaWraper();
		}
		return instance;
	}
	
	public IFachada getFachada() {
		return fachada;
	}

}
