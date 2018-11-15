package com.ude.obligatorio.logica.valueObjects;

import java.io.Serializable;

public class VORevision  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
    private String description;
    private String codFolio;

     public VORevision(int num, String desc,String codF){
         numero = num;
         description = desc;
         codFolio = codF;
     }

    public int getNumero() {
        return numero;
    }

    public String getDescription() {
        return description;
    }

    public String getCodFolio() {
        return codFolio;
    }
}
