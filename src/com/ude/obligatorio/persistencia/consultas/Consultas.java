package com.ude.obligatorio.persistencia.consultas;

public class Consultas {

    // consultas Folio
    public String insertarFolio() {
        return "INSERT INTO Folios (codigo, caratula, paginas) VALUES (?, ?, ?)";
    }
    
    public String listarFolios() {
        return "SELECT * FROM Folios ORDER BY codigo";
    }
    
    public String obtenerFolioMasRevisado() {
        return "SELECT MAX(cantRevisiones) FROM FolioMasRev";
    }
    
    public String obtenerFolio() {
        return "SELECT * FROM Folios WHERE codigo = ?";
    }

    // consultas reviones
    public String insertarRevision() {
        return "INSERT INTO Revisiones (numero, descripcion) VALUES (?, ?)";
    }
    
    public String borrarFolio() {
        return "DELETE FROM Folios WHERE codigo = ?";
    }
    
    public String borrarFolioRevisiones() {
        return "DELETE FROM Revisiones WHERE codigoFolio = ?";
    }
    
    public String listarRevisiones() {
        return "SELECT * FROM Revisiones WHERE codFolio = ? ORDER BY numero";
    }
    
    public String cantidadRevisiones() {
        return "SELECT COUNT(*) total FROM Revisiones";
    }
    
    public String obtenerRevision() {
        return "SELECT * FROM Revisiones WHERE numero = ?";
    }
    
    public String obtenerDescripcionRevision() {
        return "SELECT descripcion FROM Revisiones WHERE codigoFolio = ? AND numero = ?";
    }
}
