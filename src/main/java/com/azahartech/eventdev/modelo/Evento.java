package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

/**
 * Clase abstracta que representa un evento cultural o deportivo.
 * Sirve como plantilla base para diferentes tipos de eventos específicos
 * (conciertos, partidos deportivos, obras de teatro, etc.).
 *
 * Esta clase encapsula la información común a todos los eventos y
 * proporciona métodos para calcular precios de venta con margen estándar.
 */

public abstract class Evento {


    private String nombre;
    private LocalDate fecha;
    private Recinto recinto;
    private double precio;
    private String id;
    private String estado;

    // Metodo
    /**
     * Constructor para crear un nuevo evento.
     * Inicializa los atributos básicos comunes a todos los tipos de eventos.
     * El estado se establece por defecto como "PROGRAMADO".
     */
    public Evento(String nombre, LocalDate fecha, Recinto recinto, double precio) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.recinto = recinto;
        this.precio = precio;
        this.estado = "PROGRAMADO";
    }

    // CONSULTAS

    public String consultarNombre() {
        return nombre;
    }

    public LocalDate consultarFecha() {
        return fecha;
    }

    public double consultarPrecio() {
        return precio;
    }

    public Recinto consultarRecinto() {
        return recinto;
    }

    public String consultarId() {
        return id;
    }

    public String consultarEstado() {
        return estado;
    }

    // Setters

    public void modificarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    public void modificarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public final double calcularPrecioVentaRecomendado() {
        return calcularCosteOperativo() * 1.3;
    }

    public abstract double calcularCosteOperativo();

}

