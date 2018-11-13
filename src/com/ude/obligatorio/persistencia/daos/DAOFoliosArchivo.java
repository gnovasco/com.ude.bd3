package com.ude.obligatorio.persistencia.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.ude.obligatorio.logica.Folio;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;



public class DAOFoliosTexto implements IDAOFolios{
	
	private IPoolConexiones iPoolConexiones;

    public DAOFoliosTexto() {
        //iPoolConexiones = PoolConexiones.getPoolConexiones("","","",10,"");
    } 
    
	public boolean member(String cod) throws PersistenciaException{
		
        IConexion iConexion = iPoolConexiones.obtenerConexion(false);
        Connection con = iConexion.getCon();

        if (con == null) {
            throw new PersistenciaException("No hay conexiones disponibles.");
        }
		
		
        boolean isMember = false;
		
        try {
  
            String ruta = "/archivos/folios/" + cod + ".txt"; //importar luego de configuracion
            File file = new File(ruta);

            if (file.exists()) {
            	isMember = true;
            }
        } 
        catch (Exception e) {
        	throw new PersistenciaException("Error de lectura de archivo."); 
		}
        finally {
        	
            try {
                if (con != null)
                    con.close();
            }
            catch (Exception e) {
                throw new PersistenciaException("Error cerrando la conexion.", e);
            }
                      
        } 
        return isMember;
        
	}
	
	public void insert(Folio fol)  throws PersistenciaException{
		
        IConexion iConexion = iPoolConexiones.obtenerConexion(true);
        Connection con = iConexion.getCon();

        if (con == null) {
            throw new PersistenciaException("No hay conexiones disponibles.");
        }
		
		
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
        finally {
        	
            try {
                if (con != null)
                    con.close();
            }
            catch (Exception e) {
                throw new PersistenciaException("Error cerrando la conexion.", e);
            }
            
        }   	
	}
	
	public Folio find(String cod) throws PersistenciaException{
		
        IConexion iConexion = iPoolConexiones.obtenerConexion(false);
        Connection con = iConexion.getCon();

        if (con == null) {
            throw new PersistenciaException("No hay conexiones disponibles.");
        }        
 		
		
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
        finally {
        	
            try {
                if (con != null)
                    con.close();
            }
            catch (Exception e) {
                throw new PersistenciaException("Error cerrando la conexion.", e);
            }
                      
        }	
        
        return fol;
	}
	
    public void delete(String cod) throws PersistenciaException{
    	
        IConexion iConexion = iPoolConexiones.obtenerConexion(false);
        Connection con = iConexion.getCon();

        if (con == null) {
            throw new PersistenciaException("No hay conexiones disponibles.");
        }  
        
    	
        try {
        	String ruta = "/archivos/folios/" + cod + ".txt"; 
        	File file = new File(ruta);
        	file.delete();
        }
        finally {
        	
            try {
                if (con != null)
                    con.close();
            }
            catch (Exception e) {
                throw new PersistenciaException("Error cerrando la conexion.", e);
            }
            
        }
	}

	@Override
	public List<VOFolio> listarFolios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean esVacio() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VOFolioMaxRev folioMasRevisado() {
		// TODO Auto-generated method stub
		return null;
	}

}
