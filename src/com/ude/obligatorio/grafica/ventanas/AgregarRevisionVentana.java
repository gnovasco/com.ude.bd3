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
import com.ude.obligatorio.grafica.controladores.AgregarRevisionesControlador;

public class AgregarRevisionVentana {

	private JFrame frame;
	private JTextField descFol;
	private JTextField codFol;
	private GraficaModel graficaM;
	private AgregarRevisionesControlador controlador = new AgregarRevisionesControlador();


	/**
	 * Create the application.
	 */
	public AgregarRevisionVentana() {
		initialize();
		setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 429, 211);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cancelar.setBounds(123, 138, 89, 23);
		frame.getContentPane().add(cancelar);
		
		JButton guardar = new JButton("Guardar");
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRevision();
			}
		});
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
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
    }
	
	private void addRevision() {
		graficaM = controlador.addRevision(descFol.getText(), codFol.getText());
		if(graficaM.getMensajeError() != null) {
			JOptionPane.showMessageDialog(frame, graficaM.getMensajeError(),"Error",JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(frame, graficaM.getMensajeExito(),"",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
