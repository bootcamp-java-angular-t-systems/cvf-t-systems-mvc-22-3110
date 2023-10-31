package UD22.ejercicios.ejercicio1.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import UD22.ejercicios.ejercicio1.models.Cliente;
import UD22.ejercicios.ejercicio1.views.AdminView;

public class ClienteController implements ActionListener{
	
	private Cliente modelo;
	private AdminView vista;
	
	public ClienteController(Cliente modelo, AdminView vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	
	public void iniciarVista() {
		vista.setTitle("Lista de Clientes");
		vista.pack();
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
