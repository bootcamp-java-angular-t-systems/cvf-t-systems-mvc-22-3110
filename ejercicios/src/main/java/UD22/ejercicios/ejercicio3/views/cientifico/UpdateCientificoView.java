package UD22.ejercicios.ejercicio3.views.cientifico;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import UD22.ejercicios.ejercicio3.models.Cientifico;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class UpdateCientificoView extends JFrame {
    private JTextField dniField;
    private JTextField nomApelsField;
    private Cientifico cientifico;
    private JButton guardarBtn;

    public UpdateCientificoView(Cientifico cientifico) {
        this.cientifico = cientifico;

        setTitle("Modificar " + cientifico.getNomApels());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Modificar " + cientifico.getNomApels());
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(20, 10, 400, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(titleLabel);
        
        JLabel dniLabel = new JLabel("DNI:");
        dniField = new JTextField(20);
        dniLabel.setBounds(20, 50, 80, 20);
        dniField.setBounds(120, 50, 200, 20);
        dniField.setText(cientifico.getDni());
        panel.add(dniLabel);
        panel.add(dniField);

        JLabel nomApelsLabel = new JLabel("Nombre y Apellidos:");
        nomApelsField = new JTextField(20);
        nomApelsLabel.setBounds(20, 80, 80, 20);
        nomApelsField.setBounds(120, 80, 200, 20);
        nomApelsField.setText(cientifico.getNomApels());
        panel.add(nomApelsLabel);
        panel.add(nomApelsField);

        guardarBtn = new JButton("Almacenar cambios");
        guardarBtn.setBounds(150, 120, 160, 30);

        
        panel.add(guardarBtn);
    }
    

    public JTextField getDniField() {
        return dniField;
    }

    public JTextField getNomApelsField() {
        return nomApelsField;
    }

    public JButton getGuardarBtn() {
        return guardarBtn;
    }

    public Cientifico getCientifico() {
        return cientifico;
    }
}


