package com.azahartech.eventdev.datos;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public String marshal(LocalDate fecha) {
        return fecha.toString();
    }

    @Override
    public LocalDate unmarshal(String texto) {
        return LocalDate.parse(texto);
    }

}
