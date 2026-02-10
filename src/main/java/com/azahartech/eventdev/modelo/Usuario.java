package com.azahartech.eventdev.modelo;

public class Usuario {
    private String nombre;
    private String email;
    private String telefono;
    private boolean esVip;

    public Usuario(String nombre, String email, String telefono, boolean esVip) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.esVip = esVip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEsVip() {
        return esVip;
    }

    public void setEsVip(boolean esVip) {
        this.esVip = esVip;
    }



}
