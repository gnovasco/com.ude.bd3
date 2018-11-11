package com.ude.obligatorio.persistencia.daos;

import com.ude.obligatorio.logica.Folio;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;
import com.ude.obligatorio.persistencia.consultas.Consultas;
import com.ude.obligatorio.poolConexiones.PoolConexiones;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAOFoliosMySQL implements IDAOFolios{
    /*
     * Atributos.
     */
    private Consultas consultas;
    private IPoolConexiones iPoolConexiones;


    /*
     * Métodos.
     */

    public DAOFoliosMySQL() {
        consultas = new Consultas();
        //TODO: traer los datos correspondientes y completarlos
        iPoolConexiones = PoolConexiones.getPoolConexiones("","","",10,"");
    }   // DAOFoliosMySQL


    public boolean member(String cod) throws PersistenciaException {
        IConexion iConexion = iPoolConexiones.obtenerConexion(false);
        Connection con = iConexion.getCon();
        PreparedStatement pstmt;
        ResultSet rs;
        String query;
        boolean isMember = false;

        if (con == null) {
            throw new PersistenciaException("No hay conexiones disponibles.");
        }

        try {
            query = consultas.obtenerFolio();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, cod);
            rs = pstmt.executeQuery();
            isMember = rs.isBeforeFirst();
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) {
            throw new PersistenciaException("Error al intentar obtener un folio.", e);
        }
        finally {
            try {
                /* en cualquier caso, cierro la conexion */
                if (con != null)
                    con.close();
            }
            catch (SQLException e) {
                throw new PersistenciaException("Error cerrar la conexion.", e);
            }
        }   // finally
        return isMember;
    }   // member


    public void insert(Folio fol) throws PersistenciaException {
        IConexion iConexion = iPoolConexiones.obtenerConexion(true);
        Connection con = iConexion.getCon();
        PreparedStatement pstmt;
        String folCod, folCar, query;
        int folPag;

        if (con == null) {
            throw new PersistenciaException("No hay conexiones disponibles.");
        }

        try {
            query = consultas.insertarFolio();
            pstmt = con.prepareStatement(query);
            folCod = fol.getCodigo();
            folCar = fol.getCaratula();
            folPag = fol.getPaginas();
            pstmt.setString(1, folCod);
            pstmt.setString(2, folCar);
            pstmt.setInt(3,folPag);
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch (SQLException e) {
            throw new PersistenciaException("Error al intentar agregar un folio.",e);
        }
        finally {
            try {
                /* en cualquier caso, cierro la conexion */
                if (con != null)
                    con.close();
            }
            catch (SQLException e) {
                throw new PersistenciaException("Error cerrando la conexion.", e);
            }
        }   // finally
    }   // insert


    public Folio find(String cod) {
        IConexion iConexion = iPoolConexiones.obtenerConexion(false);
        Connection con = iConexion.getCon();
        PreparedStatement pstmt;
        ResultSet rs;
        String cod, car, query;
        int pag, revs;
        Folio fol = null;

        try {
            query = consultas.obtenerFolio();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, folCod);
            rs = pstmt.executeUpdate();
            // Si hay un folio lo cargo.
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    cod = rs.getString("codigo");
                    car = rs.getString("caratula");
                    pag = rs.getInt("paginas");
                    /* Cómo se cargaría el DAORevisiones? */
                    sec = null;
                    revs = rs.getInt("cantidadrevisiones");
                }   // while
                fol = new Folio(cod, car, pag, sec);
            }   // if
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) {
            throw new PersistenciaException("Error cerrando la conexion.", e);
        }
        finally {
            return fol;
        }
    }   // find


    public void delete() {
        //TODO IMPLLEMTENAR METODO
    }   // delete


    public List<VOFolio> listarFolios() {
    	//TODO IMPLLEMTENAR METODO
        return null;
    }   // listarFolios
    
    
    /*
     * Devuelve 'true' si el diccionario está vacío, no hay folios;
     * y 'false' en caso contrario.
     */
    public boolean esVacio() {
        IConexion iConexion = iPoolConexiones.obtenerConexion(false);
        Connection con = iConexion.getCon();
        PreparedStatement pstmt;
        ResultSet rs;
        boolean res = true;
        
        try {
            query = consultas.listarFolio();
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeUpdate();
            res = !(rs.isBeforeFirst());
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) {
            throw new PersistenciaException("Error cerrando la conexion.", e);
        }
        
        return res;
    }   // esVacio
    
    
    public VOFolioMaxRev folioMasRevisado () {
        IConexion iConexion = iPoolConexiones.obtenerConexion(false);
        Connection con = iConexion.getCon();
        PreparedStatement pstmt;
        ResultSet rs;
        VOFolioMaxRev res = null;
        String cod, car, query;
        int pag, revs;
        
        try {
            query = consultas.obtenerFolioMasRevisado();
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeUpdate();
            // Si hay un folio lo cargo.
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    cod = rs.getString("codigo");
                    car = rs.getString("caratula");
                    pag = rs.getInt("paginas");
                    revs = rs.getInt("cantidadrevisiones");
                }   // while
                res = new VOFolio(cod, car, pag, revs);
            }   // if                        
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) {
            throw new PersistenciaException("Error cerrando la conexion.", e);
        }
        
        return res;
    }   // folioMasRevisado
}
