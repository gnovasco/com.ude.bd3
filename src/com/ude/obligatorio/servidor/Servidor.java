package com.ude.obligatorio.servidor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.ude.obligatorio.configuracion.Configuracion;
import com.ude.obligatorio.logica.Fachada;
import com.ude.obligatorio.logica.excepciones.LogicaException;




public class Servidor {
	
	public static void main (String [] args) {
		
		String ipServidor;
		String puertoServidor;

		try {
			
			ipServidor = Configuracion.getProperty("ServidorIp");
			puertoServidor = Configuracion.getProperty("ServidorPuerto");
			
			LocateRegistry.createRegistry(Integer.parseInt(puertoServidor));
			Fachada fachada = new Fachada();
			Naming.rebind("//" + ipServidor + ":" + puertoServidor + "/fachada", fachada);

			System.out.println("Corriendo en " + ipServidor + ":" + puertoServidor);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(2);
		} catch (LogicaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
