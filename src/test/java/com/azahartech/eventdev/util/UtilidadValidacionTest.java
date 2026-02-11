package com.azahartech.eventdev.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UtilidadValidacionTest {

    @Test
    void generaraIdAutomatico_DebeDevolverTrue_SiElIdEsValido() {
        String resultado;

        resultado = UtilidadValidacion.generaraIdAutomatico("Madrid");

        assertEquals("EVT-"+ LocalDate.now().getYear()+"-MADRI", resultado);
    }
    @Test
    void generaraIdAutomatico_DebeDevolverTrue_SiElIdEsValidoConUnNombreNulo() {
        String resultado;

        resultado = UtilidadValidacion.generaraIdAutomatico(null);

        assertEquals("EVT-"+ LocalDate.now().getYear()+"-DEFAU", resultado);
    }
}