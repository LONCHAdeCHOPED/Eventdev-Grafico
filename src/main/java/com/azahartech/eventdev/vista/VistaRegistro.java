package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class VistaRegistro extends JFrame {
    private Container lienzo = this.getContentPane();

    public VistaRegistro() {
        this.setTitle("Formulario De Registro");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        lienzo.setLayout(new BorderLayout(10, 10));
        ((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        initUI();
    }

    private void initUI(){
        JPanel pnlFormulario = new JPanel();
        pnlFormulario.setLayout(new GridLayout(5,5,5,5));

        JLabel lblNombre = new JLabel("Nombre completo: ");
        JTextField txtNombre = new JTextField();
        JLabel lblEmail = new JLabel("Email: ");
        JTextField txtEmail = new JTextField();
        JLabel lblPasswd = new JLabel("Contraseña: ");
        JPasswordField txtPasswd = new JPasswordField();
        JLabel lblRepitPasswd = new JLabel("Introduzca de nuevo la contraseña: ");
        JPasswordField txtRepitPasswd = new JPasswordField();
        JLabel lblEdad = new JLabel("Edad: ");
        JTextField txtEdad = new JTextField();

        pnlFormulario.add(lblNombre);
        pnlFormulario.add(txtNombre);
        pnlFormulario.add(lblEmail);
        pnlFormulario.add(txtEmail);
        pnlFormulario.add(lblPasswd);
        pnlFormulario.add(txtPasswd);
        pnlFormulario.add(lblRepitPasswd);
        pnlFormulario.add(txtRepitPasswd);
        pnlFormulario.add(lblEdad);
        pnlFormulario.add(txtEdad);
        lienzo.add(pnlFormulario, BorderLayout.CENTER);


        // Botones del Formulario
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        pnlBotones.add(btnGuardar);
        pnlBotones.add(btnCancelar);
        lienzo.add(pnlBotones, BorderLayout.SOUTH);


        // Titulo Resgistro Usuario
        JLabel lblBienvenida = new JLabel("Registro Usuario");
        lblBienvenida.setFont(new Font("Arial",Font.BOLD,18));
        lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        lienzo.add(lblBienvenida, BorderLayout.NORTH);

    }
}
