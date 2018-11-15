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
import com.ude.obligatorio.logica.Revision;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.LogicaException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.persistencia.daos.DAOFoliosArchivo;
import com.ude.obligatorio.persistencia.daos.DAOFoliosMySQL;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.ConexionMySQL;

public class TestPersistenciaArchivo {
	
	
	public static void main( String args[] ) {
		
		IConexion icon = null;
		
		//creamos folios
		try {

			Folio f1  = new Folio("FGH-0015", "La comuna contra la señora con 38 gatos", 5);
			Folio f2  = new Folio("BBD-1278", "Otro folio de prueba", 2);
			
			
			
			DAOFoliosArchivo folios = new DAOFoliosArchivo();
			
			folios.insert(icon, f1);
			folios.insert(icon, f2);
			
			if (folios.member(icon, f1.getCodigo()))
				System.out.println("lujo!");
			
			if (folios.member(icon, f2.getCodigo()))
				System.out.println("lujo!");
			
			Folio f3 = folios.find(icon, f1.getCodigo());
			folios.insert(icon, f3);
			
			folios.delete(icon, f3.getCodigo());
			
			if (folios.esVacio(icon))
				System.out.println("no hay folios!");
			else
				System.out.println("hay folios!");
			
			folios.delete(icon, f2.getCodigo());
				
			if (folios.esVacio(icon))
				System.out.println("no hay folios!");
			else
				System.out.println("hay folios!");	
			
			Folio f4  = new Folio("GGN-1278", "Otro folio de prueba", 69);
			folios.insert(icon, f4);
			
			int cantRev = f4.cantidadRevisiones(icon);
			
			String cantRevStr = Integer.toString(cantRev);
			System.out.println(cantRevStr);
			
			//intenta borrar revisiones cuando no las tiene
			f4.borrarRevisiones(icon);
			
			Revision rev1 = new Revision(++cantRev, "De prueba");
			f4.addRevision(icon, rev1);
			
			cantRev = f4.cantidadRevisiones(icon);			
			cantRevStr = Integer.toString(cantRev);
			System.out.println(cantRevStr);	
			
			//borra todas las revisiones
			f4.borrarRevisiones(icon);
			
		} 
		catch (FolioException | PersistenciaException | LogicaException e1) {
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
