package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ListarFoliosVentana {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarFoliosVentana window = new ListarFoliosVentana();
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
	public ListarFoliosVentana() {
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
		
		table = new JTable((TableModel) null);
		table.setBounds(31, 68, 375, 166);
		frame.getContentPane().add(table);
		
		JLabel lblListadoDeFolios = new JLabel("Listado de Folios");
		lblListadoDeFolios.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListadoDeFolios.setBounds(117, 11, 161, 17);
		frame.getContentPane().add(lblListadoDeFolios);
	}

}
