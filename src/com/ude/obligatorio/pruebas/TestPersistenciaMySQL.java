package com.ude.obligatorio.pruebas;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;

import com.ude.obligatorio.logica.Folio;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.persistencia.daos.DAOFoliosMySQL;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.ConexionMySQL;

public class TestPersistenciaMySQL {
	
	
	public static void main( String args[] ) {
		String url = "jdbc:mysql://localhost:3306/Estudio";
		String driver = "com.mysql.jdbc.Driver";
		Connection con;
		IConexion icon;
		
		//creamos folios
		try {
			con = DriverManager.getConnection(url, "root", "root");
			icon = new ConexionMySQL(con);
			Folio f1  = new Folio("FGH-0015", "La comuna contra la señora con 38 gatos", 5);
			Folio f2  = new Folio("BBD-1278", "Otro folio de prueba", 2);
			
			DAOFoliosMySQL folios = new DAOFoliosMySQL();
			
			folios.insert(icon, f1);
			
		} 
		catch (SQLException | FolioException | PersistenciaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		
		
/*CREACION DE BASE PARA PRUEBA
		try
		{		

			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
	

			String url = "jdbc:mysql://localhost:3306/";
			Connection con = DriverManager.getConnection(url, "root", "root");
	

			String crearBD = "CREATE DATABASE `Estudio`";
			PreparedStatement pstCrearBD = con.prepareStatement(crearBD);
			int cant = pstCrearBD.executeUpdate();
			pstCrearBD.close();
	

			url = "jdbc:mysql://localhost:3306/Estudio";
			con = DriverManager.getConnection(url, "root", "root");
	
			Statement stmt = con.createStatement();
			String query = "CREATE TABLE Folios (codigo VARCHAR(60), caratula VARCHAR(60), paginas INT)";
			cant = stmt.executeUpdate(query);
			System.out.println("Resultado de " + query);
	
			//stmt = con.createStatement();
			query = "CREATE TABLE Revisiones (numero INT, codigoFolio VARCHAR(60), descripcion VARCHAR(60))";
			cant = stmt.executeUpdate(query);
			System.out.println("Resultado de " + query);
	
	        query = "INSERT INTO Estudio.Folios VALUES ('FGH-0015', 'La comuna contra la señora con 38 gatos', 5), " +
	            "('BBD-1278', 'Adolescentes descontrolados hasta las 5 AM', 2), " +
	            "('JJ-202', 'Vecinos reclaman por heces de perro en el hall', 9), " +
	            "('CEFJ-63', 'Vecinas rivales se tiran macetas con frecuencia', 463)";
			cant = stmt.executeUpdate(query);
			System.out.println("Resultado de " + query);
	

			stmt.close();

			con.close();		
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
*/	
	}
		
}
