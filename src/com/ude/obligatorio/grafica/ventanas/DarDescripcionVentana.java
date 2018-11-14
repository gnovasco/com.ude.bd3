package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DarDescripcionVentana {

	private JFrame frame;
	private JTextField codigo;
	private JTextField revision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarDescripcionVentana window = new DarDescripcionVentana();
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
	public DarDescripcionVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 413, 211);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(132, 52, 159, 20);
		frame.getContentPane().add(codigo);
		
		revision = new JTextField();
		revision.setColumns(10);
		revision.setBounds(132, 80, 159, 20);
		frame.getContentPane().add(revision);
		
		JLabel lblNoRevision = new JLabel("No Revision:");
		lblNoRevision.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoRevision.setBounds(30, 83, 92, 17);
		frame.getContentPane().add(lblNoRevision);
		
		JLabel label_1 = new JLabel("Codigo:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(30, 52, 83, 17);
		frame.getContentPane().add(label_1);
		
		JLabel lblDescripcionDeRevision = new JLabel("Descripcion de Revision");
		lblDescripcionDeRevision.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescripcionDeRevision.setBounds(111, 11, 198, 17);
		frame.getContentPane().add(lblDescripcionDeRevision);
		
		JButton button = new JButton("Cancelar");
		button.setBounds(123, 122, 89, 23);
		frame.getContentPane().add(button);
		
		JButton btnIngresar = new JButton("Ver");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnIngresar.setBounds(220, 122, 89, 23);
		frame.getContentPane().add(btnIngresar);
	}

}
