package UD22.ejercicios.ejercicio3.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import UD22.ejercicios.ejercicio3.models.Proyecto;
import UD22.ejercicios.ejercicio3.services.ProyectoService;
import UD22.ejercicios.ejercicio3.views.proyecto.CreateProyectoView;
import UD22.ejercicios.ejercicio3.views.proyecto.ListProyectoView;
import UD22.ejercicios.ejercicio3.views.proyecto.UpdateProyectoView;

public class ProyectoController implements ActionListener {

	private ListProyectoView vista;
	private ProyectoService service;
	private UpdateProyectoView updateView;
	private CreateProyectoView createView;

	public ProyectoController(ListProyectoView vista, ProyectoService service) {
		this.vista = vista;
		this.service = service;
	}

	public void iniciarVista() {
		printearProyectos();
		vista.setTitle("Lista de Clientes");
		vista.setSize(1000, 500);
		vista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
		crearActionListeners();
	}

	public void printearProyectos() {
	    List<Proyecto> proyectos = service.findAll();
	    vista.generarProyectos(proyectos);
	}


	private void crearActionListeners() {
	    Component[] components = vista.getProyectoPanel().getComponents();
	    for (Component component : components) {
	        if (component instanceof JButton) {
	            JButton button = (JButton) component;
	            if (button.getActionCommand().equals("Delete")) {
	                button.addActionListener(this);
	            } else if (button.getActionCommand().equals("Update")) {
	                button.addActionListener(this);
	            }
	        }
	    }
	    vista.getBtnCrearProyecto().addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Component[] components = vista.getProyectoPanel().getComponents();
		// Abre el formulario de creacion de video
		if (e.getActionCommand().equals("Crear proyecto")) {
			System.out.println("crear proyecto form");
			clickAbrirFormNuevoProyecto();
		}

		// Guarda el formulario y crea un nuevo video
		if (e.getActionCommand().equals("Guardar Proyecto")) {
			System.out.println("Guardar video nuevo");
			clickGuardarNuevoProyecto();
		}

		// Guarda la modificacion del video
		if (e.getActionCommand().equals("Almacenar cambios")) {
			System.out.println("almacenar cambios pryecto");
			clickGuardarModificarProyecto();
		}

		for (Component component : components) {
			if (component instanceof JButton) {
				JButton button = (JButton) component;
				if (button == e.getSource()) {
					// Elimina un video
					if (e.getActionCommand().equals("Delete")) {
						System.out.println("delete proyecto");
						String proyectoId = (String) button.getClientProperty("proyectoID");
					    clickEliminarProyecto(proyectoId);
					}
					// Abre el formulario de modificacion de un video
					if (e.getActionCommand().equals("Update")) {
						System.out.println("abrir form update");
					    String proyectoId = (String) button.getClientProperty("proyectoID");
					    clickAbrirFormModificarProyecto(proyectoId);
					}
				}
			}
		}

	}
	
	private void clickAbrirFormModificarProyecto(String proyectoId) {
	    Proyecto proyecto = service.findById(proyectoId).get();
	    updateView = new UpdateProyectoView();
	    updateView.showProyectoView(proyecto);
	    updateView.getGuardarBtn().addActionListener(this);
	}


	private void clickEliminarProyecto(String proyectoId) {
	    service.delete(proyectoId);
	    printearProyectos();
	    crearActionListeners();
	}

	
	private void clickGuardarModificarProyecto() {
	    Proyecto proyecto = updateView.getProyecto();
	    String nuevoNombre = updateView.getNombreField().getText();
	    int nuevasHoras = Integer.parseInt(updateView.getHorasField().getText());

	    proyecto.setNombre(nuevoNombre);
	    proyecto.setHoras(nuevasHoras);

	    service.update(proyecto, "id");

	    printearProyectos();
	    crearActionListeners();
	    updateView.dispose();
	}



	public void clickAbrirFormNuevoProyecto() {
		createView = new CreateProyectoView();
	    createView.getCrearBtn().addActionListener(this);
	    createView.setVisible(true);
	}
	
	private void clickGuardarNuevoProyecto() {
		String nuevoId = createView.getIdField().getText();
		String nuevoNombre = createView.getNombreField().getText();
	    int nuevasHoras = Integer.parseInt(createView.getHorasField().getText());

	    Proyecto proyecto = new Proyecto();
	    proyecto.setId(nuevoId);
	    proyecto.setNombre(nuevoNombre);
	    proyecto.setHoras(nuevasHoras);

	    service.create(proyecto);

	    printearProyectos();
	    crearActionListeners();
	    createView.dispose();
	}

}
