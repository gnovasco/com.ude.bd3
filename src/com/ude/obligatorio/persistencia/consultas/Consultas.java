package com.ude.obligatorio.persistencia.consultas;

public class Consultas {

    // consultas Folio
    public String insertarFolio() {
        return "INSERT INTO Folio (codigo, caratula, paginas) VALUES (?, ?, ?)";
    }
    
    public String listarFolios() {
        return "SELECT * FROM Folios";
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
    
    public String borrarRevisiones() {
        return "DELETE FROM Revision";
    }
    
    public String listarRevisiones() {
        return "SELECT * FROM Revisiones WHERE codFolio = ? SORT BY numero";
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
