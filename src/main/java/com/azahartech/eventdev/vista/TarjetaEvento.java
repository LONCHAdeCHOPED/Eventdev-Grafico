package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class TarjetaEvento extends JPanel {
    private String titulo;
    private String fecha;
    private String precio;


    public TarjetaEvento(String nuevoTitulo, String nuevoFecha, String nuevoPrecio){
        precio = nuevoPrecio;
        fecha = nuevoFecha;
        precio = nuevoPrecio;

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.blue));
        // Panel Interno CENTER
        JPanel pnlInterno = new JPanel();
        JTextArea txtTitulo = new JTextArea(titulo);
        JTextArea txtFecha = new JTextArea(fecha);
        pnlInterno.add(txtTitulo);
        pnlInterno.add(txtFecha);
        this.add(pnlInterno, BorderLayout.CENTER);

        // Botones SUR
        JPanel pnlBotones = new JPanel();
        JButton btnComprar = new JButton("Comprar - " + precio);
        pnlBotones.add(btnComprar);
        this.add(pnlBotones, BorderLayout.SOUTH);

        // Panel Titulo
        JPanel pnlTitulo = new JPanel();
        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        pnlBotones.add(lblTitulo);
        this.add(pnlTitulo, BorderLayout.NORTH);

    }
}
