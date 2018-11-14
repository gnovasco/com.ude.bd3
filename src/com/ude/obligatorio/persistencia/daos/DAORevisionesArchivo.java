package com.ude.obligatorio.persistencia.daos;

import com.ude.obligatorio.logica.Folio;
import com.ude.obligatorio.logica.Revision;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VORevision;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DAORevisionesArchivo implements IDAORevisiones{
	
	private String codigoFolio;

    public DAORevisionesArchivo(String codFol) {
    	codigoFolio = codFol;
    } 	
	
	public int largo(IConexion iConexion) {
		int cantRev = 0;
		
    	String rutaRevisiones = "/archivos/revisiones/";
    	
        File carpetaRevisiones = new File(rutaRevisiones);
        File[] revisiones;
        
        if(carpetaRevisiones.isDirectory()) {
	        revisiones = carpetaRevisiones.listFiles();
	        for(int i=0; i<revisiones.length; i++) {
	        	if(revisiones[i].getName().contains(codigoFolio)) {
	        		cantRev++;
	        	}
	        }
        }
        
        return cantRev;
	}
	
	public List<VORevision> listarRevisiones(IConexion iConexion) throws PersistenciaException {
        String revDesc;
        int revNum;
        List<VORevision> revisiones = new ArrayList<>();
        
    	String rutaRevisiones = "/archivos/revisiones/";
    	
        File carpetaRevisiones = new File(rutaRevisiones);
        File[] archivos;
        
        try {
	        if(carpetaRevisiones.isDirectory()) {
		        archivos = carpetaRevisiones.listFiles();
		        for(int i=0; i<archivos.length; i++) {
		        	if(archivos[i].getName().contains(codigoFolio)) {
			        	
		                FileReader f = new FileReader(archivos[i].getParentFile());
		                BufferedReader b = new BufferedReader(f);
		                	                           
		                revNum = Integer.parseInt(b.readLine());  
		                revDesc = b.readLine();
		                
		                b.close();
		           
		                revisiones.add(new VORevision(revNum, revDesc));
		        	}
	                
		        }
	        }
        }
        catch (IOException e) {
        	throw new PersistenciaException("Error de archivos");
		}
        
        return revisiones;
        
	}
	
	public void borrarRevisiones(IConexion iConexion) throws PersistenciaException {
    	String rutaRevisiones = "/archivos/revisiones/";
    	
        File carpetaRevisiones = new File(rutaRevisiones);
        File[] archivos;
        
        try {
	        if(carpetaRevisiones.isDirectory()) {
		        archivos = carpetaRevisiones.listFiles();
		        for(int i=0; i<archivos.length; i++) {
		        	if(archivos[i].getName().contains(codigoFolio)) {		        	
			        	File file = new File(archivos[i].getPath());
	                	file.delete();
		        	}
		        }
	        }
        }
        catch (Exception e) {
        	throw new PersistenciaException("Error de archivos");
		}
	}

	@Override
	public void insBack(IConexion iConexion, Revision rev) throws PersistenciaException {
		int cantRev = largo(iConexion);
		String numRev = Integer.toString(cantRev++);

        String ruta = "/archivos/revisiones/" + numRev + codigoFolio + ".txt";

        try {
	        File file = new File(ruta);
	        // Si el archivo no existe es creado
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        
	        FileWriter fw = new FileWriter(file);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(rev.getNumero());
	        bw.write(rev.getDescripcion());
	        bw.write(codigoFolio);
	        
	        bw.close(); 
		}
	    catch (IOException e) {
	    	throw new PersistenciaException("Error de archivos");
		}
		
		
	}

	@Override
	public Revision kesimo(IConexion iConexion, int numero) throws PersistenciaException {
		
		String numRev = Integer.toString(numero);
		Revision rev = null;
		
    	String rutaRevisiones = "/archivos/revisiones/";
    	
        File carpetaRevisiones = new File(rutaRevisiones);
        File[] archivos;
        
        try {
	        if(carpetaRevisiones.isDirectory()) {
		        archivos = carpetaRevisiones.listFiles();
		        
		        int i=0;
		        boolean encontrado = false;
		        while(i<archivos.length && !encontrado){ 
		        	if(archivos[i].getName().contains(numRev+"-"+codigoFolio)) {
		        		encontrado = true;

		                FileReader f = new FileReader(archivos[i].getParent());
		                BufferedReader b = new BufferedReader(f);
		                
		                b.readLine();
		                String desc = b.readLine();           
		                b.close();
		                
		                rev = new Revision(numero, desc);
	                	
		        	}
		        	i++;
		        }
	        }
        }
        catch (Exception e) {
        	throw new PersistenciaException("Error de archivos");
		}
        
        return rev;
	}
}	// DAORevisionesTexto
