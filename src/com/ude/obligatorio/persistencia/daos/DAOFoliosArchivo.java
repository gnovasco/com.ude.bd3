package com.ude.obligatorio.persistencia.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ude.obligatorio.logica.Folio;
import com.ude.obligatorio.logica.excepciones.LogicaException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;



public class DAOFoliosArchivo implements IDAOFolios{
	
	private IPoolConexiones iPoolConexiones;

    public DAOFoliosArchivo() {
        //iPoolConexiones = PoolConexiones.getPoolConexiones("","","",10,"");
    } 
    
	public boolean member(IConexion con, String cod) throws PersistenciaException{				
		
        boolean isMember = false;
		
        try {
            String ruta = "/archivos/folios/" + cod + ".txt"; //importar ruta desde ConexionArchivo
            File file = new File(ruta);

            if (file.exists()) {
            	isMember = true;
            }
        } 
        catch (Exception e) {
        	throw new PersistenciaException("Error de lectura de archivo."); 
		}
        
        return isMember;
        
	}
	
	public void insert(IConexion con, Folio fol)  throws PersistenciaException{
				
        String folCod, folCar;
        int folPag;
        
        try {

            folCod = fol.getCodigo();
            folCar = fol.getCaratula();
            folPag = fol.getPaginas();
            
            String folPagString = Integer.toString(folPag);

            String ruta = "/archivos/folios/" + folCod + ".txt";

            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(folCod);
            bw.write(folCar);
            bw.write(folPagString);
            
            bw.close();            
            
            
        }
        catch (IOException e) {
			throw new PersistenciaException("Error de lectura del archivo");
		}  	
	}
	
	public Folio find(IConexion con, String cod) throws PersistenciaException{
			
        String folCod, folCar;
        int folPag;
        Folio fol;
        
        try {
       
        	String ruta = "/archivos/folios/" + cod + ".txt"; 	
            FileReader f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);
            
            folCod = b.readLine();            
            folCar = b.readLine();           
            folPag = Integer.parseInt(b.readLine());           
            b.close();
            
            fol = new Folio(folCod, folCar, folPag);

        } 
        catch (FileNotFoundException e) {
			throw new PersistenciaException("Error el archivo no existe");
		} 
        catch (IOException e) {
			throw new PersistenciaException("Error de lectura del archivo");
		}
        
        return fol;
	}
	
    public void delete(IConexion con, String cod) throws PersistenciaException{
    	 	
        try {
        	String ruta = "/archivos/folios/" + cod + ".txt"; 
        	File file = new File(ruta);
        	file.delete();
        }
	}

	@Override
	public List<VOFolio> listarFolios() throws PersistenciaException {

        String folCod, folCar;
        int folPag;
        List<VOFolio> folios = new ArrayList<>();		
        
        try {
        	
            String ruta = "/archivos/folios/";
            String ext = "txt";
            File carpeta = new File(ruta);
            File[] archivos;
            if(carpeta.exists()) {
                if(carpeta.isDirectory()) {
                    archivos = carpeta.listFiles();
                    for(int i=0; i<archivos.length; i++) {
                        if(archivos[i].getName().endsWith(ext)) {
                            
                            FileReader f = new FileReader(archivos[i].getParentFile());
                            BufferedReader b = new BufferedReader(f);
                            
                            folCod = b.readLine();            
                            folCar = b.readLine();           
                            folPag = Integer.parseInt(b.readLine());           
                            b.close();
                       
                            folios.add(new VOFolio(folCod, folCar, folPag));
                        }
                    }
                }
            } 
        } 
        catch (IOException e) {
			throw new PersistenciaException("Error de permisos");
		}
        
        return folios;       
	}

	@Override
	public boolean esVacio() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VOFolioMaxRev folioMasRevisado() {

        String folCod, folCar;
        int folPag;
        
        String ruta = "/archivos/folios/";
        String ext = "txt";
        File carpeta = new File(ruta);
        File[] archivos;
        if(carpeta.exists()) {
            if(carpeta.isDirectory()) {
                archivos = carpeta.listFiles();
                for(int i=0; i<archivos.length; i++) {
                    if(archivos[i].getName().endsWith(ext)) {
                        
                        FileReader f = new FileReader(archivos[i].getParentFile());
                        BufferedReader b = new BufferedReader(f);
                        
                        folCod = b.readLine();            
                        folCar = b.readLine();           
                        folPag = Integer.parseInt(b.readLine());           
                        b.close();
                   
                        folios.add(new VOFolio(folCod, folCar, folPag));
                    }
                }
            }
        } 		
		
	}

}
