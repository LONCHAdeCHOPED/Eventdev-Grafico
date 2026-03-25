package com.azahartech.eventdev.vista;

import com.azahartech.eventdev.modelo.Partido;
import com.azahartech.eventdev.modelo.Recinto;
import com.azahartech.eventdev.servicio.ServicioEvento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;

public class NuevoEventoDialog extends JDialog {
    private JTextField fechaTextField;
    private JTextField nombreTextField;
    private JTextField precioTextField;
    private JButton guardarButton;
    private JButton cancelarButton;
    private ServicioEvento servicio;

    public NuevoEventoDialog(JFrame padre, ServicioEvento servicio){
        super(padre, "Nuevo evento", true);
        ((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.setLocationRelativeTo(null);
        this.servicio = servicio;
        initUI();
    }

    public void initUI(){
        this.setSize(400,200);
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(0,2,5,5));
        JLabel nombreLabel = new JLabel("Nombre: ");
        JLabel fechaLabel = new JLabel("Fecha (YYYY-MM-DD): ");
        JLabel precioLabel = new JLabel("Precio Entrada: ");
        nombreTextField = new JTextField();
        fechaTextField = new JTextField();
        precioTextField = new JTextField();
        panelPrincipal.add(nombreLabel);
        panelPrincipal.add(nombreTextField);
        panelPrincipal.add(fechaLabel);
        panelPrincipal.add(fechaTextField);
        panelPrincipal.add(precioLabel);
        panelPrincipal.add(precioTextField);
        this.add(panelPrincipal, BorderLayout.CENTER);
        fechaTextField.setToolTipText("Formato: AAAA-MM-DD");

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        guardarButton = new JButton("Guardar");
        cancelarButton = new JButton("Cancelar");
        botonesPanel.add(guardarButton);
        botonesPanel.add(cancelarButton);
        this.add(botonesPanel, BorderLayout.SOUTH);

        precioTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String precio = precioTextField.getText();
                try{
                    Double.parseDouble(precio.replace(',','.'));
                    precioTextField.setBackground(Color.white);
                } catch (NumberFormatException ex){
                    precioTextField.setBackground(Color.red);
                }
            }
        });

        initListeners();
    }

    public void initListeners(){
        cancelarButton.addActionListener(e -> intentarCancelar());
        guardarButton.addActionListener(e -> intentarGuardar());
        precioTextField.addActionListener(e -> intentarGuardar());
    }

    public void intentarCancelar(){
        this.dispose();
    }

    public void intentarGuardar(){
        try {
            String nombre = nombreTextField.getText().trim();
            LocalDate fecha = LocalDate.parse(fechaTextField.getText().trim());
            Double precio = Double.parseDouble(precioTextField.getText().trim());
            this.servicio.registrarEvento(new Partido(nombre, fecha, new Recinto("IES CAMINAS", "C/ Gobernador", 10), precio, "Castellon", "Almazora", 12));
            this.dispose();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}
