package UD22.ejercicios.ejercicio2.views.video;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import UD22.ejercicios.ejercicio2.models.Video;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class UpdateVideoView extends JFrame {
	private static UpdateVideoView instance = null;
    private JTextField nombreField;
    private JTextField directorField;
    private Video video;
    private JButton guardarBtn;
    
    public static UpdateVideoView getInstance() {
    	if (instance == null)
    		instance = new UpdateVideoView();
    	return instance;
    }

    private UpdateVideoView() {

        
    }
    
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
        nombreField = new JTextField(20);
        titleLabel.setBounds(20, 50, 80, 20);
        nombreField.setBounds(120, 50, 200, 20);
        nombreField.setText(video.getTitle());
        panel.add(titleLabel);
        panel.add(nombreField);

        JLabel directorLabel = new JLabel("Director:");
        directorField = new JTextField(20);
        directorLabel.setBounds(20, 80, 80, 20);
        directorField.setBounds(120, 80, 200, 20);
        directorField.setText(video.getDirector());
        panel.add(directorLabel);
        panel.add(directorField);

        guardarBtn = new JButton("Almacenar cambios");
        guardarBtn.setBounds(150, 120, 100, 30);

        
        panel.add(guardarBtn);
    }
    

    public void setVideo(Video video) {
    	this.video = video;
    }
    
	public JTextField getNombreField() {
		return nombreField;
	}

	public JTextField getApellidoField() {
		return directorField;
	}

	public JButton getGuardarBtn() {
		return guardarBtn;
	}


	public Video getVideo() {
		return video;
	}

	
}

