package com.ude.obligatorio.logica.valueObjects;

import java.io.Serializable;

public class VOFolio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
    private String caratula;
    private int paginas;
    

    public VOFolio(String cod,String car, int pag){

        codigo = cod;
        caratula = car;
        paginas = pag;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCaratula() {
        return caratula;
    }

    public int getPaginas() {
        return paginas;
    }
}
