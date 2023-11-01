package UD22.ejercicios.ejercicio1.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import UD22.ejercicios.ejercicio1.models.Cliente;
import UD22.ejercicios.ejercicio1.services.ClienteService;
import UD22.ejercicios.ejercicio1.views.CreateView;
import UD22.ejercicios.ejercicio1.views.ListView;
import UD22.ejercicios.ejercicio1.views.UpdateView;

public class ClienteController implements ActionListener {

	private ListView vista;
	private ClienteService service;
	private UpdateView updateView;
	private CreateView createView;

	public ClienteController(ListView vista, ClienteService service) {
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
		vista.getBtnCrearCliente().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Component[] components = vista.getClientesPanel().getComponents();

		// Abre el formulario de creacion de cliente
		if (e.getActionCommand().equals("Crear cliente")) {
			createAction();
		}
		
		// Guarda el formulario y crea un nuevo cliente
		if (e.getActionCommand().equals("Guardar cliente")) {
			storeAction();
		}
		
		// Guarda la modificacion del cliente
		if (e.getActionCommand().equals("Almacenar cambios")) {
			updateAction();
		}

		for (Component component : components) {
			if (component instanceof JButton) {
				JButton button = (JButton) component;
				if (button == e.getSource()) {
					// Elimina un cliente
					if (e.getActionCommand().equals("Delete")) {
						int clientId = (int) button.getClientProperty("clientID");
						deleteAction(clientId);
					}
					// Abre el formulario de modificacion de un cliente
					if (e.getActionCommand().equals("Update")) {
						int clientId = (int) button.getClientProperty("clientID");
						editAction(clientId);
					}
				}
			}
		}

	}

	private void editAction(int clientId) {
		Cliente cliente = service.findById(clientId).get();
		updateView = new UpdateView(cliente);
		updateView.getGuardarBtn().addActionListener(this);
		updateView.setVisible(true);
	}

	private void deleteAction(int clientId) {
		service.delete(clientId);
		printearClientes();
		crearActionListeners();
	}

	private void updateAction() {
		Cliente cliente = updateView.getCliente();
		String nuevoNombre = updateView.getNombreField().getText();
		String nuevoApellido = updateView.getApellidoField().getText();

		cliente.setNombre(nuevoNombre);
		cliente.setApellido(nuevoApellido);
		service.update(cliente, "id");
		printearClientes();
		crearActionListeners();
		updateView.dispose();
	}
	
	private void createAction() {
		createView = new CreateView();
		createView.getCrearBtn().addActionListener(this);
		createView.setVisible(true);
	}
	
	
	private void storeAction() {
		String nuevoNombre = createView.getNombreField().getText();
		String nuevoApellido = createView.getApellidoField().getText();
		String nuevaDireccion = createView.getDireccionField().getText();
		int nuevoDni = Integer.parseInt(createView.getDniField().getText());
		
		Cliente cliente = new Cliente(); 
		
		cliente.setId();
		cliente.setNombre(nuevoNombre);
		cliente.setApellido(nuevoApellido);
		cliente.setDireccion(nuevaDireccion);
		cliente.setDni(nuevoDni);
		
		service.create(cliente);
		printearClientes();
		crearActionListeners();
		createView.dispose();
	}
	
}
