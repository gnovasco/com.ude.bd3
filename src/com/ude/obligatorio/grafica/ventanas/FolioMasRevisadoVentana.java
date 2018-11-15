package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.grafica.controladores.DarDescripcionControlador;
import com.ude.obligatorio.grafica.controladores.FolioMasRevisadoControlador;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class FolioMasRevisadoVentana {

	private JFrame frame;
	private JTable table;
	
	private DefaultTableModel tableModel;

	private GraficaModel graficaM;
	private FolioMasRevisadoControlador controlador = new FolioMasRevisadoControlador();

	/**
	 * Create the application.
	 */
	public FolioMasRevisadoVentana() {
		getDesc();
		initialize();
		setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable(tableModel);
		table.setBounds(30, 69, 375, 166);
		frame.getContentPane().add(table);
		
		JLabel lblFolioMasRevisado = new JLabel("Folio Mas Revisado");
		lblFolioMasRevisado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFolioMasRevisado.setBounds(117, 11, 161, 17);
		frame.getContentPane().add(lblFolioMasRevisado);
	}
	public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
	private void getDesc() {
		graficaM = controlador.getFolioMasRevisado();
		if(graficaM.getMensajeError() != null) {
			JOptionPane.showMessageDialog(frame, graficaM.getMensajeError(),"Error",JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				tableModel = buildTableModel(graficaM.getVoMaxRev());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frame, "Algo salio mal :(","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public DefaultTableModel buildTableModel(VOFolioMaxRev vo)
	        throws SQLException {

		Vector<String> columnNames = new Vector<String>();
	    columnNames.add("Codigo");
	    columnNames.add("Caratula");
	    columnNames.add("Paginas");
	    columnNames.add("Cantidad Revisiones");

	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    Vector<Object> vector = new Vector<Object>();
	    vector.add(vo.getCodigo());
	    vector.add(vo.getCaratula());
	    vector.add(vo.getPaginas());
	    vector.add(vo.getCantRevisiones());
	    data.add(vector);
	    vector = new Vector<Object>();
		
	    return new DefaultTableModel(data, columnNames);

	}
}
