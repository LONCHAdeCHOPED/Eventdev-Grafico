package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class VistaLogin extends JFrame {
    private Container lienzo = this.getContentPane();

    public VistaLogin(){
        this.setTitle("Acceso a EventDEV");
        this.setSize(400, 200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        lienzo.setLayout(new BorderLayout(10, 10));
        ((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        initUI();
    }


    private void initUI(){
        JPanel pnlFormulario = new JPanel();
        pnlFormulario.setLayout(new GridLayout(2,2,10,10));
        JLabel lblEmail = new JLabel("Email: ");
        JTextField txtEmail = new JTextField();
        JLabel lblPassword = new JLabel("Contraseña");
        JPasswordField txtPassword = new JPasswordField();

        pnlFormulario.add(lblEmail);
        pnlFormulario.add(txtEmail);
        pnlFormulario.add(lblPassword);
        pnlFormulario.add(txtPassword);

        lienzo.add(pnlFormulario, BorderLayout.CENTER);

        // JLabel Titulo Bienvenida
        JLabel lblBienvenida = new JLabel("Bienvenido a EventDEV");
        lblBienvenida.setFont(new Font("Arial",Font.BOLD,18));
        lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        lienzo.add(lblBienvenida, BorderLayout.NORTH);

        // JPanel Botonera Sur
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnLogin = new JButton("Entrar");
        JButton btnRegistro = new JButton("Registrarse");
        pnlBotones.add(btnLogin);
        pnlBotones.add(btnRegistro);
        lienzo.add(pnlBotones, BorderLayout.SOUTH);

    }
}
