package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class TarjetaEvento extends JPanel {
    JButton btnComprar = new JButton();
    public TarjetaEvento(String nuevoTitulo, String nuevoFecha, String nuevoPrecio){

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.blue));
        JTextArea txtFecha = new JTextArea(nuevoFecha);
        this.add(txtFecha, BorderLayout.CENTER);

        // Botones SUR
        btnComprar.setText("Comprar - " + nuevoPrecio);
        this.add(btnComprar, BorderLayout.SOUTH);

        // Panel Titulo
        JLabel lblTitulo = new JLabel(nuevoTitulo);
        lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        this.setBackground(Color.white);
        this.add(lblTitulo, BorderLayout.NORTH);

        this.btnComprar.addActionListener(e -> {
            // Simular compra
            int opcion = JOptionPane.showConfirmDialog(this,
                    "¿Quieres comprar una entrada para " + nuevoTitulo + "?",
                    "Confirmar Compra",
                    JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this,
                        "¡Entrada comprada! (simulación)",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);

                // Opcional: Deshabilitar el botón para no comprar dos veces
                this.btnComprar.setEnabled(false);
                this.btnComprar.setText("Comprado");
            }
        });

    }
}
