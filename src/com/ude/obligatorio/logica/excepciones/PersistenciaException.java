package com.ude.obligatorio.logica.excepciones;

public class PersistenciaException extends Exception {

    public PersistenciaException(String mensaje){
        super(mensaje);
    }
    public PersistenciaException(String mensaje, Throwable err){
        super(mensaje,err);
    }
}
