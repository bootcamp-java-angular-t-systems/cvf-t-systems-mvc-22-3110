package UD22.ejercicios.ejercicio3.views.cientifico;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.SwingConstants;

public class CreateCientificoView extends JFrame {
    private JTextField dniField;
    private JTextField nomApelsField;
    private JButton crearBtn;

    public CreateCientificoView() {
        setTitle("Crear Cientifico");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Crear Cientifico");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(20, 10, 400, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(titleLabel);

        JLabel dniLabel = new JLabel("DNI:");
        dniField = new JTextField(20);
        dniLabel.setBounds(20, 50, 80, 20);
        dniField.setBounds(120, 50, 200, 20);
        panel.add(dniLabel);
        panel.add(dniField);

        JLabel nomApelsLabel = new JLabel("Nombre y Apellidos:");
        nomApelsField = new JTextField(20);
        nomApelsLabel.setBounds(20, 80, 80, 20);
        nomApelsField.setBounds(120, 80, 200, 20);
        panel.add(nomApelsLabel);
        panel.add(nomApelsField);

        crearBtn = new JButton("Guardar Cientifico");
        crearBtn.setBounds(150, 110, 130, 30);
        panel.add(crearBtn);
    }

    public JTextField getDniField() {
        return dniField;
    }

    public JTextField getNomApelsField() {
        return nomApelsField;
    }

    public JButton getCrearBtn() {
        return crearBtn;
    }
}
