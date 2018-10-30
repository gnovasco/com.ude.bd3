package com.ude.obligatorio.logica.excepciones;

public class PoolDeConexionesException extends Exception{

    public PoolDeConexionesException(String mensaje, Throwable err){
        super(mensaje,err);
    }
}
