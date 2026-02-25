package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class VistaLogin extends JFrame {
    private Container lienzo = this.getContentPane();

    private JTextField emailField;
    private JPasswordField contrasenyaField;
    private JButton loginButton;
    private JButton registroButton;
    private JButton salirButton;


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
        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridLayout(2,2,10,10));
        JLabel lblEmail = new JLabel("Email: ");
        this.emailField = new JTextField();
        JLabel lblPassword = new JLabel("Contraseña");
        this.contrasenyaField = new JPasswordField();
        formularioPanel.add(lblEmail);
        formularioPanel.add(emailField);
        formularioPanel.add(lblPassword);
        formularioPanel.add(contrasenyaField);

        lienzo.add(formularioPanel, BorderLayout.CENTER);

        // JLabel Titulo Bienvenida
        JLabel lblBienvenida = new JLabel("Bienvenido a EventDEV");
        lblBienvenida.setFont(new Font("Arial",Font.BOLD,18));
        lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        lienzo.add(lblBienvenida, BorderLayout.NORTH);

        // JPanel Botonera Sur
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.loginButton = new JButton("Entrar");
        this.registroButton = new JButton("Registrarse");
        this.salirButton = new JButton("Salir");
        pnlBotones.add(loginButton);
        pnlBotones.add(registroButton);
        pnlBotones.add(salirButton);
        lienzo.add(pnlBotones, BorderLayout.SOUTH);
        initListeners();
    }

    private void initListeners(){
        salirButton.addActionListener(e -> {
            // Preguntar antes de salir
            int confirmar = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de que quieres cerrar la aplicación?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION);

            if (confirmar == JOptionPane.YES_OPTION) {
                System.exit(0); // Cierra la JVM
            }
        });

        loginButton.addActionListener(e -> intentarLogin());
        contrasenyaField.addActionListener(e -> intentarLogin());
    }

    private void intentarLogin(){
        // 1. Capturar los datos
        String email = emailField.getText();
        // OJO: getPassword devuelve char[], hay que convertirlo a String
        String contrasenya = new String(contrasenyaField.getPassword());
        // 2. Validar (simulación)
        if (email.equals("admin@eventdev.com") && contrasenya.equals("1234")) {
            // Caso de éxito
            JOptionPane.showMessageDialog(this,
                    "¡Bienvenido al sistema, Admin!",
                    "Acceso concedido",
                    JOptionPane.INFORMATION_MESSAGE);

            // Aquí en el futuro abriremos el Dashboard
        } else {
            // Caso de error
            JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);

            // Buena práctica: limpiar la contraseña y poner el foco
            contrasenyaField.setText("");
            contrasenyaField.requestFocus();
        }
    }
}
