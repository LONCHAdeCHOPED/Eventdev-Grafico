package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Concierto extends Evento {

    // ATRIBUTOS
    private String bandaPrincipal;
    private double costeMontaje;
    private String listaCanciones;

    // CONSTRUCTOR
    public Concierto(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada,
                     String bandaPrincipal, double costeMontaje, String listaCanciones) {

        super(nombre, fecha, recinto, precioEntrada);
        this.bandaPrincipal = bandaPrincipal;
        this.costeMontaje = costeMontaje;
        this.listaCanciones = listaCanciones;
    }

    public String consultarBandaPrincipal() {
        return bandaPrincipal;
    }

    public double consultarCosteMontaje() {
        return costeMontaje;
    }

    public String consultarListaCanciones() {
        return listaCanciones;
    }

    // SETTERS opcionales
    public void modificarListaCanciones(String nuevaLista) {
        this.listaCanciones = nuevaLista;
    }

    @Override
    public double calcularCosteOperativo() {
        // Actualmente solo devuelve el coste de montaje
        // Se podría mejorar sumando más costes
        return costeMontaje;
    }
}