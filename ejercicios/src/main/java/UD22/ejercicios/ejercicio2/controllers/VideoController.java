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
import UD22.ejercicios.ejercicio2.views.cliente.CreateClientView;
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
		vista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		System.out.println("Evento detectado");
		// Abre el formulario de creacion de video
		if (e.getActionCommand().equals("Crear video")) {
			System.out.println("crerar video");
			clickAbrirFormNuevoVideo();
			//createAction();
		}

		// Guarda el formulario y crea un nuevo video
		if (e.getActionCommand().equals("Guardar video")) {
			System.out.println("Guardar video");
			clickGuardarNuevoVideo();
		}

		// Guarda la modificacion del video
		if (e.getActionCommand().equals("Almacenar cambios")) {
			System.out.println("almacenar cambios");
			clickGuardarModificarVideo();
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
		updateView = new UpdateVideoView();
		updateView.showVideoView(video);
		updateView.getGuardarBtn().addActionListener(this);
	}

	private void clickEliminarVideo(int videoId) {
		service.delete(videoId);
		printearVideos();
		crearActionListeners();
	}
	
	
	private void clickGuardarModificarVideo() {
		Video video = updateView.getVideo();
		String nuevoTitulo = updateView.getTituloField().getText();
		String nuevoDirector = updateView.getDirectorField().getText();

		video.setTitle(nuevoTitulo);
		video.setDirector(nuevoDirector);
		System.out.println("nuevo titulo " + nuevoTitulo);
		System.out.println("nuevo dirctor " + nuevoDirector);
		service.update(video, "id");
		printearVideos();
		crearActionListeners();
		updateView.dispose();
	}


	public void clickAbrirFormNuevoVideo() {
		createView = new CreateVideoView();
		createView.getCrearBtn().addActionListener(this);
		createView.setVisible(true);
	}
	
	private void clickGuardarNuevoVideo() {
	    String nuevoTitulo = createView.getTitleField().getText();
	    String nuevoDirector = createView.getDirectorField().getText();
	    int nuevoClienteId = Integer.parseInt(createView.getClientIdField().getText());

	    Video video = new Video();
	    video.setId();
	    video.setTitle(nuevoTitulo);
	    video.setDirector(nuevoDirector);
	    video.setClientId(nuevoClienteId);

	    service.create(video);

	    printearVideos();
	    crearActionListeners();
	    createView.dispose();
	}

}
