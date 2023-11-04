package UD22.ejercicios.ejercicio3.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import UD22.ejercicios.ejercicio3.models.Cientifico;
import UD22.ejercicios.ejercicio3.services.CientificoService;
import UD22.ejercicios.ejercicio3.views.cientifico.CreateCientificoView;
import UD22.ejercicios.ejercicio3.views.cientifico.ListCientificoView;
import UD22.ejercicios.ejercicio3.views.cientifico.UpdateCientificoView;

public class CientificoController implements ActionListener {

	private ListCientificoView vista;
	private CientificoService service;
	private UpdateCientificoView updateView;
	private CreateCientificoView createView;

	public CientificoController(ListCientificoView vista, CientificoService service) {
		this.vista = vista;
		this.service = service;
	}

	public void iniciarVista() {
		printearCientificos();
		vista.setTitle("Lista de Científicos");
		vista.setSize(1000, 500);
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
		crearActionListeners();
	}

	public void printearCientificos() {
		List<Cientifico> cientificos = service.findAll();
		vista.generarCientificos(cientificos);
	}

	private void crearActionListeners() {
		Component[] components = vista.getCientificosPanel().getComponents();
		for (Component component : components) {
			if (component instanceof JButton) {
				JButton button = (JButton) component;
				button.addActionListener(this);
			}
		}
		vista.getBtnCrearCientifico().addActionListener(this);
		// vista.getBtnVideos().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Component[] components = vista.getCientificosPanel().getComponents();

		// Abre el formulario de creacion de cliente
		if (e.getActionCommand().equals("Crear Cientifico")) {
			System.out.println("Crear cientifico buttn");
			// clickAbrirFormNuevoCliente();
		}

		// Guarda el formulario y crea un nuevo cliente
		if (e.getActionCommand().equals("Guardar cliente")) {
			System.out.println("Guardar (nuevo cientifico)");
			// clickGuardarNuevoCliente();
		}

		// Guarda la modificacion del cliente
		if (e.getActionCommand().equals("Almacenar cambios")) {
			System.out.println("Almacenar cambios (modificar cliente)");
			// clickGuardarModificarCliente();
		}
		// Abre la ventana con los videos
		if (e.getActionCommand().equals("Videos")) {
			System.out.println("Videos button");
			// ListVideoView listVideoView = ListVideoView.getInstance();
			// VideoService videoService = VideoService.getInstance();

			// ProyectoController videoController = new ProyectoController(listVideoView,
			// videoService);
			// videoController.iniciarVista();

		}

		for (Component component : components) {
			if (component instanceof JButton) {
				JButton button = (JButton) component;
				if (button == e.getSource()) {
					// Elimina un cliente
					if (e.getActionCommand().equals("Delete")) {
						System.out.println("Delete button");
						// int clientId = (int) button.getClientProperty("clientID");
						// clickEliminarClienteCascada(clientId);
					}
					// Abre el formulario de modificacion de un cliente
					if (e.getActionCommand().equals("Update")) {
						System.out.println("Update button");
						String cientificoId = (String) button.getClientProperty("cientificoID");
						clickAbrirFormModificarCientifico(cientificoId);
					}
				}
			}
		}

	}

	private void clickAbrirFormModificarCientifico(String cientificoId) {
		Cientifico cientifico = service.findById(cientificoId).orElse(null);

		if (cientifico != null) {
			updateView = new UpdateCientificoView(cientifico);

			updateView.getGuardarBtn().addActionListener(this);
			updateView.setVisible(true);
		} else {
			System.out.println("Cientifico no encontrado con ID: " + cientificoId);
		}
	}
	/*
	 * private void clickEliminarClienteCascada(int clientId) {
	 * service.delete(clientId); printearClientes(); crearActionListeners(); }
	 * 
	 * private void clickGuardarModificarCliente() { Cliente cliente =
	 * updateView.getCliente(); String nuevoNombre =
	 * updateView.getNombreField().getText(); String nuevoApellido =
	 * updateView.getApellidoField().getText();
	 * 
	 * cliente.setNombre(nuevoNombre); cliente.setApellido(nuevoApellido);
	 * service.update(cliente, "id"); printearClientes(); crearActionListeners();
	 * updateView.dispose(); }
	 * 
	 * private void clickAbrirFormNuevoCliente() { createView = new
	 * CreateClientView(); createView.getCrearBtn().addActionListener(this);
	 * createView.setVisible(true); }
	 * 
	 * private void clickGuardarNuevoCliente() { String nuevoNombre =
	 * createView.getNombreField().getText(); String nuevoApellido =
	 * createView.getApellidoField().getText(); String nuevaDireccion =
	 * createView.getDireccionField().getText(); int nuevoDni =
	 * Integer.parseInt(createView.getDniField().getText());
	 * 
	 * Cliente cliente = new Cliente();
	 * 
	 * cliente.setId(); cliente.setNombre(nuevoNombre);
	 * cliente.setApellido(nuevoApellido); cliente.setDireccion(nuevaDireccion);
	 * cliente.setDni(nuevoDni); cliente.setFecha();
	 * 
	 * service.create(cliente); printearClientes(); crearActionListeners();
	 * createView.dispose(); }
	 * 
	 * // TODO esperar a la respuesta del profe private void
	 * mostrarVideosButtonOnClick(int clientId) { ListVideoView listVideoView =
	 * ListVideoView.getInstance(); VideoService videoService =
	 * VideoService.getInstance();
	 * 
	 * VideoController videoController = new VideoController(listVideoView,
	 * videoService); videoController.iniciar(clientId); }
	 */

}
