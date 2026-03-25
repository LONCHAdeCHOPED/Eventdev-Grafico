package com.azahartech.eventdev.vista;

import com.azahartech.eventdev.modelo.Evento;
import com.azahartech.eventdev.modelo.Partido;
import com.azahartech.eventdev.modelo.Recinto;
import com.azahartech.eventdev.servicio.ServicioEvento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import static com.azahartech.eventdev.presentacion.AppGUI.servicioPrincipal;

public class VistaDashboard extends JFrame {
    private JPanel lienzo = (JPanel) this.getContentPane();
    private String nombreUsuario;
    private JButton btnSalir;
    private JMenuBar principalMenuBar;
    private JMenuItem salirItem;
    private JMenuItem cerrarSesionItem;
    private String[] nombresColumnas;
    private DefaultTableModel eventosTableModel;
    private JButton detalleButton;
    private JTable eventosTable;
    private JMenuItem nuevoEventoItem;
    private ServicioEvento servicio;


    public VistaDashboard(String nombreUsuario){
        this.setTitle("Eventos");
        this.setSize(800, 600);
        lienzo.setLayout(new BorderLayout(10,10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.nombreUsuario = nombreUsuario;
        this.nombresColumnas = new String[] {"ID", "Nombre", "Fecha", "Precio"};
        eventosTableModel = new DefaultTableModel(nombresColumnas, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.servicio = servicioPrincipal;
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
        btnSalir = new JButton("Salir");
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
        detalleButton = new JButton("Ver detalles");
        pnlEstado.add(detalleButton);
        lienzo.add(pnlEstado, BorderLayout.SOUTH);


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

        for (int i = 0; i < 5 ; i++) {
            servicio.registrarEvento(new Partido("Partido", LocalDate.now(), new Recinto("Castalia", "C/ Caminas", 126),122, "Caminas", "Caminas2", 22));
//            TarjetaEvento tarjetaEvento = new TarjetaEvento("Concierto A", "Fecha: 29/12/26", "12");
//            tarjetaEvento.setBorder(BorderFactory.createCompoundBorder(tarjetaEvento.getBorder(), BorderFactory.createEmptyBorder(15,15,15,15)));
//            listaPanel.add(tarjetaEvento);
        }

        refrescar();
        eventosTable = new JTable(eventosTableModel);
        JScrollPane scroll = new JScrollPane(eventosTable);
        pnlPrincipal.add(scroll, BorderLayout.CENTER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setBorder(BorderFactory.createCompoundBorder(scroll.getBorder(), BorderFactory.createEmptyBorder(5,5,5,5)));
        lienzo.add(pnlPrincipal);

        initMenu();
        initListeners();

    }

    private void refrescar(){
        eventosTableModel.setRowCount(0);
        for (Evento listarTodosLosEvento : servicio.listarTodosLosEventos()) {
            Object[] evento1 = {listarTodosLosEvento.getId(), listarTodosLosEvento.getNombre(), listarTodosLosEvento.getFecha(), listarTodosLosEvento.getPrecio()};
            eventosTableModel.addRow(evento1);
        }
    }

    private void initListeners(){
        btnSalir.addActionListener(e -> intentarSalir());
        salirItem.addActionListener(e -> intentarSalir());
        cerrarSesionItem.addActionListener(e -> intentarSalir());
        detalleButton.addActionListener(e -> intentarVerDetalle());
        nuevoEventoItem.addActionListener(e -> {
            NuevoEventoDialog dialog = new NuevoEventoDialog(this, servicio);
            dialog.setVisible(true);
            refrescar();
        });
    }

    private void intentarSalir(){
        int confirmar = JOptionPane.showConfirmDialog(this,
                "¿Seguro que quieres cerrar sesion?",
                "Cerrar sesion",
                JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            this.dispose();
            new VistaLogin().setVisible(true);
        }
    }

    private void intentarVerDetalle(){
        int filaSeleccionada = eventosTable.getSelectedRow();
        if (filaSeleccionada == -1){
            JOptionPane.showMessageDialog(this,
                    "Por favor, selecciona un evento",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String nombreEvento = eventosTable.getValueAt(filaSeleccionada, 1).toString();
            String fechaEvento = eventosTable.getValueAt(filaSeleccionada, 2).toString();
            String precio = eventosTable.getValueAt(filaSeleccionada, 3).toString();
            JOptionPane.showMessageDialog(this,
                    "Nombre: " + nombreEvento +
                            "\nFecha: " +fechaEvento+
                            "\nPrecio: " +precio,
                    "Detalles del evento",1);
        }
    }

    private void initMenu(){
        principalMenuBar = new JMenuBar();
        JMenu archivoMenu = new JMenu("Archivo");
        JMenu accionesMenu = new JMenu("Acciones");

        cerrarSesionItem = new JMenuItem("Cerrar sesion");
        salirItem = new JMenuItem("Salir");
        archivoMenu.add(cerrarSesionItem);
        archivoMenu.add(salirItem);
        nuevoEventoItem = new JMenuItem("Nuevo evento");
        accionesMenu.add(nuevoEventoItem);

        principalMenuBar.add(archivoMenu);
        principalMenuBar.add(accionesMenu);

        this.setJMenuBar(principalMenuBar);
    }
}
