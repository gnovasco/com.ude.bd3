package com.ude.obligatorio.poolConexiones;

import java.sql.Connection;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.ude.obligatorio.poolConexiones.interfaces.IConexion;

public class ConexionArchivo implements IConexion {
    private ReadWriteLock ioLock;
    
    public ConexionArchivo() {
        ioLock = new ReentrantReadWriteLock();
    }   // ConexionArchivo
    
    
    @Override
	public Connection getCon() {
    	//TODO
    	return null;
	}   // getCon
}   // ConexionArchivo
