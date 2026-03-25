package com.azahartech.eventdev.util;

import com.azahartech.eventdev.modelo.ErrorNivel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UtilidadLog {
    private static final String CARPETA_LOG = "log";
    private static final String RUTA_LOG = "log/auditoria.log";

    public static void registrar(ErrorNivel nivel, String mensaje){
        LocalDateTime ahora = LocalDateTime.now();
        LocalDate fecha = LocalDate.now();
        String linea = "[" + fecha + " " + ahora.getHour() + ":" + ahora.getMinute() + ":" + ahora.getSecond() + "]" + " ["+ nivel + "] " + mensaje;

        if (!new File(CARPETA_LOG).exists() || !new File(CARPETA_LOG).isDirectory()){
            new File(CARPETA_LOG).mkdir();
        }
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_LOG, true))) {
            escritor.write(linea);
            escritor.newLine();

        } catch (IOException e) {
            System.out.println("Error al intentar escribir en el archivo");

        }
    }

}
