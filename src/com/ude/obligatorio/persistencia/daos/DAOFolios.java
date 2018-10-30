package com.ude.obligatorio.persistencia.daos;

import com.ude.obligatorio.logica.Folio;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.persistencia.consultas.Consultas;
import com.ude.obligatorio.poolConexiones.PoolConexiones;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOFolios {

    private Consultas consultas;
    private IPoolConexiones iPoolConexiones;

    public DAOFolios() {
        consultas = new Consultas();
        //TODO: traer los datos correspondientes y completarlos
        iPoolConexiones = PoolConexiones.getPoolConexiones("","","",10,"");
    }

    public boolean member(String cod) throws PersistenciaException {
        boolean isMember = false;
        try {

            IConexion iConexion = iPoolConexiones.obtenerConexion(true);
            Connection con = iConexion.getCon();

            String query = consultas.obtenerFolio();

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, cod);

            ResultSet rs = pstmt.executeQuery();
            isMember = rs.isBeforeFirst();
            pstmt.close();
        }
        catch (SQLException e) {
            throw new PersistenciaException("Error al intentar obtener un folio",e);
        }
        return isMember;
    }
    
    public void insert(Folio fol) throws PersistenciaException {
        try {

            IConexion iConexion = iPoolConexiones.obtenerConexion(true);
            Connection con = iConexion.getCon();

            String query = consultas.insertarFolio();

            PreparedStatement pstmt = con.prepareStatement(query);

            String folCod = fol.getCodigo();
            String folCar = fol.getCaratula();
            int folPag = fol.getPaginas();

            pstmt.setString(1, folCod);
            pstmt.setString(2, folCar);
            pstmt.setInt(3,folPag);

            pstmt.executeUpdate();

            pstmt.close();

        }
        catch (SQLException e) {
            throw new PersistenciaException("Error al intentar agregar un folio",e);
        }
    }
}
