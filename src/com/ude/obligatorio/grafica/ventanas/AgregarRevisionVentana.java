package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AgregarRevisionVentana {

	private JFrame frame;
	private JTextField descFol;
	private JTextField codFol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarRevisionVentana window = new AgregarRevisionVentana();
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
	public AgregarRevisionVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 429, 211);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescripcion.setBounds(35, 64, 83, 17);
		frame.getContentPane().add(lblDescripcion);
		
		descFol = new JTextField();
		descFol.setColumns(10);
		descFol.setBounds(140, 64, 159, 20);
		frame.getContentPane().add(descFol);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(123, 138, 89, 23);
		frame.getContentPane().add(cancelar);
		
		JButton guardar = new JButton("Guardar");
		guardar.setBounds(222, 138, 89, 23);
		frame.getContentPane().add(guardar);
		
		JLabel lblAltaDeRevision = new JLabel("Alta de Revision");
		lblAltaDeRevision.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAltaDeRevision.setBounds(128, 24, 159, 17);
		frame.getContentPane().add(lblAltaDeRevision);
		
		JLabel lblCodigoFolio = new JLabel("Codigo Folio:");
		lblCodigoFolio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigoFolio.setBounds(35, 97, 98, 17);
		frame.getContentPane().add(lblCodigoFolio);
		
		codFol = new JTextField();
		codFol.setColumns(10);
		codFol.setBounds(140, 97, 159, 20);
		frame.getContentPane().add(codFol);
	}

}
