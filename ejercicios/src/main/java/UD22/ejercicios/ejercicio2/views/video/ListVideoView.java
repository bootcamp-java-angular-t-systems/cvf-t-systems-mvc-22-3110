package UD22.ejercicios.ejercicio2.views.video;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import UD22.ejercicios.ejercicio2.models.Video;

import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import java.awt.Color;

public class ListVideoView extends JFrame {
	private static ListVideoView instance = null;
	private JPanel videoPanel;
	private JButton btnCrearVideo;

	public static ListVideoView getInstance() {
		if (instance == null)
			instance = new ListVideoView();
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
		int buttonWidth = 89;
		int buttonHeight = 23;
		int buttonMargin = 10;
		int xStart = 0;

		for (Video video : videos) {
			JLabel lblId = new JLabel(String.valueOf(video.getId()));
			lblId.putClientProperty("videoID", video.getId());
			lblId.setBounds(xStart, yOffset, 52, 28);

			xStart += 52;

			JLabel lblTitulo = new JLabel(video.getTitle());
			lblTitulo.putClientProperty("videoID", video.getId());
			lblTitulo.setBounds(xStart, yOffset, 155, 28);

			xStart += 165;

			JLabel lblDirector = new JLabel(video.getDirector());
			lblDirector.putClientProperty("videoID", video.getId());
			lblDirector.setBounds(xStart, yOffset, 175, 28);

			xStart += 185;

			JButton btnDeleteVideo = new JButton("Delete");
			btnDeleteVideo.putClientProperty("videoID", video.getId());
			btnDeleteVideo.setForeground(Color.BLACK);
			btnDeleteVideo.setBackground(Color.RED);
			btnDeleteVideo.setBounds(xStart, yOffset, buttonWidth, buttonHeight);

			xStart += buttonWidth + buttonMargin;

			JButton btnUpdateVideo = new JButton("Update");
			btnUpdateVideo.putClientProperty("videoID", video.getId());
			btnUpdateVideo.setForeground(Color.BLACK);
			btnUpdateVideo.setBackground(Color.ORANGE);
			btnUpdateVideo.setBounds(xStart, yOffset, buttonWidth, buttonHeight);

			videoPanel.add(lblId);
			videoPanel.add(lblTitulo);
			videoPanel.add(lblDirector);
			videoPanel.add(btnDeleteVideo);
			videoPanel.add(btnUpdateVideo);

			yOffset += 30;
			xStart = 0;
		}

		revalidate();
	}

	private void generarCabeceraVideos() {
		int yOffset = 0;
		int xStart = 0;

		JLabel lblIdVideo = new JLabel("ID");
		lblIdVideo.setBounds(xStart, yOffset, 52, 28);
		videoPanel.add(lblIdVideo);

		xStart += 52;

		JLabel lblTituloVideo = new JLabel("TÍTULO");
		lblTituloVideo.setBounds(xStart, yOffset, 150, 28);
		videoPanel.add(lblTituloVideo);

		xStart += 150;

		JLabel lblDirectorVideo = new JLabel("DIRECTOR");
		lblDirectorVideo.setBounds(xStart, yOffset, 225, 28);
		videoPanel.add(lblDirectorVideo);

		int buttonWidth = 55;

		xStart += 225;

		JLabel lblDeleteVideo = new JLabel("DELETE");
		lblDeleteVideo.setBounds(xStart, yOffset, buttonWidth, 23);
		videoPanel.add(lblDeleteVideo);

		xStart += buttonWidth + 20;

		JLabel lblUpdateVideo = new JLabel("UPDATE");
		lblUpdateVideo.setBounds(xStart, yOffset, 85, 23);
		videoPanel.add(lblUpdateVideo);

		yOffset += 30;
	}

}
