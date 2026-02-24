package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class TarjetaEvento extends JPanel {

    public TarjetaEvento(String nuevoTitulo, String nuevoFecha, String nuevoPrecio){

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.blue));
        JTextArea txtFecha = new JTextArea(nuevoFecha);
        this.add(txtFecha, BorderLayout.CENTER);

        // Botones SUR
        JButton btnComprar = new JButton("Comprar - " + nuevoPrecio);
        this.add(btnComprar, BorderLayout.SOUTH);

        // Panel Titulo
        JLabel lblTitulo = new JLabel(nuevoTitulo);
        lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        this.setBackground(Color.white);
        this.add(lblTitulo, BorderLayout.NORTH);

    }
}
