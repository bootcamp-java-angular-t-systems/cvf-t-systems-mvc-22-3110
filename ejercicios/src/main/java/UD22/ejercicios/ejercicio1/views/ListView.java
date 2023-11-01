package UD22.ejercicios.ejercicio1.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import UD22.ejercicios.ejercicio1.models.Cliente;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

public class ListView extends JFrame {
	private JPanel clientesPanel;
	private JButton btnCrearCliente;
	
	public ListView() {

		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(35, 23, 265, 46);
		getContentPane().add(lblNewLabel);

		clientesPanel = new JPanel();
		clientesPanel.setLayout(null);
		clientesPanel.setBounds(35, 80, 770, 700);
		clientesPanel.setBorder(new LineBorder(Color.RED));
		getContentPane().add(clientesPanel);

		btnCrearCliente = new JButton("Crear cliente");
		btnCrearCliente.setForeground(Color.WHITE);
		btnCrearCliente.setBackground(new Color(0, 128, 0));
		int buttonWidth = btnCrearCliente.getPreferredSize().width;
		int xPosition = clientesPanel.getX() + clientesPanel.getWidth() - buttonWidth;
		btnCrearCliente.setBounds(xPosition, 23, buttonWidth, 28);
		getContentPane().add(btnCrearCliente);
	}

	public JButton getBtnCrearCliente() {
		return btnCrearCliente;
	}

	public JPanel getClientesPanel() {
		return clientesPanel;
	}

	public void generarClientes(List<Cliente> clientes) {
		clientesPanel.removeAll();
		clientesPanel.revalidate();
		clientesPanel.repaint();
		generarCabeceraClientes();

		int yOffset = 40;

		for (Cliente cliente : clientes) {

			JLabel lblId = new JLabel(String.valueOf(cliente.getId()));
			lblId.putClientProperty("clientID", cliente.getId());
			lblId.setBounds(0, yOffset, 52, 28);
			lblId.setAlignmentX(Component.LEFT_ALIGNMENT);

			JLabel lblNombre = new JLabel(cliente.getNombre());
			lblNombre.putClientProperty("clientID", cliente.getId());
			lblNombre.setBounds(62, yOffset, 105, 28);
			lblNombre.setAlignmentX(Component.LEFT_ALIGNMENT);

			JLabel lblApellido = new JLabel(cliente.getApellido());
			lblApellido.putClientProperty("clientID", cliente.getId());
			lblApellido.setBounds(167, yOffset, 105, 28);
			lblApellido.setAlignmentX(Component.LEFT_ALIGNMENT);

			JLabel lblDireccion = new JLabel(cliente.getDireccion());
			lblDireccion.putClientProperty("clientID", cliente.getId());
			lblDireccion.setBounds(272, yOffset, 201, 28);
			lblDireccion.setAlignmentX(Component.LEFT_ALIGNMENT);

			JLabel lblDni = new JLabel(String.valueOf(cliente.getDni()));
			lblDni.putClientProperty("clientID", cliente.getId());
			lblDni.setBounds(475, yOffset, 98, 28);
			lblDni.setAlignmentX(Component.LEFT_ALIGNMENT);

			JButton btnDeleteCliente = new JButton("Delete");
			btnDeleteCliente.putClientProperty("clientID", cliente.getId());
			btnDeleteCliente.putClientProperty("clientID", cliente.getId());
			btnDeleteCliente.setForeground(Color.BLACK);
			btnDeleteCliente.setBackground(Color.RED);
			btnDeleteCliente.setBounds(578, yOffset, 89, 23);
			btnDeleteCliente.setAlignmentX(Component.LEFT_ALIGNMENT);

			JButton btnUpdateCliente = new JButton("Update");
			btnUpdateCliente.putClientProperty("clientID", cliente.getId());
			btnUpdateCliente.setForeground(Color.BLACK);
			btnUpdateCliente.setBackground(Color.ORANGE);
			btnUpdateCliente.setBounds(675, yOffset, 89, 23);
			btnUpdateCliente.setAlignmentX(Component.LEFT_ALIGNMENT);

			clientesPanel.add(lblId);
			clientesPanel.add(lblNombre);
			clientesPanel.add(lblApellido);
			clientesPanel.add(lblDireccion);
			clientesPanel.add(lblDni);
			clientesPanel.add(btnDeleteCliente);
			clientesPanel.add(btnUpdateCliente);

			yOffset += 30;
		}

		revalidate();
	}

	private void generarCabeceraClientes() {
		int yOffset = 0;

		JLabel lblIdCliente = new JLabel("ID");
		lblIdCliente.setBounds(0, yOffset, 52, 28);
		lblIdCliente.setAlignmentX(Component.LEFT_ALIGNMENT);
		clientesPanel.add(lblIdCliente);

		JLabel lblNombreCliente = new JLabel("NOMBRE");
		lblNombreCliente.setBounds(62, yOffset, 105, 28);
		lblNombreCliente.setAlignmentX(Component.LEFT_ALIGNMENT);
		clientesPanel.add(lblNombreCliente);

		JLabel lblApellidoCliente = new JLabel("APELLIDO");
		lblApellidoCliente.setBounds(167, yOffset, 105, 28);
		lblApellidoCliente.setAlignmentX(Component.LEFT_ALIGNMENT);
		clientesPanel.add(lblApellidoCliente);

		JLabel lblDireccionCliente = new JLabel("DIRECCION");
		lblDireccionCliente.setBounds(272, yOffset, 201, 28);
		lblDireccionCliente.setAlignmentX(Component.LEFT_ALIGNMENT);
		clientesPanel.add(lblDireccionCliente);

		JLabel lblDniCliente = new JLabel("DNI");
		lblDniCliente.setBounds(475, yOffset, 98, 28);
		lblDniCliente.setAlignmentX(Component.LEFT_ALIGNMENT);
		clientesPanel.add(lblDniCliente);

		JLabel lblDeleteCliente = new JLabel("DELETE");
		lblDeleteCliente.setBounds(578, yOffset, 52, 23);
		lblDeleteCliente.setAlignmentX(Component.LEFT_ALIGNMENT);
		clientesPanel.add(lblDeleteCliente);

		JLabel lblUpdateCliente = new JLabel("UPDATE");
		lblUpdateCliente.setBounds(675, yOffset, 55, 23);
		lblUpdateCliente.setAlignmentX(Component.LEFT_ALIGNMENT);
		clientesPanel.add(lblUpdateCliente);

		clientesPanel.add(lblIdCliente);
		clientesPanel.add(lblNombreCliente);
		clientesPanel.add(lblApellidoCliente);
		clientesPanel.add(lblDireccionCliente);
		clientesPanel.add(lblDniCliente);
		clientesPanel.add(lblDeleteCliente);
		clientesPanel.add(lblUpdateCliente);
	}
}
