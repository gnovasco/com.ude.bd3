package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.ude.obligatorio.grafica.controladores.ListarRevisionesControlador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionarCodigoListaRevVentana {

	private JFrame frame;
	private JTextField codigo;
	


	/**
	 * Create the application.
	 */
	public SeleccionarCodigoListaRevVentana() {
		initialize();
		setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 437, 169);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblListadoDeRevisiones = new JLabel("Listado de revisiones");
		lblListadoDeRevisiones.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListadoDeRevisiones.setBounds(104, 11, 233, 17);
		frame.getContentPane().add(lblListadoDeRevisiones);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(130, 58, 159, 20);
		frame.getContentPane().add(codigo);
		
		JLabel label_1 = new JLabel("Codigo:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(56, 58, 83, 17);
		frame.getContentPane().add(label_1);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarRevisionesVentana listarRev = new ListarRevisionesVentana(codigo.getText());
				listarRev.setVisible(true);
			}
		});
		btnListar.setBounds(228, 89, 89, 23);
		frame.getContentPane().add(btnListar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(129, 89, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}
	public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

}
