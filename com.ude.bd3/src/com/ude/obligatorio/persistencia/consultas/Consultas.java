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
        return "INSERT INTO Revision (numero, descripcion) VALUES (?,?)";
    }
    public String borrarRevisiones() {
        return "DELETE FROM Revision";
    }
    public String listarRevisiones() {
        return "SELECT * FROM Revision";
    }
    public String cantidadRevisiones() {
        return "SELECT COUNT(*) total FROM Revisiones";
    }
    public String obtenerRevision() {
        return "SELECT * FROM Revision WHERE numero = ?";
    }
    public String obtenerDescripcionRevision() {
        return "SELECT descripcion FROM Revision WHERE codFolio = ? and numero = ?";
    }
}
