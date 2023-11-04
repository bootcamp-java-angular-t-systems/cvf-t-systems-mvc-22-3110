package UD22.ejercicios.ejercicio3.views.cientifico;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.List;
import java.awt.Color;
import java.awt.Component;

import UD22.ejercicios.ejercicio3.models.Cientifico;

public class ListCientificoView extends JFrame {
    private JPanel cientificosPanel;
    private JButton btnCrearCientifico;
    private JButton btnProyecto;

    public ListCientificoView() {
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Cientificos");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setBounds(35, 23, 265, 46);
        getContentPane().add(lblNewLabel);

        cientificosPanel = new JPanel();
        cientificosPanel.setLayout(null);
        cientificosPanel.setBounds(35, 80, 870, 800);
        getContentPane().add(cientificosPanel);

        btnCrearCientifico = new JButton("Crear Cientifico");
        btnCrearCientifico.setForeground(Color.WHITE);
        btnCrearCientifico.setBackground(new Color(0, 128, 0));
        int buttonWidth = btnCrearCientifico.getPreferredSize().width;
        int xPosition = cientificosPanel.getX() + cientificosPanel.getWidth() - buttonWidth;
        btnCrearCientifico.setBounds(xPosition, 23, buttonWidth, 28);
        getContentPane().add(btnCrearCientifico);
        
        btnProyecto = new JButton("Proyecto");
        btnProyecto.setForeground(Color.WHITE);
        btnProyecto.setBackground(new Color(0, 0, 128));
        int proyectoButtonWidth = btnProyecto.getPreferredSize().width;
        int xProyectoButtonPosition = xPosition - proyectoButtonWidth - 10;
        btnProyecto.setBounds(xProyectoButtonPosition, 23, proyectoButtonWidth, 28);
        getContentPane().add(btnProyecto);
    }

    public void setCientificosPanel(JPanel cientificosPanel) {
        this.cientificosPanel = cientificosPanel;
    }

    
    public JButton getBtnProyecto() {
		return btnProyecto;
	}

	public void setBtnProyecto(JButton btnProyecto) {
		this.btnProyecto = btnProyecto;
	}

	public void setBtnCrearCientifico(JButton btnCrearCientifico) {
		this.btnCrearCientifico = btnCrearCientifico;
	}

	public JButton getBtnCrearCientifico() {
        return btnCrearCientifico;
    }

    public JPanel getCientificosPanel() {
        return cientificosPanel;
    }

    public void generarCientificos(List<Cientifico> cientificos) {
        cientificosPanel.removeAll();
        cientificosPanel.revalidate();
        cientificosPanel.repaint();
        generarCabeceraCientificos();

        int yOffset = 40;

        for (Cientifico cientifico : cientificos) {
            JLabel lblDni = new JLabel(cientifico.getDni());
            lblDni.putClientProperty("cientificoID", cientifico.getDni());
            lblDni.setBounds(0, yOffset, 100, 28);
            lblDni.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel lblNomApels = new JLabel(cientifico.getNomApels());
            lblNomApels.putClientProperty("cientificoID", cientifico.getDni());
            lblNomApels.setBounds(120, yOffset, 300, 28);
            lblNomApels.setAlignmentX(Component.LEFT_ALIGNMENT);

            JButton btnDeleteCientifico = new JButton("Delete");
            btnDeleteCientifico.putClientProperty("cientificoID", cientifico.getDni());
            btnDeleteCientifico.setForeground(Color.BLACK);
            btnDeleteCientifico.setBackground(Color.RED);
            btnDeleteCientifico.setBounds(450, yOffset, 100, 23);
            btnDeleteCientifico.setAlignmentX(Component.LEFT_ALIGNMENT);

            JButton btnUpdateCientifico = new JButton("Update");
            btnUpdateCientifico.putClientProperty("cientificoID", cientifico.getDni());
            btnUpdateCientifico.setForeground(Color.BLACK);
            btnUpdateCientifico.setBackground(Color.ORANGE);
            btnUpdateCientifico.setBounds(560, yOffset, 100, 23);
            btnUpdateCientifico.setAlignmentX(Component.LEFT_ALIGNMENT);

            cientificosPanel.add(lblDni);
            cientificosPanel.add(lblNomApels);
            cientificosPanel.add(btnDeleteCientifico);
            cientificosPanel.add(btnUpdateCientifico);

            yOffset += 30;
        }

        revalidate();
    }

    private void generarCabeceraCientificos() {
        int yOffset = 0;

        JLabel lblDniCientifico = new JLabel("DNI");
        lblDniCientifico.setBounds(0, yOffset, 100, 28);
        lblDniCientifico.setAlignmentX(Component.LEFT_ALIGNMENT);
        cientificosPanel.add(lblDniCientifico);

        JLabel lblNomApelsCientifico = new JLabel("NOMBRE Y APELLIDOS");
        lblNomApelsCientifico.setBounds(120, yOffset, 300, 28);
        lblNomApelsCientifico.setAlignmentX(Component.LEFT_ALIGNMENT);
        cientificosPanel.add(lblNomApelsCientifico);

        JLabel lblDeleteCientifico = new JLabel("DELETE");
        lblDeleteCientifico.setBounds(450, yOffset, 100, 23);
        lblDeleteCientifico.setAlignmentX(Component.LEFT_ALIGNMENT);
        cientificosPanel.add(lblDeleteCientifico);

        JLabel lblUpdateCientifico = new JLabel("UPDATE");
        lblUpdateCientifico.setBounds(560, yOffset, 100, 23);
        lblUpdateCientifico.setAlignmentX(Component.LEFT_ALIGNMENT);
        cientificosPanel.add(lblUpdateCientifico);
    }
}
