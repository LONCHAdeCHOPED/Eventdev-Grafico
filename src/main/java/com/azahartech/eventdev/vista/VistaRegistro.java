package com.azahartech.eventdev.vista;

import com.azahartech.eventdev.servicio.ServicioEvento;

import javax.swing.*;
import java.awt.*;

public class VistaRegistro extends JFrame {
    private Container lienzo = this.getContentPane();

    private JTextField nombreField;
    private JTextField emailField;
    private JPasswordField passwdField;
    private JPasswordField repitPasswdField;
    private JTextField edadField;
    private JButton guardarButton;
    private JButton cancelarButton;

    public VistaRegistro() {
        this.setTitle("Nuevo Usuario");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lienzo.setLayout(new BorderLayout(10, 10));
        ((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        initUI();
    }

    private void initUI(){
        JPanel FormularioPanel = new JPanel();
        FormularioPanel.setLayout(new GridLayout(5,5,5,5));

        JLabel nombreLabel = new JLabel("Nombre completo: ");
        this.nombreField = new JTextField();
        JLabel emailLabel = new JLabel("Email: ");
        this.emailField = new JTextField();
        JLabel passwdLabel = new JLabel("Contraseña: ");
        this.passwdField = new JPasswordField();
        JLabel repitPasswdLabel = new JLabel("Repetir contraseña: ");
        this.repitPasswdField = new JPasswordField();
        JLabel edadLabel = new JLabel("Edad: ");
        this.edadField = new JTextField();

        FormularioPanel.add(nombreLabel);
        FormularioPanel.add(nombreField);
        FormularioPanel.add(emailLabel);
        FormularioPanel.add(emailField);
        FormularioPanel.add(passwdLabel);
        FormularioPanel.add(passwdField);
        FormularioPanel.add(repitPasswdLabel);
        FormularioPanel.add(repitPasswdField);
        FormularioPanel.add(edadLabel);
        FormularioPanel.add(edadField);
        lienzo.add(FormularioPanel, BorderLayout.CENTER);


        // Botones del Formulario
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.guardarButton = new JButton("Guardar");
        this.cancelarButton = new JButton("Cancelar");
        pnlBotones.add(guardarButton);
        pnlBotones.add(cancelarButton);
        lienzo.add(pnlBotones, BorderLayout.SOUTH);


        // Titulo Resgistro Usuario
        JLabel lblBienvenida = new JLabel("Registro Usuario");
        lblBienvenida.setFont(new Font("Arial",Font.BOLD,18));
        lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        lienzo.add(lblBienvenida, BorderLayout.NORTH);

        initListeners();

    }

    private void initListeners(){
        guardarButton.addActionListener(e -> registroUsuario());
        edadField.addActionListener(e -> registroUsuario());
        cancelarButton.addActionListener(e -> cancelar());
    }

    public void registroUsuario(){
        String nombreCompleto = nombreField.getText();
        String email = emailField.getText();
        String passwd = new String(passwdField.getPassword());
        String repitPasswd = new String(repitPasswdField.getPassword());
        String edad = edadField.getText();

        if (!passwd.equals(repitPasswd)){
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden",
                    "Error al registrar", JOptionPane.ERROR_MESSAGE);
        } else if (nombreCompleto.equals("") || email.equals("") || edad.equals("")){
            JOptionPane.showMessageDialog(this, "Los campos estan vacios",
                    "Error al registrar", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente",
                    "Usuario registrado", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    public void cancelar(){
       this.dispose();
       VistaLogin login = new VistaLogin();
       login.setVisible(true);
    }
}
