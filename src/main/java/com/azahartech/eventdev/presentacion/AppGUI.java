package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.ErrorNivel;
import com.azahartech.eventdev.modelo.Evento;
import com.azahartech.eventdev.servicio.ServicioEvento;
import com.azahartech.eventdev.util.UtilidadLog;
import com.azahartech.eventdev.vista.VistaDashboard;
import com.azahartech.eventdev.vista.VistaLogin;
import com.azahartech.eventdev.vista.VistaRegistro;

import javax.swing.*;

public class AppGUI {
    public final static ServicioEvento servicioPrincipal = new ServicioEvento();
    public final static UtilidadLog LogUtil = new UtilidadLog();

    public static void main(String[] args) {
        servicioPrincipal.importarEventosDesdeCSV("datos/eventos_importar.csv");
        System.out.println();
        for (Evento evento : servicioPrincipal.listarTodosLosEventos()) {
            System.out.println(evento.getNombre() + " " + evento.getFecha() + " " + evento.getPrecio());
        }

        LogUtil.registrar(ErrorNivel.INFO,"Inicio de la aplicación");
        /*
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new VistaLogin().setVisible(true);
        });
        */
//        SwingUtilities.invokeLater(() -> {
//            new VistaRegistro().setVisible(true);
//        });

//        SwingUtilities.invokeLater(() -> {
//            new VistaDashboard().setVisible(true);
//        });

    }
}
