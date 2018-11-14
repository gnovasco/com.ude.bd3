package com.ude.obligatorio.logica.valueObjects;

public class VORevision {

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
