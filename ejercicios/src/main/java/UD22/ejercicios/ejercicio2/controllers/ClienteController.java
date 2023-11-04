package UD22.ejercicios.ejercicio2.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import UD22.ejercicios.ejercicio2.models.Cliente;
import UD22.ejercicios.ejercicio2.services.ClienteService;
import UD22.ejercicios.ejercicio2.services.VideoService;
import UD22.ejercicios.ejercicio2.views.cliente.CreateClientView;
import UD22.ejercicios.ejercicio2.views.cliente.ListClientView;
import UD22.ejercicios.ejercicio2.views.cliente.UpdateClientView;
import UD22.ejercicios.ejercicio2.views.video.CreateVideoView;
import UD22.ejercicios.ejercicio2.views.video.ListVideoView;

public class ClienteController implements ActionListener {

	private ListClientView vista;
	private ClienteService service;
	private UpdateClientView updateView;
	private CreateClientView createView;

	public ClienteController(ListClientView vista, ClienteService service) {
		this.vista = vista;
		this.service = service;
	}

	public void iniciarVista() {
		printearClientes();
		vista.setTitle("Lista de Clientes");
		vista.setSize(1000, 500);
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
		vista.getBtnVideos().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Component[] components = vista.getClientesPanel().getComponents();

		// Abre el formulario de creacion de cliente
		if (e.getActionCommand().equals("Crear cliente")) {
			clickAbrirFormNuevoCliente();
		}

		// Guarda el formulario y crea un nuevo cliente
		if (e.getActionCommand().equals("Guardar cliente")) {
			clickGuardarNuevoCliente();
		}

		// Guarda la modificacion del cliente
		if (e.getActionCommand().equals("Almacenar cambios")) {
			clickGuardarModificarCliente();
		}
		// Abre la ventana con los videos
		if (e.getActionCommand().equals("Videos")) {
			ListVideoView listVideoView = ListVideoView.getInstance();
			VideoService videoService = VideoService.getInstance();

			VideoController videoController = new VideoController(listVideoView, videoService);
			videoController.iniciarVista();
			// TODO videoController.iniciarVista(clientId);
			
		}

		for (Component component : components) {
			if (component instanceof JButton) {
				JButton button = (JButton) component;
				if (button == e.getSource()) {
					// Elimina un cliente
					if (e.getActionCommand().equals("Delete")) {
						int clientId = (int) button.getClientProperty("clientID");
						clickEliminarClienteCascada(clientId);
					}
					// Abre el formulario de modificacion de un cliente
					if (e.getActionCommand().equals("Update")) {
						int clientId = (int) button.getClientProperty("clientID");
						clickAbrirFormModificarCliente(clientId);
					}
				}
			}
		}

	}

	private void clickAbrirFormModificarCliente(int clientId) {
		Cliente cliente = service.findById(clientId).get();
		// TODO hacer que esta clase sea singleton
		updateView = new UpdateClientView(cliente);
		// TODO crear método "showView(CLIENTE)" para no crear múltiples instancias 
		updateView.getGuardarBtn().addActionListener(this);
		updateView.setVisible(true);
	}

	private void clickEliminarClienteCascada(int clientId) {
		service.delete(clientId);
		printearClientes();
		crearActionListeners();
	}

	private void clickGuardarModificarCliente() {
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

	private void clickAbrirFormNuevoCliente() {
		createView = new CreateClientView();
		createView.getCrearBtn().addActionListener(this);
		createView.setVisible(true);
	}

	private void clickGuardarNuevoCliente() {
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
		cliente.setFecha();

		service.create(cliente);
		printearClientes();
		crearActionListeners();
		createView.dispose();
	}
	
	// TODO esperar a la respuesta del profe
/*
	private void mostrarVideosButtonOnClick(int clientId) {
		ListVideoView listVideoView = ListVideoView.getInstance();
		VideoService videoService = VideoService.getInstance();

		VideoController videoController = new VideoController(listVideoView, videoService);
		videoController.iniciar(clientId);
	}
	*/

}
