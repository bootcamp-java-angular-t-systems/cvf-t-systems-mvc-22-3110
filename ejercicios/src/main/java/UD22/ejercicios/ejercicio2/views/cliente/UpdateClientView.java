package UD22.ejercicios.ejercicio2.views.cliente;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import UD22.ejercicios.ejercicio2.models.Cliente;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class UpdateClientView extends JFrame {
    private JTextField nombreField;
    private JTextField apellidoField;
    private Cliente cliente;
    private JButton guardarBtn;

    public UpdateClientView(Cliente cliente) {
        this.cliente = cliente;

        setTitle("Modificar " + cliente.getNombre() + " " + cliente.getApellido());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Modificar " + cliente.getNombre() + " " + cliente.getApellido());
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(20, 10, 400, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(titleLabel);
        
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(20);
        nombreLabel.setBounds(20, 50, 80, 20);
        nombreField.setBounds(120, 50, 200, 20);
        nombreField.setText(cliente.getNombre());
        panel.add(nombreLabel);
        panel.add(nombreField);

        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoField = new JTextField(20);
        apellidoLabel.setBounds(20, 80, 80, 20);
        apellidoField.setBounds(120, 80, 200, 20);
        apellidoField.setText(cliente.getApellido());
        panel.add(apellidoLabel);
        panel.add(apellidoField);

        guardarBtn = new JButton("Almacenar cambios");
        guardarBtn.setBounds(150, 120, 100, 30);

        
        panel.add(guardarBtn);
    }
    

	public JTextField getNombreField() {
		return nombreField;
	}

	public JTextField getApellidoField() {
		return apellidoField;
	}

	public JButton getGuardarBtn() {
		return guardarBtn;
	}


	public Cliente getCliente() {
		return cliente;
	}

	
}

