package UD22.ejercicios.ejercicio3.views.proyecto;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import UD22.ejercicios.ejercicio3.models.Proyecto;

public class UpdateProyectoView extends JFrame {
    private JTextField nombreField;
    private JTextField horasField;
    private Proyecto proyecto;
    private JButton guardarBtn;

    public UpdateProyectoView() {}

    public void iniciarVista() {
        setTitle("Modificar " + proyecto.getNombre());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        JLabel panelTitleLabel = new JLabel("Modificar " + proyecto.getNombre());
        panelTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panelTitleLabel.setBounds(20, 10, 400, 30);
        panelTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(panelTitleLabel);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(20);
        nombreLabel.setBounds(20, 50, 80, 20);
        nombreField.setBounds(120, 50, 200, 20);
        nombreField.setText(proyecto.getNombre());
        panel.add(nombreLabel);
        panel.add(nombreField);

        JLabel horasLabel = new JLabel("Horas:");
        horasField = new JTextField(20);
        horasLabel.setBounds(20, 80, 80, 20);
        horasField.setBounds(120, 80, 200, 20);
        horasField.setText(String.valueOf(proyecto.getHoras()));
        panel.add(horasLabel);
        panel.add(horasField);

        guardarBtn = new JButton("Almacenar cambios");
        guardarBtn.setBounds(150, 120, 150, 30);

        nombreField.setText(proyecto.getNombre());
        horasField.setText(String.valueOf(proyecto.getHoras()));

        panel.add(guardarBtn);
    }

    public void showProyectoView(Proyecto proyecto) {
        this.proyecto = proyecto;
        iniciarVista();
        setVisible(true);
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public JTextField getNombreField() {
        return nombreField;
    }

    public JTextField getHorasField() {
        return horasField;
    }

    public JButton getGuardarBtn() {
        return guardarBtn;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }
}
