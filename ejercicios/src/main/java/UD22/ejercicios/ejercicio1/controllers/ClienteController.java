package UD22.ejercicios.ejercicio1.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;


import UD22.ejercicios.ejercicio1.models.Cliente;
import UD22.ejercicios.ejercicio1.services.ClienteService;
import UD22.ejercicios.ejercicio1.views.ListView;
import UD22.ejercicios.ejercicio1.views.UpdateView;

public class ClienteController implements ActionListener {

	private Cliente modelo;
	private ListView vista;
	private ClienteService service;

	public ClienteController(Cliente modelo, ListView vista, ClienteService service) {
		this.modelo = modelo;
		this.vista = vista;
		this.service = service;
	}

	public void iniciarVista() {
		printearClientes();
		vista.setTitle("Lista de Clientes");
		vista.setSize(1000, 800);
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
		crearActionListeners();
	}

	public void printearClientes() {
		List<Cliente> clientes = service.findAll();
		vista.generarClientes(clientes);
	}
	
	private void crearActionListeners() {
		Component[] components = vista.getClientesPanel().getComponents();
		for (Component component : components) {
			if (component instanceof JButton) {
				JButton button = (JButton) component;
				button.addActionListener(this);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Component[] components = vista.getClientesPanel().getComponents();
		for (Component component : components) {
			if (component instanceof JButton) {
				JButton button = (JButton) component;
				if (button == e.getSource()) {
					if (e.getActionCommand().equals("Delete")) {
						int clientId = (int) button.getClientProperty("clientID");
						service.delete(clientId);
						printearClientes();	
						crearActionListeners();
					}
					if (e.getActionCommand().equals("Update")) {
						int clientId = (int) button.getClientProperty("clientID");
						Cliente cliente = service.findById(clientId).get();
						System.out.println(cliente.getId());
						UpdateView updateView = new UpdateView(cliente);
						updateView.setVisible(true);
						service.update(cliente, "id");
						printearClientes();	
						crearActionListeners();
					}
				}
				
			}
		}
	}
}
