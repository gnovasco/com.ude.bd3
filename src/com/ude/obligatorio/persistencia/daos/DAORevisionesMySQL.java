package com.ude.obligatorio.persistencia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ude.obligatorio.logica.Revision;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VORevision;
import com.ude.obligatorio.persistencia.consultas.Consultas;
import com.ude.obligatorio.poolConexiones.ConexionMySQL;
import com.ude.obligatorio.poolConexiones.PoolConexiones;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;


public class DAORevisionesMySQL implements IDAORevisiones {
/*
 * Atributos.
 */
    private Consultas consultas;
    private IPoolConexiones iPoolConexiones;
    private String codigoFolio;

/*
 * Métodos.
 */
    public DAORevisionesMySQL(String codFol) {
        codigoFolio = codFol;
        consultas = new Consultas();
        //TODO: traer los datos correspondientes y completarlos.
        iPoolConexiones = PoolConexiones.getPoolConexiones("","","",10,"");
    }   // DAORevisionesMySQL


    /**
     * Instera una revision en la tabla
     * @param rev
     * @throws PersistenciaException
     */
    @Override
    public void insBack(IConexion iConexion,Revision rev) throws PersistenciaException {
    	
    	ConexionMySQL conMySQL = (ConexionMySQL)iConexion;
        Connection con = conMySQL.getCon();
        
        PreparedStatement pstmt;
        String query, revDesc;
        int revNum;

        if (con == null) {
            throw new PersistenciaException("No hay conexiones disponibles");
        }

        try {
            query = consultas.insertarRevision();
            pstmt = con.prepareStatement(query);
            revNum = rev.getNumero();
            revDesc = rev.getDescripcion();
            pstmt.setInt(1, revNum);
            pstmt.setString(2, revDesc);
            pstmt.executeUpdate();
            pstmt.close();
            iPoolConexiones.liberarConexion(iConexion,true);
        }
        catch (SQLException e) {
            throw new PersistenciaException("Error al intentar agregar una revision",e);
        }
       
    }   // insBack


    /**
     * Largo de registros en la tabla revision
     * @return Devuelve -1 en caso de error.
     * @throws PersistenciaException
     */
    public int largo(IConexion iConexion) throws PersistenciaException {
    	
        int largo = -1;
        
        ConexionMySQL conMySQL = (ConexionMySQL)iConexion;
        Connection con = conMySQL.getCon();
        
        if (con == null) {
            throw new PersistenciaException("No hay conexiones disponibles");
        }

        try {
            String query = consultas.cantidadRevisiones();
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                largo = rs.getInt("total");
            }
            pstmt.close();
            iPoolConexiones.liberarConexion(iConexion,true);
        }
        catch (SQLException e) {
            throw new PersistenciaException("Error al obtener el total de revisiones",e);
        }
        return largo;
    }   // largo


    /**
     * Devuelve la revision con numero 'numero'
     * @param numero
     * @return Revision
     */
    @Override
    public Revision kesimo(IConexion iConexion,int numero) throws PersistenciaException {
    	
        Revision revision = null;
        
        ConexionMySQL conMySQL = (ConexionMySQL)iConexion;
        Connection con = conMySQL.getCon();
        
        if(con == null) {
            throw new PersistenciaException("No hay conexiones disponibles");
        }

        try {
            String query = consultas.obtenerRevision();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, numero);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int revNum = rs.getInt("numero");
                String revDesc = rs.getString("descripcion");
                revision = new Revision(revNum, revDesc);
            }
            else {
                throw new PersistenciaException("No existe revision para el numero ingresado");
            }
            pstmt.close();
        }
        catch (SQLException e) {
            throw new PersistenciaException("Error al obtener una revision",e);
        }
        finally {
            try {
                /* en cualquier caso, cierro la conexion */
                if (con != null)
                    con.close();
            }
            catch (SQLException e) {
                throw new PersistenciaException("Error al cerrando la conexion revision",e);
            }
        }
        return revision;
    }   // kesimo

    /**
     * Retorna lsita de VORevion
     * @return voRevisiones
     * @throws PersistenciaException
     */
    public List<VORevision> listarRevisiones(IConexion iConexion) throws PersistenciaException {
    	
        List<VORevision> voRevisiones = new ArrayList<>();
        
        ConexionMySQL conMySQL = (ConexionMySQL)iConexion;
        Connection con = conMySQL.getCon();
        
        String revDesc;
        int revNum;
        
        if (con == null) {
            throw new PersistenciaException("No hay conexiones disponibles.");
        }

        try {
            String query = consultas.listarRevisiones();
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                revNum = rs.getInt("numero");
                revDesc = rs.getString("descripcion");
                VORevision voRevision = new VORevision(revNum, revDesc);
                voRevisiones.add(voRevision);
            }
            pstmt.close();
        }
        catch (SQLException e) {
            throw new PersistenciaException("Error al listar las revisiones.", e);
        }
        return voRevisiones;
    }   // listarRevisiones

    /**
     * Borra todas las revisiones
     * @throws PersistenciaException
     */
    public void borrarRevisiones(IConexion iConexion) throws PersistenciaException {
    	
    	ConexionMySQL conMySQL = (ConexionMySQL)iConexion;
        Connection con = conMySQL.getCon();
        
        
        if (con == null) {
            throw new PersistenciaException("No hay conexiones disponibles");
        }

        try {
        	String query = consultas.borrarFolioRevisiones();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch (SQLException e) {
            throw new PersistenciaException("Error al borrar las revisiones",e);
        }
    }   // borrarRevisiones

}
