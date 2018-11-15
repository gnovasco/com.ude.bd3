package com.ude.obligatorio.configuracion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class Configuracion {

	private static final String RUTA_ARCHIVO_CONFIG = "config/config.properties";
	
	private Configuracion() {}
	
	public static String getProperty(String nombre) throws FileNotFoundException, IOException {
		
		Properties configuracion = new Properties();
		configuracion.load (new FileInputStream (RUTA_ARCHIVO_CONFIG));
		String propiedad = configuracion.getProperty(nombre);
		
		return propiedad;
	}
	
	public static boolean debug() {
		boolean debug = false;
		Properties configuracion = new Properties();
		try {
			configuracion.load (new FileInputStream (RUTA_ARCHIVO_CONFIG));
			String propiedad = configuracion.getProperty( "Debug" );
			debug = Boolean.parseBoolean( propiedad );
		} catch (IOException e) {
			//e.printStackTrace();
		}
		
		return debug;
	}
	
}
