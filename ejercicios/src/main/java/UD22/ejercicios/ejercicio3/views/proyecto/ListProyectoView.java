package UD22.ejercicios.ejercicio3.views.proyecto;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import java.awt.Color;

import UD22.ejercicios.ejercicio3.models.Proyecto;

public class ListProyectoView extends JFrame {
    private static ListProyectoView instance = null;
    private JPanel proyectoPanel;
    private JButton btnCrearProyecto;

    public static ListProyectoView getInstance() {
        if (instance == null)
            instance = new ListProyectoView();
        return instance;
    }

    private ListProyectoView() {
        getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("Proyectos");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setBounds(35, 23, 265, 46);
        getContentPane().add(lblNewLabel);

        proyectoPanel = new JPanel();
        proyectoPanel.setLayout(null);
        proyectoPanel.setBounds(35, 80, 870, 800);
        getContentPane().add(proyectoPanel);

        btnCrearProyecto = new JButton("Crear proyecto");
        btnCrearProyecto.setForeground(Color.WHITE);
        btnCrearProyecto.setBackground(new Color(0, 128, 0));
        int buttonWidth = btnCrearProyecto.getPreferredSize().width;
        int xPosition = proyectoPanel.getX() + proyectoPanel.getWidth() - buttonWidth;
        btnCrearProyecto.setBounds(xPosition, 23, buttonWidth, 28);
        getContentPane().add(btnCrearProyecto);
    }

    public JButton getBtnCrearProyecto() {
        return btnCrearProyecto;
    }

    public JPanel getProyectoPanel() {
        return proyectoPanel;
    }

    public void generarProyectos(List<Proyecto> proyectos) {
        proyectoPanel.removeAll();
        proyectoPanel.revalidate();
        proyectoPanel.repaint();
        generarCabeceraProyectos();

        int yOffset = 40;
        int buttonWidth = 89;
        int buttonHeight = 23;
        int buttonMargin = 10;
        int xStart = 0;

        for (Proyecto proyecto : proyectos) {
            JLabel lblId = new JLabel(proyecto.getId());
            lblId.putClientProperty("proyectoID", proyecto.getId());
            lblId.setBounds(xStart, yOffset, 52, 28);

            xStart += 52;

            JLabel lblNombre = new JLabel(proyecto.getNombre());
            lblNombre.putClientProperty("proyectoID", proyecto.getId());
            lblNombre.setBounds(xStart, yOffset, 155, 28);

            xStart += 165;

            JLabel lblHoras = new JLabel(String.valueOf(proyecto.getHoras()));
            lblHoras.putClientProperty("proyectoID", proyecto.getId());
            lblHoras.setBounds(xStart, yOffset, 175, 28);

            xStart += 185;

            JButton btnDeleteProyecto = new JButton("Delete");
            btnDeleteProyecto.putClientProperty("proyectoID", proyecto.getId());
            btnDeleteProyecto.setForeground(Color.BLACK);
            btnDeleteProyecto.setBackground(Color.RED);
            btnDeleteProyecto.setBounds(xStart, yOffset, buttonWidth, buttonHeight);

            xStart += buttonWidth + buttonMargin;

            JButton btnUpdateProyecto = new JButton("Update");
            btnUpdateProyecto.putClientProperty("proyectoID", proyecto.getId());
            btnUpdateProyecto.setForeground(Color.BLACK);
            btnUpdateProyecto.setBackground(Color.ORANGE);
            btnUpdateProyecto.setBounds(xStart, yOffset, buttonWidth, buttonHeight);

            proyectoPanel.add(lblId);
            proyectoPanel.add(lblNombre);
            proyectoPanel.add(lblHoras);
            proyectoPanel.add(btnDeleteProyecto);
            proyectoPanel.add(btnUpdateProyecto);

            yOffset += 30;
            xStart = 0;
        }

        revalidate();
    }

    private void generarCabeceraProyectos() {
        int yOffset = 0;
        int xStart = 0;

        JLabel lblIdProyecto = new JLabel("ID");
        lblIdProyecto.setBounds(xStart, yOffset, 52, 28);
        proyectoPanel.add(lblIdProyecto);

        xStart += 52;

        JLabel lblNombreProyecto = new JLabel("NOMBRE");
        lblNombreProyecto.setBounds(xStart, yOffset, 150, 28);
        proyectoPanel.add(lblNombreProyecto);

        xStart += 150;

        JLabel lblHorasProyecto = new JLabel("HORAS");
        lblHorasProyecto.setBounds(xStart, yOffset, 225, 28);
        proyectoPanel.add(lblHorasProyecto);

        int buttonWidth = 55;

        xStart += 225;

        JLabel lblDeleteProyecto = new JLabel("DELETE");
        lblDeleteProyecto.setBounds(xStart, yOffset, buttonWidth, 23);
        proyectoPanel.add(lblDeleteProyecto);

        xStart += buttonWidth + 20;

        JLabel lblUpdateProyecto = new JLabel("UPDATE");
        lblUpdateProyecto.setBounds(xStart, yOffset, 85, 23);
        proyectoPanel.add(lblUpdateProyecto);

        yOffset += 30;
    }
}
