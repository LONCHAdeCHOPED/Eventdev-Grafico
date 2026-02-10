package com.azahartech.eventdev.modelo;

public enum TipoEvento {
    CONCIERTO('C', "Música en vivo"),
    TEATRO('T', "Artes escénicas"),
    DEPORTE('D', "Competición deportiva"),
    FESTIVAL('F', "Evento múltiple");

    private final char codigo;
    private final String descripcion;


    TipoEvento(char codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getDescripcion() { return descripcion; }
    public char getCodigo() { return codigo; }
}
