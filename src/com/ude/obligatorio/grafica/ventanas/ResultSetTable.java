package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ResultSetTable {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					ResultSetTable window = new ResultSetTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResultSetTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ResultSet rs = null;
		
		try {
			table = new JTable(buildTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setBounds(34, 46, 375, 166);
		frame.getContentPane().add(table);
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    /*ResultSetMetaData metaData = rs.getMetaData();

	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }*/
		
		Vector<String> columnNames = new Vector<String>();
	    columnNames.add("id");
	    columnNames.add("nombre");
	    columnNames.add("edad");
	    
	    
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    Vector<Object> vector = new Vector<Object>();
	    vector.add("1");
	    vector.add("Dario");
	    vector.add("33");
	    data.add(vector);
	    vector = new Vector<Object>();
	    vector.add("2");
	    vector.add("Jose");
	    vector.add("52");
	    data.add(vector);
	    vector = new Vector<Object>();
	    vector.add("3");
	    vector.add("marta");
	    vector.add("22");
	    data.add(vector);
	    return new DefaultTableModel(data, columnNames);

	}
}
