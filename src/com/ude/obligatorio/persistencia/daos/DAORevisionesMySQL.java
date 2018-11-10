package com.ude.obligatorio.persistencia.daos;

import com.ude.obligatorio.logica.Revision;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VORevision;
import com.ude.obligatorio.persistencia.consultas.Consultas;
import com.ude.obligatorio.poolConexiones.PoolConexiones;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAORevisionesMySQL implements IDAORevisiones{

    private String codigoFolio;

    private Consultas consultas;
    private IPoolConexiones iPoolConexiones;

    public DAORevisionesMySQL(String codFol) {

        codigoFolio = codFol;
        consultas = new Consultas();
        //TODO: traer los datos correspondientes y completarlos.
        iPoolConexiones = PoolConexiones.getPoolConexiones("","","",10,"");
    }

    /**
     * Insterauna revision en la tabla
     * @param rev
     * @throws PersistenciaException
     */
    public void insBack(Revision rev) throws PersistenciaException {

        IConexion iConexion = iPoolConexiones.obtenerConexion(true);
        Connection con = iConexion.getCon();
        if(con == null){
            throw new PersistenciaException("No hay conexiones disponibles");
        }

        try {
            String query = consultas.insertarRevision();

            PreparedStatement pstmt = con.prepareStatement(query);

            int revNum = rev.getNumero();
            String revDesc = rev.getDescripcion();

            pstmt.setInt(1, revNum);
            pstmt.setString(2, revDesc);

            pstmt.executeUpdate();

            pstmt.close();
            iPoolConexiones.liberarConexion(iConexion,true);

        } catch (SQLException e) {
            throw new PersistenciaException("Error al intentar agregar una revision",e);
        } finally {
            try {
                /* en cualquier caso, cierro la conexion */
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new PersistenciaException("Error al cerrando la conexion revision",e);
            }
        }
    }

    @Override
    public void insBack() throws PersistenciaException {
        //TODO IMPLLEMTENAR METODO
    }

    /**
     * Largo de registros en la tabla revision
     * @return Devuelve -1 en caso de error.
     * @throws PersistenciaException
     */
    public int largo() throws PersistenciaException {

        int largo = -1;

        IConexion iConexion = iPoolConexiones.obtenerConexion(true);
        Connection con = iConexion.getCon();
        if(con == null){
            throw new PersistenciaException("No hay conexiones disponibles");
        }

        try {

            String query = consultas.cantidadRevisiones();

            PreparedStatement pstmt = con.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                largo = rs.getInt("total");
            }
            pstmt.close();
            iPoolConexiones.liberarConexion(iConexion,true);

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener el total de revisiones",e);
        } finally {
            try {
                /* en cualquier caso, cierro la conexion */
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new PersistenciaException("Error al cerrando la conexion revision",e);
            }
        }
        return largo;
    }

    @Override
    public Revision kesimo() throws PersistenciaException {
        //TODO IMPLLEMTENAR METODO
        return null;
    }

    /**
     * Devuelve la revision con numero 'numero'
     * @param numero
     * @return Revision
     */
    public Revision kesimo(int numero) throws PersistenciaException {

        Revision revision = null;

        IConexion iConexion = iPoolConexiones.obtenerConexion(true);
        Connection con = iConexion.getCon();
        if(con == null){
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
            } else {
                throw new PersistenciaException("No existe revision para el numero ingresado");
            }
            pstmt.close();

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener una revision",e);
        } finally {
            try {
                /* en cualquier caso, cierro la conexion */
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new PersistenciaException("Error al cerrando la conexion revision",e);
            }
        }
        return revision;
    }

    /**
     * Retorna lsita de VORevion
     * @return voRevisiones
     * @throws PersistenciaException
     */
    public List<VORevision> listarRevisiones() throws PersistenciaException {

        List<VORevision> voRevisiones = new ArrayList<>();

        IConexion iConexion = iPoolConexiones.obtenerConexion(true);
        Connection con = iConexion.getCon();
        if(con == null){
            throw new PersistenciaException("No hay conexiones disponibles");
        }

        try {

            String query = consultas.listarRevisiones();

            PreparedStatement pstmt = con.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                int revNum = rs.getInt("numero");
                String revDesc = rs.getString("descripcion");

                VORevision voRevision = new VORevision(revNum, revDesc);

                voRevisiones.add(voRevision);
            }
            pstmt.close();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al listar las revisiones",e);
        } finally {
            try {
                /* en cualquier caso, cierro la conexion */
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new PersistenciaException("Error al cerrando la conexion revision",e);
            }
        }
        return voRevisiones;
    }

    /**
     * Borra todas las revisiones
     * @throws PersistenciaException
     */
    public void borrarRevisiones() throws PersistenciaException {

        IConexion iConexion = iPoolConexiones.obtenerConexion(true);
        Connection con = iConexion.getCon();
        if(con == null){
            throw new PersistenciaException("No hay conexiones disponibles");
        }

        try {

            String query = consultas.borrarRevisiones();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            throw new PersistenciaException("Error al borrar las revisiones",e);
        }  finally {
            try {
                /* en cualquier caso, cierro la conexion */
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new PersistenciaException("Error al cerrando la conexion revision",e);
            }
        }
    }
}
