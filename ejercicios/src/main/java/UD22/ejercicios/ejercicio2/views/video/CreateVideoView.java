package UD22.ejercicios.ejercicio2.views.video;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import UD22.ejercicios.conexion.Conexion;
import UD22.ejercicios.ejercicio2.services.ClienteService;

public class CreateVideoView extends JFrame {
	private static CreateVideoView instance;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField direccionField; 
    private JTextField dniField; 
    private JButton crearBtn;
    


	public static CreateVideoView getInstance() {
		if (instance == null) {
			instance = new CreateVideoView();
		}
		return instance;
	}

    private CreateVideoView() {
        setTitle("Crear Video");
        setSize(400, 350); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Crear Cliente");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(20, 10, 400, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(titleLabel);
        
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(20);
        nombreLabel.setBounds(20, 50, 80, 20);
        nombreField.setBounds(120, 50, 200, 20);
        panel.add(nombreLabel);
        panel.add(nombreField);

        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoField = new JTextField(20);
        apellidoLabel.setBounds(20, 80, 80, 20);
        apellidoField.setBounds(120, 80, 200, 20);
        panel.add(apellidoLabel);
        panel.add(apellidoField);

        JLabel direccionLabel = new JLabel("Dirección:");
        direccionField = new JTextField(20);
        direccionLabel.setBounds(20, 110, 80, 20);
        direccionField.setBounds(120, 110, 200, 20);
        panel.add(direccionLabel);
        panel.add(direccionField);

        JLabel dniLabel = new JLabel("DNI:");
        dniField = new JTextField(20);
        dniLabel.setBounds(20, 140, 80, 20);
        dniField.setBounds(120, 140, 200, 20);
        panel.add(dniLabel);
        panel.add(dniField);

        crearBtn = new JButton("Guardar cliente");
        crearBtn.setBounds(150, 170, 130, 30);
        panel.add(crearBtn);
    }

    public JTextField getNombreField() {
        return nombreField;
    }

    public JTextField getApellidoField() {
        return apellidoField;
    }

    public JTextField getDireccionField() {
        return direccionField;
    }

    public JTextField getDniField() {
        return dniField;
    }

    public JButton getCrearBtn() {
        return crearBtn;
    }
}
