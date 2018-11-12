package com.ude.obligatorio.logica;

import java.util.ArrayList;
import java.util.List;

import com.ude.obligatorio.logica.excepciones.LogicaException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VORevision;
import com.ude.obligatorio.persistencia.daos.DAORevisionesMySQL;
import com.ude.obligatorio.persistencia.daos.IDAORevisiones;

public class Folio {

    private String codigo;
    private String caratula;
    private int paginas;
    private IDAORevisiones secuencia;

    public Folio(String cod,String car,int pag){
        codigo = cod;
        caratula = car;
        paginas = pag;

        secuencia = new DAORevisionesMySQL(codigo);
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

    public boolean tieneRevision(int numR) throws LogicaException {
        Revision revision = null;
        try {
            revision = secuencia.kesimo(numR);
        } catch(PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
        return revision != null;
    }
    public int cantidadRevisiones() throws LogicaException {
        int largo = -1;
        try {
            largo = secuencia.largo();
        } catch(PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
        return largo;
    }
    public void addRevision(Revision rev) throws LogicaException {

        try {
            secuencia.insBack(rev);
        } catch (PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
    }
    public Revision obtenerRevision(int numR) throws LogicaException {
        Revision kesimo = null;
        try {
            kesimo = secuencia.kesimo(numR);
        } catch (PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
        return kesimo;
    }
    public List<VORevision> listarRevisiones() throws LogicaException {
        List<VORevision> revisiones = new ArrayList<>();
        try {
            revisiones = secuencia.listarRevisiones();
        } catch (PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
        return revisiones;
    }
    public void borrarRevisiones() throws LogicaException {
        try {
            secuencia.borrarRevisiones();
        } catch (PersistenciaException e) {
            throw new LogicaException(e.getMessage());
        }
    }
}
