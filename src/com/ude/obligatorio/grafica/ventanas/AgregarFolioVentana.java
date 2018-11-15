package com.ude.obligatorio.grafica.ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.grafica.controladores.AgregarFolioControlador;

public class AgregarFolioVentana {

	private JFrame frame;
	private JTextField caratula;
	private JTextField codigo;
	private JTextField nrPaginas;
	private JLabel lblNoPaginas;
	private JLabel lblCaratula;
	private GraficaModel graficaM;
	private AgregarFolioControlador folioCon = new AgregarFolioControlador();


	/**
	 * Create the application.
	 */
	public AgregarFolioVentana() {
		initialize();
		setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 407, 241);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cancelar.setBounds(124, 150, 89, 23);
		frame.getContentPane().add(cancelar);
		
		JButton guardar = new JButton("Guardar");
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFolio();
			}
		});
		guardar.setBounds(223, 150, 89, 23);
		frame.getContentPane().add(guardar);
		
		JLabel lblAltaDeFolio = new JLabel("Alta de Folio");
		lblAltaDeFolio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAltaDeFolio.setBounds(130, 27, 159, 17);
		frame.getContentPane().add(lblAltaDeFolio);
	}
	
	public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
	private void addFolio() {
		graficaM = folioCon.addFolio(codigo.getText(), caratula.getText(), Integer.parseInt(nrPaginas.getText()));
		if(graficaM.getMensajeError() != null) {
			JOptionPane.showMessageDialog(frame, graficaM.getMensajeError(),"Error",JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(frame, graficaM.getMensajeExito(),"",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
}
