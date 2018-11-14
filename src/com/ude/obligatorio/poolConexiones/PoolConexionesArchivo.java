package com.ude.obligatorio.poolConexiones;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;

public class PoolConexionesArchivo implements IPoolConexiones {
	/*
	 * Atributos.
	 */
	
	// Bloqueo para mutua exclusion de la estructura.
	private Lock mapaLock = new ReentrantLock();
	
	
	public IConexion obtenerConexion(boolean modifica) {
		mapaLock.lock();
	}	// obtenerConexion
	
	
	public void liberarConexion(IConexion icon, boolean ok) {
		mapaLock.unlock();
	}	// liberarConexion
	


/*	
	private Map<String, ReadWriteLock> lockMap = new HashMap<String, ReadWriteLock>();

// lock to protect our registry - helps to prevent multiple threads
// from instantiating a lock with the same key
private Lock registryLock = new ReentrantLock();

// allow callers to specify the lock type they require
public enum LockType {
    READ, WRITE
}

public void acquire(String fileName, LockType type) {

    // lazily instantiates locks on first use
    ReadWriteLock lock = retrieveLock(fileName);

    switch (type) {
    case READ:
        lock.readLock().lock();
        break;
    case WRITE:
        lock.writeLock().lock();
        break;
    default:
        // handle error scenario
        break;
    }

}

public void release(String fileName, LockType type) {

    ReadWriteLock lock = retrieveLock(fileName);

    switch (type) {

    case READ:
        lock.readLock().unlock();
        break;
    case WRITE:
        lock.writeLock().unlock();
        break;
    default:
        // handle error scenario
        break;
    }

}

private ReadWriteLock retrieveLock(String fileName) {

    ReadWriteLock newLock = null;

    try {

        registryLock.lock();

        newLock = lockMap.get(fileName);

        // create lock and add to map if it doesn't exist
        if (newLock == null) {
            newLock = new ReentrantReadWriteLock();
            lockMap.put(fileName, newLock);
        }
    } finally {

        registryLock.unlock();
    }

    return newLock;
}
*/
	
}   // PoolConexionesArchivo
