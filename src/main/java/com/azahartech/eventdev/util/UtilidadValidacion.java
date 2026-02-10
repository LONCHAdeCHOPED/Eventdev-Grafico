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
}
