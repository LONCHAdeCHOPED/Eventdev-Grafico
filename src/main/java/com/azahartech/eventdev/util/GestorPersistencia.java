package com.azahartech.eventdev.util;

import java.io.*;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;


public class GestorPersistencia {

    private static final String CARPETA_LOG = "datos";

    public <T> void guardarDatos(List<T> datos, String rutaArchivo){
        File archivo = new File(rutaArchivo);
        if (archivo.exists()){
            archivo.renameTo(new File(rutaArchivo + ".bak"));
        }

        if (!new File(CARPETA_LOG).exists() || !new File(CARPETA_LOG).isDirectory()){
            new File(CARPETA_LOG).mkdir();
        }
        try (FileOutputStream fos = new FileOutputStream(archivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(datos);
            System.out.printf("Datos guardados en " + archivo.getAbsolutePath());

        } catch (IOException e){
            System.out.println("Error al guardar datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public <T> List<T> cargarDatos(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fis = new FileInputStream(archivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object objetoLeido = ois.readObject();
            return (List<T>) objetoLeido;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
