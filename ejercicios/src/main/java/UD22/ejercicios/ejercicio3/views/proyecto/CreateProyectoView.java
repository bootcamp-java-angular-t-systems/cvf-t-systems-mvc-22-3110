package UD22.ejercicios.ejercicio3.views.proyecto;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import UD22.ejercicios.conexion.Conexion;
import UD22.ejercicios.ejercicio3.models.Proyecto;
import UD22.ejercicios.ejercicio3.services.ProyectoService;

public class CreateProyectoView extends JFrame {
    private JTextField idField;
    private JTextField nombreField;
    private JTextField horasField;
    private JButton crearBtn;

    public CreateProyectoView() {
        setTitle("Crear Proyecto");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        JLabel generalTitleLabel = new JLabel("Crear Proyecto");
        generalTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        generalTitleLabel.setBounds(20, 10, 400, 30);
        generalTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(generalTitleLabel);

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(20);
        idLabel.setBounds(20, 50, 80, 20);
        idField.setBounds(120, 50, 200, 20);
        panel.add(idLabel);
        panel.add(idField);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(20);
        nombreLabel.setBounds(20, 80, 80, 20);
        nombreField.setBounds(120, 80, 200, 20);
        panel.add(nombreLabel);
        panel.add(nombreField);

        JLabel horasLabel = new JLabel("Horas:");
        horasField = new JTextField(20);
        horasLabel.setBounds(20, 110, 80, 20);
        horasField.setBounds(120, 110, 200, 20);
        panel.add(horasLabel);
        panel.add(horasField);

        crearBtn = new JButton("Guardar Proyecto");
        crearBtn.setBounds(150, 140, 130, 30);
        panel.add(crearBtn);
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getNombreField() {
        return nombreField;
    }

    public JTextField getHorasField() {
        return horasField;
    }

    public JButton getCrearBtn() {
        return crearBtn;
    }
}
