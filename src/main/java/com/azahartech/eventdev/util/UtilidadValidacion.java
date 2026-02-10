package com.azahartech.eventdev.util;

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
}
