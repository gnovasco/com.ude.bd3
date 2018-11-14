package com.ude.obligatorio.logica;

public class Revision {
    private int numero;
    private String descripcion;

    //Deje esta ultima como valida , sin el atributo codF
    public Revision(int num, String desc){
        numero = num;
        descripcion = desc;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
