package com.ude.obligatorio.logica;

import com.ude.obligatorio.persistencia.daos.IDAOFolios;
import com.ude.obligatorio.persistencia.daos.IDAORevisiones;
import com.ude.obligatorio.persistencia.factories.IPersistenciaFabrica;

public class Fachada {
	private IDAOFolios diccioFol;
	private IDAORevisiones diccioRev;
	
	public Fachada () {
		/* Leer la clases del archivo de configuración. */
		/*IPersistenciaFabrica fabFol = Class.forName(My).newInstance();
		diccioFol = fabFol.crearFolios();
		
		IPersistenciaFabrica fabRev = Class.forName(MySQLFabrica).newInstance();
		diccioRev = fabFol.crearIDAORevisiones;*/
	}
}
