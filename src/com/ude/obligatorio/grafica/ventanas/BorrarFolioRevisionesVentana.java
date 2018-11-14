package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class BorrarFolioRevisionesVentana {

	private JFrame frame;
	private JTextField codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrarFolioRevisionesVentana window = new BorrarFolioRevisionesVentana();
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
	public BorrarFolioRevisionesVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 370, 185);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(95, 58, 159, 20);
		frame.getContentPane().add(codigo);
		
		JLabel label = new JLabel("Codigo:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(21, 58, 83, 17);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("Cancelar");
		button.setBounds(79, 95, 89, 23);
		frame.getContentPane().add(button);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(178, 95, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		JLabel lblBorrarFoliosY = new JLabel("Borrar Folios y Revisiones");
		lblBorrarFoliosY.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBorrarFoliosY.setBounds(69, 11, 233, 17);
		frame.getContentPane().add(lblBorrarFoliosY);
	}

}
