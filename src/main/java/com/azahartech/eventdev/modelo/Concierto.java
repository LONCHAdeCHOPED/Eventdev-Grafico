package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Concierto extends Evento {

    // ATRIBUTOS
    private String bandaPrincipal;
    private double costeMontaje;
    private String listaCanciones;

    // CONSTRUCTOR
    public Concierto(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, TipoEvento tipoEvento,
                     String bandaPrincipal, double costeMontaje, String listaCanciones) {

        super(nombre, fecha, recinto, precioEntrada, tipoEvento);
        this.bandaPrincipal = bandaPrincipal;
        this.costeMontaje = costeMontaje;
        this.listaCanciones = listaCanciones;
    }

    //getters


    public String getBandaPrincipal() {
        return bandaPrincipal;
    }

    public String getListaCanciones() {
        return listaCanciones;
    }

    public double getCosteMontaje() {
        return costeMontaje;
    }

    // SETTERS


    public void setBandaPrincipal(String bandaPrincipal) {
        this.bandaPrincipal = bandaPrincipal;
    }

    public void setCosteMontaje(double costeMontaje) {
        this.costeMontaje = costeMontaje;
    }

    public void setListaCanciones(String listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    @Override
    public double calcularCosteOperativo() {
        // Actualmente solo devuelve el coste de montaje
        // Se podría mejorar sumando más costes
        return costeMontaje;
    }
}