package com.ude.obligatorio.logica;

import com.ude.obligatorio.persistencia.daos.IDAOFolios;
import com.ude.obligatorio.persistencia.daos.IDAORevisiones;

public class Fachada {
	private IDAOFolios diccioFol;
	private IDAORevisiones diccioRev;
	
	public Fachada () {
		/* Leer la clases del archivo de configuración. */

		/*IPersistenciaFabrica fabFol = Class.forName(My).newInstance();
		diccioFol = fabFol.crearFolios();
		/*IPersistenciaFabrica fabFol = Class.forName(MySQLFabrica).newInstance();
		diccioFol = fabFol.crearIDAOFolios;
		
		IPersistenciaFabrica fabRev = Class.forName(MySQLFabrica).newInstance();
		diccioRev = fabFol.crearIDAORevisiones;*/
	}
}
