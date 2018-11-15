package com.ude.obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.ude.obligatorio.grafica.GraficaModel;
import com.ude.obligatorio.grafica.controladores.AgregarRevisionesControlador;
import com.ude.obligatorio.grafica.controladores.BorrarFolioRevisionesControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrarFolioRevisionesVentana {

	private JFrame frame;
	private JTextField codigo;
	private GraficaModel graficaM;
	private BorrarFolioRevisionesControlador controlador = new BorrarFolioRevisionesControlador();


	/**
	 * Create the application.
	 */
	public BorrarFolioRevisionesVentana() {
		initialize();
		setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 370, 185);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setBounds(79, 95, 89, 23);
		frame.getContentPane().add(button);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRev();
			}
		});
		btnBorrar.setBounds(178, 95, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		JLabel lblBorrarFoliosY = new JLabel("Borrar Folios y Revisiones");
		lblBorrarFoliosY.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBorrarFoliosY.setBounds(69, 11, 233, 17);
		frame.getContentPane().add(lblBorrarFoliosY);
	}
	public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
	private void deleteRev() {
		graficaM = controlador.deleteRev(codigo.getText());
		if(graficaM.getMensajeError() != null) {
			JOptionPane.showMessageDialog(frame, graficaM.getMensajeError(),"Error",JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(frame, graficaM.getMensajeExito(),"",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
