package UD22.ejercicios.ejercicio2.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import UD22.ejercicios.ejercicio2.models.Cliente;
import UD22.ejercicios.ejercicio2.models.Video;
import UD22.ejercicios.ejercicio2.services.VideoService;
import UD22.ejercicios.ejercicio2.views.video.CreateVideoView;
import UD22.ejercicios.ejercicio2.views.video.ListVideoView;
import UD22.ejercicios.ejercicio2.views.video.UpdateVideoView;

public class VideoController implements ActionListener {

	private ListVideoView vista;
	private VideoService service;
	private UpdateVideoView updateView;
	private CreateVideoView createView;

	public VideoController(ListVideoView vista, VideoService service) {
		this.vista = vista;
		this.service = service;
	}

	public void iniciarVista() {
		printearVideos();
		vista.setTitle("Lista de Clientes");
		vista.setSize(1000, 500);
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
		crearActionListeners();
	}

	public void printearVideos() {
		List<Video> videos = service.findAll();
		vista.generarVideos(videos);
	}

	private void crearActionListeners() {
		Component[] components = vista.getVideosPanel().getComponents();
		for (Component component : components) {
			if (component instanceof JButton) {
				JButton button = (JButton) component;
				button.addActionListener(this);
			}
		}
		vista.getBtnCrearVideo().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Component[] components = vista.getVideosPanel().getComponents();

		// Abre el formulario de creacion de video
		if (e.getActionCommand().equals("Crear video")) {
			//createAction();
		}

		// Guarda el formulario y crea un nuevo video
		if (e.getActionCommand().equals("Guardar video")) {
			//storeAction();
		}

		// Guarda la modificacion del video
		if (e.getActionCommand().equals("Almacenar cambios")) {
			//updateAction();
		}

		for (Component component : components) {
			if (component instanceof JButton) {
				JButton button = (JButton) component;
				if (button == e.getSource()) {
					// Elimina un video
					if (e.getActionCommand().equals("Delete")) {
						int videoId = (int) button.getClientProperty("videoID");
						clickEliminarVideo(videoId);
					}
					// Abre el formulario de modificacion de un video
					if (e.getActionCommand().equals("Update")) {
						System.out.println("update video");
						int videoId = (int) button.getClientProperty("videoID");
						clickAbrirFormModificarCliente(videoId);
					}
				}
			}
		}

	}
	
	private void clickAbrirFormModificarCliente(int videoId) {
		
		Video video = service.findById(videoId).get();
		updateView = UpdateVideoView.getInstance();
		updateView.setVideo(video);
		// TODO si invocas "iniciarVista" antes que "setVideo" el codigo explota
		updateView.iniciarVista();
		updateView.getGuardarBtn().addActionListener(this);
		updateView.setVisible(true);
	}

	private void clickEliminarVideo(int videoId) {
		service.delete(videoId);
		printearVideos();
		crearActionListeners();
	}

/*
	private void updateAction() {
		Cliente video = updateView.getCliente();
		String nuevoNombre = updateView.getNombreField().getText();
		String nuevoApellido = updateView.getApellidoField().getText();

		video.setNombre(nuevoNombre);
		video.setApellido(nuevoApellido);
		service.update(video, "id");
		printearVideos();
		crearActionListeners();
		updateView.dispose();
	}
	*/
/*
	private void createAction() {
		createView = new CreateClientView();
		createView.getCrearBtn().addActionListener(this);
		createView.setVisible(true);
	}
	*/
/*
	private void storeAction() {
		String nuevoNombre = createView.getNombreField().getText();
		String nuevoApellido = createView.getApellidoField().getText();
		String nuevaDireccion = createView.getDireccionField().getText();
		int nuevoDni = Integer.parseInt(createView.getDniField().getText());

		Cliente video = new Cliente();

		video.setId();
		video.setNombre(nuevoNombre);
		video.setApellido(nuevoApellido);
		video.setDireccion(nuevaDireccion);
		video.setDni(nuevoDni);
		video.setFecha();

		service.create(video);
		printearVideos();
		crearActionListeners();
		createView.dispose();
	}
	*/
/*
	private void mostrarVideosButtonOnClick(int clientId) {
		ListVideoView listVideoView = ListVideoView.getInstance();
		VideoService videoService = VideoService.getInstance();

		VideoController videoController = new VideoController(listVideoView, videoService);
		videoController.iniciar(clientId);
	}
	*/

}
