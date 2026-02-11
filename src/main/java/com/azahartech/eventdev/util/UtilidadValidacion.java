package com.azahartech.eventdev.util;

import java.time.LocalDate;

public class UtilidadValidacion {
    /**
     *
     * @param email
     * Sirve para la validacion del email.
     * @return
     */
    public static boolean esEmailValido(String email) {
        return email.matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\.]+\\.[a-z]{2,4}");
    }

    /**
     * @param fecha
     * Comprueba que la fecha de un evento sea futura.
     * */
    public static boolean esFechaFutura(LocalDate fecha) {
        if (fecha == null) {
            return false;
        } else {
            return fecha.isAfter(LocalDate.now());
        }
    }
    /**
     * Valida si un telefono tiene 9 digitos
     * @param telefono
     * @return
     */
    public static boolean esTelefonoValido(String telefono) {
        return telefono.matches("^[0-9]{9}");
    }

    /**
     * Este metodo genera un ID Automaticamente
     *
     * Formato:
     * 1 Palabra: Los 5 primeros caracteres
     * 5 Palabra: Cada sigla de una palabra
     *
     * @param nombre
     * @return devuelve un ID
     */
    public static String generaraIdAutomatico(String nombre){
        final String PREDETERMINADO = "DEFAU";
        nombre = (nombre != null) ? nombre : PREDETERMINADO;
        String resultado;
        int año = LocalDate.now().getYear();

        String siglas = nombre.toUpperCase().substring(0, (nombre.length() > 5)? 5: nombre.length());


        resultado = String.format("EVT-%s-%s", año, siglas);

        return resultado;
    }
}
