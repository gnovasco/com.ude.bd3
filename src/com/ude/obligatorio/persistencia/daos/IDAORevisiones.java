package com.ude.obligatorio.persistencia.daos;

import java.util.List;

public interface IDAORevisiones {

	public void insBack();
	public int largo();
	public Revision kesimo();
	public List<VORevision> listarRevisiones();
	public void borrarRevisiones();
}
