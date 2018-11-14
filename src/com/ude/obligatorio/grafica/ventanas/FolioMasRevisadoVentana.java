package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class FolioMasRevisadoVentana {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FolioMasRevisadoVentana window = new FolioMasRevisadoVentana();
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
	public FolioMasRevisadoVentana() {
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
		table.setBounds(30, 69, 375, 166);
		frame.getContentPane().add(table);
		
		JLabel lblFolioMasRevisado = new JLabel("Folio Mas Revisado");
		lblFolioMasRevisado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFolioMasRevisado.setBounds(117, 11, 161, 17);
		frame.getContentPane().add(lblFolioMasRevisado);
	}
}
