package com.ude.obligatorio;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.ude.obligatorio.grafica.ventanas.MainVentana;

public class Main {

	public static void main(String[] args) {
/*		
		//CREACION DE BASE PARA PRUEBA
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
	
	 //       query = "INSERT INTO Estudio.Folios VALUES ('FGH-0015', 'La comuna contra la señora con 38 gatos', 5), " +
	 //           "('JJ-202', 'Vecinos reclaman por heces de perro en el hall', 9), " +
	  //          "('CEFJ-63', 'Vecinas rivales se tiran macetas con frecuencia', 463)";
	//		cant = stmt.executeUpdate(query);
	//		System.out.println("Resultado de " + query);
	
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
		
		MainVentana mainVen = new MainVentana();
		mainVen.setVisible(true);
	}

}