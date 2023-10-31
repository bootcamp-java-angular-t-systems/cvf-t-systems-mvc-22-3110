package UD22.ejercicios.ejercicio1.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class AdminView extends JFrame {
	public AdminView() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(56, 28, 265, 46);
		getContentPane().add(lblNewLabel);
	}
}
