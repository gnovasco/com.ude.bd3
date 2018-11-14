package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ListarRevisionesVentana {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarRevisionesVentana window = new ListarRevisionesVentana();
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
	public ListarRevisionesVentana() {
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
		
		JLabel lblListadoDeRevisiones = new JLabel("Listado de Revisiones");
		lblListadoDeRevisiones.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListadoDeRevisiones.setBounds(115, 11, 216, 17);
		frame.getContentPane().add(lblListadoDeRevisiones);
		
		table = new JTable((TableModel) null);
		table.setBounds(32, 68, 375, 166);
		frame.getContentPane().add(table);
	}

}
