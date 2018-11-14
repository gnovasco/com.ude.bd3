package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class AgregarFolioVentana {

	private JFrame frame;
	private JTextField caratula;
	private JTextField codigo;
	private JTextField nrPaginas;
	private JLabel lblNoPaginas;
	private JLabel lblCaratula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarFolioVentana window = new AgregarFolioVentana();
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
	public AgregarFolioVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 407, 241);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		caratula = new JTextField();
		caratula.setBounds(114, 86, 159, 20);
		frame.getContentPane().add(caratula);
		caratula.setColumns(10);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(114, 55, 159, 20);
		frame.getContentPane().add(codigo);
		
		nrPaginas = new JTextField();
		nrPaginas.setColumns(10);
		nrPaginas.setBounds(114, 117, 46, 20);
		frame.getContentPane().add(nrPaginas);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(22, 58, 83, 17);
		frame.getContentPane().add(lblCodigo);
		
		lblNoPaginas = new JLabel("No Paginas:");
		lblNoPaginas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoPaginas.setBounds(22, 120, 83, 17);
		frame.getContentPane().add(lblNoPaginas);
		
		lblCaratula = new JLabel("Caratula:");
		lblCaratula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCaratula.setBounds(22, 89, 83, 17);
		frame.getContentPane().add(lblCaratula);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(124, 150, 89, 23);
		frame.getContentPane().add(cancelar);
		
		JButton guardar = new JButton("Guardar");
		guardar.setBounds(223, 150, 89, 23);
		frame.getContentPane().add(guardar);
		
		JLabel lblAltaDeFolio = new JLabel("Alta de Folio");
		lblAltaDeFolio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAltaDeFolio.setBounds(130, 27, 159, 17);
		frame.getContentPane().add(lblAltaDeFolio);
	}
}
