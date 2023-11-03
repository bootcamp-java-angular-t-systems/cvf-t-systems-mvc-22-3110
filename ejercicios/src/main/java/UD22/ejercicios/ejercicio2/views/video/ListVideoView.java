package UD22.ejercicios.ejercicio2.views.video;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import UD22.ejercicios.ejercicio2.models.Video;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

public class ListVideoView extends JFrame {
	private static ListVideoView instance = null;
	private JPanel videoPanel;
	private JButton btnCrearVideo;
	
	public static ListVideoView getInstance() {
		if (instance == null) {
			instance = new ListVideoView();
		}
		return instance;
	}

	private ListVideoView() {

		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Videos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(35, 23, 265, 46);
		getContentPane().add(lblNewLabel);

		videoPanel = new JPanel();
		videoPanel.setLayout(null);
		videoPanel.setBounds(35, 80, 870, 800);
		getContentPane().add(videoPanel);

		btnCrearVideo = new JButton("Crear video");
		btnCrearVideo.setForeground(Color.WHITE);
		btnCrearVideo.setBackground(new Color(0, 128, 0));
		int buttonWidth = btnCrearVideo.getPreferredSize().width;
		int xPosition = videoPanel.getX() + videoPanel.getWidth() - buttonWidth;
		btnCrearVideo.setBounds(xPosition, 23, buttonWidth, 28);
		getContentPane().add(btnCrearVideo);
	}

	public JButton getBtnCrearVideo() {
		return btnCrearVideo;
	}

	public JPanel getVideosPanel() {
		return videoPanel;
	}

	public void generarVideos(List<Video> videos) {
	    videoPanel.removeAll();
	    videoPanel.revalidate();
	    videoPanel.repaint();
	    generarCabeceraVideos();

	    int yOffset = 40;

	    for (Video video : videos) {

	        JLabel lblId = new JLabel(String.valueOf(video.getId()));
	        lblId.putClientProperty("videoID", video.getId());
	        lblId.setBounds(0, yOffset, 52, 28);
	        lblId.setAlignmentX(Component.LEFT_ALIGNMENT);

	        JLabel lblTitulo = new JLabel(video.getTitle());
	        lblTitulo.putClientProperty("videoID", video.getId());
	        lblTitulo.setBounds(62, yOffset, 105, 28);
	        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

	        JButton btnDeleteVideo = new JButton("Delete");
	        btnDeleteVideo.putClientProperty("videoID", video.getId());
	        btnDeleteVideo.setForeground(Color.BLACK);
	        btnDeleteVideo.setBackground(Color.RED);
	        btnDeleteVideo.setBounds(578, yOffset, 89, 23);
	        btnDeleteVideo.setAlignmentX(Component.LEFT_ALIGNMENT);

	        JButton btnUpdateVideo = new JButton("Update");
	        btnUpdateVideo.putClientProperty("videoID", video.getId());
	        btnUpdateVideo.setForeground(Color.BLACK);
	        btnUpdateVideo.setBackground(Color.ORANGE);
	        btnUpdateVideo.setBounds(675, yOffset, 89, 23);
	        btnUpdateVideo.setAlignmentX(Component.LEFT_ALIGNMENT);


	        videoPanel.add(lblId);
	        videoPanel.add(lblTitulo);
	        videoPanel.add(btnDeleteVideo);
	        videoPanel.add(btnUpdateVideo);

	        yOffset += 30;
	    }

	    revalidate();
	}


	private void generarCabeceraVideos() {
	    int yOffset = 0;

	    JLabel lblIdVideo = new JLabel("ID");
	    lblIdVideo.setBounds(0, yOffset, 52, 28);
	    lblIdVideo.setAlignmentX(Component.LEFT_ALIGNMENT);
	    videoPanel.add(lblIdVideo);

	    JLabel lblTituloVideo = new JLabel("TÍTULO");
	    lblTituloVideo.setBounds(62, yOffset, 105, 28);
	    lblTituloVideo.setAlignmentX(Component.LEFT_ALIGNMENT);
	    videoPanel.add(lblTituloVideo);


	    JLabel lblDeleteVideo = new JLabel("DELETE");
	    lblDeleteVideo.setBounds(578, yOffset, 52, 23);
	    lblDeleteVideo.setAlignmentX(Component.LEFT_ALIGNMENT);
	    videoPanel.add(lblDeleteVideo);

	    JLabel lblUpdateVideo = new JLabel("UPDATE");
	    lblUpdateVideo.setBounds(675, yOffset, 55, 23);
	    lblUpdateVideo.setAlignmentX(Component.LEFT_ALIGNMENT);
	    videoPanel.add(lblUpdateVideo);



	    yOffset += 30;
	}

}
