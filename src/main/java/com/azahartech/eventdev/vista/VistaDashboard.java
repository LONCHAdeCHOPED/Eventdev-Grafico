package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class VistaDashboard extends JFrame {
    private Container lienzo = this.getContentPane();

    public VistaDashboard(){
        this.setSize(800, 600);
        ((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lienzo.setLayout(new BorderLayout(10,10));
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
        JLabel lblUsuario = new JLabel("Usuario invitado");
        pnlEstado.add(lblUsuario);
        pnlEstado.setLayout(new FlowLayout(FlowLayout.LEFT));
        lienzo.add(pnlEstado, BorderLayout.SOUTH);

        // Zona central CENTER
        JPanel pnlCentral = new JPanel();
        pnlCentral.setBackground(Color.white);
        lienzo.add(pnlCentral, BorderLayout.CENTER);


    }
}
