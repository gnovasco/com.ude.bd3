package com.ude.obligatorio.logica;

import java.util.ArrayList;
import java.util.List;

import com.ude.obligatorio.logica.excepciones.LogicaException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VORevision;
import com.ude.obligatorio.persistencia.daos.DAORevisionesMySQL;
import com.ude.obligatorio.persistencia.daos.IDAORevisiones;
import com.ude.obligatorio.persistencia.factories.IPersistenciaFabrica;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;

public class Folio {

    private String codigo;
    private String caratula;
    private int paginas;
    private IDAORevisiones secuencia;

    public Folio(String cod,String car,int pag){
        codigo = cod;
        caratula = car;
        paginas = pag;
        
        //TODO
		IPersistenciaFabrica fabRev = null;
		try {
			fabRev = (IPersistenciaFabrica) Class.forName("").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		secuencia = fabRev.crearRevisiones(cod);
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

    public IDAORevisiones getSecuencia() {
        return secuencia;
    }    
    
    public boolean tieneRevision(IConexion con, int numR) throws LogicaException {
        Revision revision = null;
        try {
            revision = secuencia.kesimo(con, numR);
        } catch(PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
        return revision != null;
    }
    
    public int cantidadRevisiones(IConexion con) throws LogicaException {
        int largo = -1;
        try {
            largo = secuencia.largo(con);
        } catch(PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
        return largo;
    }
    public void addRevision(IConexion con, Revision rev) throws LogicaException {

        try {
            secuencia.insBack(con, rev);
        } catch (PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
    }
    public Revision obtenerRevision(IConexion con, int numR) throws LogicaException {
        Revision kesimo = null;
        try {
            kesimo = secuencia.kesimo(con, numR);
        } catch (PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
        return kesimo;
    }
    public List<VORevision> listarRevisiones(IConexion con) throws LogicaException {
        List<VORevision> revisiones = new ArrayList<>();
        try {
            revisiones = secuencia.listarRevisiones(con);
        } catch (PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
        return revisiones;
    }
    public void borrarRevisiones(IConexion con) throws LogicaException {
        try {
            secuencia.borrarRevisiones(con);
        } catch (PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
    }
}
