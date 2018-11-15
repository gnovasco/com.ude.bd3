package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.grafica.controladores.BorrarFolioRevisionesControlador;
import com.ude.obligatorio.grafica.controladores.DarDescripcionControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DarDescripcionVentana {

	private JFrame frame;
	private JTextField codigo;
	private JTextField revision;
	private GraficaModel graficaM;
	private DarDescripcionControlador controlador = new DarDescripcionControlador();


	/**
	 * Create the application.
	 */
	public DarDescripcionVentana() {
		initialize();
		setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 413, 211);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setBounds(123, 122, 89, 23);
		frame.getContentPane().add(button);
		
		JButton btnIngresar = new JButton("Ver");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getDesc();
			}
		});
		btnIngresar.setBounds(220, 122, 89, 23);
		frame.getContentPane().add(btnIngresar);
	}
	public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
	private void getDesc() {
		graficaM = controlador.getDescription(codigo.getText(),Integer.parseInt(revision.getText()));
		if(graficaM.getMensajeError() != null) {
			JOptionPane.showMessageDialog(frame, graficaM.getMensajeError(),"Error",JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(frame, graficaM.getDesc(),"",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
