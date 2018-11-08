package com.ude.obligatorio.logica;

public class Fachada {
	private IDAOFolios diccioFol;
	private IDAORevisioines diccioRev;
	
	public Fachada () {
		/* Leer la clases del archivo de configuración. */
		IPersistenciaFabrica fabFol = Class.forName(MySQLFabrica).newInstance();
		diccioFol = fabFol.crearIDAOFolios;
		
		IPersistenciaFabrica fabRev = Class.forName(MySQLFabrica).newInstance();
		diccioRev = fabFol.crearIDAORevisiones;
	}
}
