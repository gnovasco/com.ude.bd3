package com.ude.obligatorio.poolConexionesArchivo;

import java.sql.Connection;

public ConexionArchivo implements IConexion {
    private ReadWriteLock ioLock;
    
    public ConexionArchivo() {
        ioLock = new ReentrantReadWriteLock();
    }   // ConexionArchivo
    
    
    @Override
	public Connection getCon() {
	}   // getCon
}   // ConexionArchivo