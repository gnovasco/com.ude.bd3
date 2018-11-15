package com.ude.obligatorio.grafica.ventanas;

import java.awt.Font;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.grafica.controladores.ListarFoliosControlador;
import com.ude.obligatorio.logica.valueObjects.VOFolio;

public class ListarFoliosVentana {

	private JFrame frame;
	private JTable table;
	
	private DefaultTableModel tableModel;
	
	private GraficaModel graficaM;
	private ListarFoliosControlador controlador = new ListarFoliosControlador();

	

	/**
	 * Create the application.
	 */
	public ListarFoliosVentana() {
		listarFolios();
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
		table.setBounds(31, 68, 375, 166);
		frame.getContentPane().add(table);
		
		JLabel lblListadoDeFolios = new JLabel("Listado de Folios");
		lblListadoDeFolios.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListadoDeFolios.setBounds(117, 11, 161, 17);
		frame.getContentPane().add(lblListadoDeFolios);
	}
	public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
	
	private void listarFolios() {
		graficaM = controlador.getFolios();
		if(graficaM.getMensajeError() != null) {
			JOptionPane.showMessageDialog(frame, graficaM.getMensajeError(),"Error",JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				tableModel = buildTableModel(graficaM.getListFol());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frame, "Algo salio mal :(","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public static DefaultTableModel buildTableModel(List<VOFolio> listaVOF)
	        throws SQLException {

		Vector<String> columnNames = new Vector<String>();
	    columnNames.add("Codigo");
	    columnNames.add("Caratula");
	    columnNames.add("Paginas");

	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    for(VOFolio voFolio : listaVOF) {
	        Vector<Object> vector = new Vector<Object>();
	        vector.add(voFolio.getCodigo());
	        vector.add(voFolio.getCaratula());
	        vector.add(voFolio.getPaginas());
	        data.add(vector);
	    }
	    return new DefaultTableModel(data, columnNames);
		
	}

}
