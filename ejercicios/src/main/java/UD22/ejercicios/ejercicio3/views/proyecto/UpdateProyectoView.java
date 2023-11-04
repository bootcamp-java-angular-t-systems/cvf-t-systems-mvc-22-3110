package UD22.ejercicios.ejercicio3.views.proyecto;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import UD22.ejercicios.ejercicio2.models.Video;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class UpdateProyectoView extends JFrame {
    private JTextField tituloField;
    private JTextField directorField;
    private Video video;
    private JButton guardarBtn;
    

    public UpdateProyectoView() {}
    
    
    public void iniciarVista() {
    	setTitle("Modificar " + video.getTitle());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        JLabel panelTitleLabel = new JLabel("Modificar " + video.getTitle());
        panelTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panelTitleLabel.setBounds(20, 10, 400, 30);
        panelTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(panelTitleLabel);
        
        JLabel titleLabel = new JLabel("Titulo:");
        tituloField = new JTextField(20);
        titleLabel.setBounds(20, 50, 80, 20);
        tituloField.setBounds(120, 50, 200, 20);
        tituloField.setText(video.getTitle());
        panel.add(titleLabel);
        panel.add(tituloField);

        JLabel directorLabel = new JLabel("Director:");
        directorField = new JTextField(20);
        directorLabel.setBounds(20, 80, 80, 20);
        directorField.setBounds(120, 80, 200, 20);
        directorField.setText(video.getDirector());
        panel.add(directorLabel);
        panel.add(directorField);

        guardarBtn = new JButton("Almacenar cambios");
        guardarBtn.setBounds(150, 120, 100, 30);

        tituloField.setText(video.getTitle());
        directorField.setText(video.getDirector());
        
        panel.add(guardarBtn);
    }
    
    
    public void showVideoView(Video video) {
    	this.video = video;
    	iniciarVista();
    	setVisible(true);
    }
    

    public void setVideo(Video video) {
    	this.video = video;
    }
    
	public JTextField getTituloField() {
		return tituloField;
	}

	public JTextField getDirectorField() {
		return directorField;
	}

	public JButton getGuardarBtn() {
		return guardarBtn;
	}


	public Video getVideo() {
		return video;
	}

	
}

