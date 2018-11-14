package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainVentana {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainVentana window = new MainVentana();
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
	public MainVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 213);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGestionDeFolios = new JLabel("Gestion de Folios");
		lblGestionDeFolios.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGestionDeFolios.setBounds(146, 21, 156, 17);
		frame.getContentPane().add(lblGestionDeFolios);
		
List<String> ls = new ArrayList<String>(); 
		
		ls.add("Agregar Folio");
		ls.add("Agregar Revision");
		ls.add("Borrar Folio y Revisiones");
		ls.add("Dar Descripcion Revision");
		ls.add("Ver Folio mas Revisado");
		ls.add("Listar Folios");
		ls.add("Listar Revisiones");
		
		JComboBox comboBox = new JComboBox(ls.toArray());
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Agregar Folio", "Agregar Revision", "Borrar Folio y Revisione", "Dar Descripcion Revision", "Ver Folio mas Revisado", "Listar Folios", "Listar Revisiones"}));
		comboBox.setBounds(72, 67, 309, 22);
		frame.getContentPane().add(comboBox);
		
		//fillComboBox(comboBox);
		JButton btnIr = new JButton("Ir");
		btnIr.setBounds(182, 121, 89, 23);
		frame.getContentPane().add(btnIr);
	}
	
	private void fillComboBox(JComboBox comboBox) {
		List<String> ls = new ArrayList<String>(); 
		
		ls.add("Agregar Folio");
		ls.add("Agregar Revision");
		ls.add("Borrar Folio y Revisiones");
		ls.add("Dar Descripcion Revision");
		ls.add("Ver Folio mas Revisado");
		ls.add("Listar Folios");
		ls.add("Listar Revisiones");
		
		comboBox.setModel(new DefaultComboBoxModel(ls.toArray()));
	}
}
