package com.ude.obligatorio.grafica.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainVentana {

	private JFrame frame;
	private String[] options =  {"Agregar Folio", "Agregar Revision", 
			"Borrar Folio y Revisiones", "Dar Descripcion Revision", 
			"Ver Folio mas Revisado", "Listar Folios", "Listar Revisiones"};
	
	private JComboBox comboBox = new JComboBox();
	
	/**
	 * Create the application.
	 */
	public MainVentana() {
		initialize();
		setVisible(false);
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
	
		comboBox.setModel(new DefaultComboBoxModel(options));
		comboBox.setBounds(72, 67, 309, 22);
		frame.getContentPane().add(comboBox);
		
		//fillComboBox(comboBox);
		JButton btnIr = new JButton("Ir");
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToWindow();
			}
		});
		btnIr.setBounds(182, 121, 89, 23);
		frame.getContentPane().add(btnIr);
	}

	private void goToWindow() {
		String window = (String)comboBox.getSelectedItem();
		switch (window) {
        case "Agregar Folio":
        	AgregarFolioVentana folVen = new AgregarFolioVentana();
        	folVen.setVisible(true);
            break;
        case "Agregar Revision":
        	AgregarRevisionVentana revVen = new AgregarRevisionVentana();
        	revVen.setVisible(true);
            break;
        case "Borrar Folio y Revisiones":
        	BorrarFolioRevisionesVentana borRev = new BorrarFolioRevisionesVentana();
        	borRev.setVisible(true);
            break;
        case "Dar Descripcion Revision":
        	DarDescripcionVentana desRev = new DarDescripcionVentana();
        	desRev.setVisible(true);
            break;
        case "Ver Folio mas Revisado":
        	FolioMasRevisadoVentana folRev = new FolioMasRevisadoVentana();
        	folRev.setVisible(true);
            break;
        case "Listar Folios":
        	ListarFoliosVentana listFol = new ListarFoliosVentana();
        	listFol.setVisible(true);
            break;
        case "Listar Revisiones":
        	SeleccionarCodigoListaRevVentana listRev = new SeleccionarCodigoListaRevVentana();
        	listRev.setVisible(true);
            break;
        default:
            throw new IllegalArgumentException("Invalid day of the week: " + window);
		}
	}
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
