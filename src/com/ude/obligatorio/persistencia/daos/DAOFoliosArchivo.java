package com.ude.obligatorio.persistencia.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ude.obligatorio.configuracion.Configuracion;
import com.ude.obligatorio.logica.Folio;
import com.ude.obligatorio.logica.excepciones.FolioException;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;



public class DAOFoliosArchivo implements IDAOFolios{
	
	private String pathFolios;
	
	
    public DAOFoliosArchivo() throws FolioException{
    	try {
			pathFolios = Configuracion.getProperty("pathFolios");
		} catch (IOException e) {
			throw new FolioException("Error de archivo.");
		} 	
    } 
    
	public boolean member(IConexion con, String cod) throws PersistenciaException{				
		
        boolean isMember = false;
		
        try {
            String ruta = pathFolios + cod + ".txt"; 
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

            String ruta = pathFolios + folCod + ".txt";

            File file = new File(ruta);
            //System.out.println(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(folCod);
            bw.newLine();
            bw.write(folCar);
            bw.newLine();
            bw.write(folPagString);
            
            bw.close();            
            
            
        }
        catch (IOException e) {
			throw new PersistenciaException("Error de lectura del archivo");
		}  	
	}
	
	public Folio find(IConexion con, String cod) throws PersistenciaException, FolioException{
			
        String folCod, folCar;
        int folPag;
        Folio fol;
        
        try {
       
        	String ruta = pathFolios + cod + ".txt"; 	
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
    	
    	File file = null; 	
    	
    	try {
	    	//borramos revisiones del Folio
    		String pathRevisiones = Configuracion.getProperty("pathRevisiones");
	        
	        File carpeta = new File(pathRevisiones);
	        File[] archivos;
	        if(carpeta.exists()) {
	            if(carpeta.isDirectory()) {
	                archivos = carpeta.listFiles();
	                for(int i=0; i<archivos.length; i++) {
	                    if(archivos[i].getName().contains(cod)) {
	                    	file = new File(archivos[i].getPath());
	                    	file.delete();                           
	                    }
	                }
	            }
	        }
	        
	        //borramos el Folio
	    	String rutaFolios = pathFolios + cod + ".txt"; 
	    	file = new File(rutaFolios);
	    	file.delete();
    	} 
        catch (Exception e) {
			throw new PersistenciaException("Error de archivo", e);
		} 
       
	}

	@Override
	public List<VOFolio> listarFolios(IConexion con) throws PersistenciaException {

        String folCod, folCar;
        int folPag;
        List<VOFolio> folios = new ArrayList<>();		
        
        try {
        	
            String ext = "txt";
            File carpeta = new File(pathFolios);
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
	public boolean esVacio(IConexion con) {
		boolean res = false;
		
        File carpeta = new File(pathFolios);
        File[] archivos;
        
        if(carpeta.exists()) {
            if(carpeta.isDirectory()) {
                archivos = carpeta.listFiles();
                res = (archivos.length == 0);
            }
        }
        return res;
	}

	@Override
	public VOFolioMaxRev folioMasRevisado(IConexion con) throws PersistenciaException {


        VOFolioMaxRev foliosMaxRev = null;	
        String folCod, folCar;
        int folPag;
        
        int maxRev = 0;
        int cantRev = 0;
        
        try {

        	String pathRevisiones = Configuracion.getProperty("pathRevisiones");
        	
            File carpetaFolios = new File(pathFolios);
            File[] folios;
 
            File carpetaRevisiones = new File(pathRevisiones);
            File[] revisiones;  
                                  
            if(carpetaFolios.isDirectory()) {
                if(carpetaRevisiones.isDirectory()) {
                    folios = carpetaFolios.listFiles();
                    //recorremos todos los folios
                    for(int i=0; i<folios.length; i++) {

            			revisiones = carpetaRevisiones.listFiles();
            			//para cada folio, contamos sus revisiones
    	                for(int j=0; j<revisiones.length; j++) {
    	                    if(revisiones[j].getName().contains(folios[i].getName())) {
    	                    	cantRev++;
    	                    }
    	                }
    	                
    	                //si tiene más revisiones que el actual, actualizamos.
                    	if (cantRev > maxRev) {      	                
                            FileReader f = new FileReader(folios[i].getParentFile());
                            BufferedReader b = new BufferedReader(f);
                            
                            folCod = b.readLine();            
                            folCar = b.readLine();           
                            folPag = Integer.parseInt(b.readLine());           
                            b.close();
                       
                            foliosMaxRev = new VOFolioMaxRev(folCod, folCar, folPag, cantRev);
                    	}
                    	
                    	//reiniciamos contador.
                    	cantRev = 0;
                    	
                    }
                    
                }
            } 
        } 
        catch (Exception e) {
			throw new PersistenciaException("Error",e);
		}
        
        return foliosMaxRev;	
	}

}
