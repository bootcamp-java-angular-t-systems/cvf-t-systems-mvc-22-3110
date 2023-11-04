package UD22.ejercicios.ejercicio3.views.proyecto;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import UD22.ejercicios.conexion.Conexion;
import UD22.ejercicios.ejercicio2.models.Video;
import UD22.ejercicios.ejercicio2.services.ClienteService;

public class CreateProyectoView extends JFrame {
    private JTextField titleField;
    private JTextField directorField;
    private JTextField clientIdField;
    private JButton crearBtn;

    public CreateProyectoView() {
        setTitle("Crear Video");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        JLabel generalTitleLabel = new JLabel("Crear Video");
        generalTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        generalTitleLabel.setBounds(20, 10, 400, 30);
        generalTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(generalTitleLabel);

        JLabel titleLabel = new JLabel("Título:");
        titleField = new JTextField(20);
        titleLabel.setBounds(20, 50, 80, 20);
        titleField.setBounds(120, 50, 200, 20);
        panel.add(titleLabel);
        panel.add(titleField);

        JLabel directorLabel = new JLabel("Director:");
        directorField = new JTextField(20);
        directorLabel.setBounds(20, 80, 80, 20);
        directorField.setBounds(120, 80, 200, 20);
        panel.add(directorLabel);
        panel.add(directorField);

        JLabel clientIdLabel = new JLabel("ID del Cliente:");
        clientIdField = new JTextField(20);
        clientIdLabel.setBounds(20, 110, 80, 20);
        clientIdField.setBounds(120, 110, 200, 20);
        panel.add(clientIdLabel);
        panel.add(clientIdField);

        crearBtn = new JButton("Guardar video");
        crearBtn.setBounds(150, 140, 130, 30);
        panel.add(crearBtn);
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JTextField getDirectorField() {
        return directorField;
    }

    public JTextField getClientIdField() {
        return clientIdField;
    }

    public JButton getCrearBtn() {
        return crearBtn;
    }
}
