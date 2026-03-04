package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class VistaDashboard extends JFrame {
    private JPanel lienzo = (JPanel) this.getContentPane();
    private String nombreUsuario;
    public VistaDashboard(String nombreUsuario){
        this.setTitle("Eventos");
        this.setSize(800, 600);
        lienzo.setLayout(new BorderLayout(10,10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.nombreUsuario = nombreUsuario;
        initUI();

    }


    public void initUI(){
        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new BorderLayout());

        // Barra lateral WEST
        JPanel pnlLateral = new JPanel();
        pnlLateral.setBackground(Color.gray);

        JButton btnCatalogo = new JButton("Catalogo");
        JButton btnEntrada = new JButton("Mis Entradas");
        JButton btnPerfil = new JButton("Perfil");
        JButton btnSalir = new JButton("Salir");
        pnlLateral.add(btnCatalogo);
        pnlLateral.add(btnEntrada);
        pnlLateral.add(btnPerfil);
        pnlLateral.add(btnSalir);
        pnlLateral.setLayout(new GridLayout(10,1));
        lienzo.add(pnlLateral, BorderLayout.WEST);

        // Barra de Estado SOUTH
        JPanel pnlEstado = new JPanel();
        JLabel lblUsuario = new JLabel();
        lblUsuario.setText("Usuario: " + nombreUsuario);
        pnlEstado.add(lblUsuario);
        pnlEstado.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlPrincipal.add(pnlEstado, BorderLayout.SOUTH);

        // Zona central CENTER
        JPanel pnlCentral = new JPanel();
        pnlCentral.setBackground(Color.white);
        lienzo.add(pnlCentral, BorderLayout.CENTER);
        JPanel listaPanel = new JPanel();
        listaPanel.setBorder(BorderFactory.createCompoundBorder(listaPanel.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        GridLayout gridLayout = new GridLayout(0,1);
        gridLayout.setVgap(10);
        listaPanel.setLayout(gridLayout);
        listaPanel.setBackground(Color.white);


        for (int i = 0; i < 15 ; i++) {
            TarjetaEvento tarjetaEvento = new TarjetaEvento("Concierto A", "Fecha: 29/12/26", "12");
            tarjetaEvento.setBorder(BorderFactory.createCompoundBorder(tarjetaEvento.getBorder(), BorderFactory.createEmptyBorder(15,15,15,15)));
            listaPanel.add(tarjetaEvento);
        }
        JScrollPane scroll = new JScrollPane(listaPanel);
        pnlPrincipal.add(scroll, BorderLayout.CENTER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setBorder(BorderFactory.createCompoundBorder(scroll.getBorder(), BorderFactory.createEmptyBorder(5,5,5,5)));
        lienzo.add(pnlPrincipal);

        btnSalir.addActionListener(e -> {
            int confirmar = JOptionPane.showConfirmDialog(this,
                    "¿Seguro que quieres cerrar sesion?",
                    "Cerrar sesion",
                    JOptionPane.YES_NO_OPTION);

            if (confirmar == JOptionPane.YES_OPTION) {
                this.dispose();
                new VistaLogin().setVisible(true);
            }
        });








    }
}
