package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ConciertoTest {

    private Concierto concierto;
    private Recinto recinto;
    private LocalDate fecha;

    @Test
    void testConstructor() {
        assertEquals("Rock Fest", concierto.consultarNombre());
        assertEquals(fecha, concierto.consultarFecha());
        assertEquals(recinto, concierto.consultarRecinto());
        assertEquals(45.0, concierto.consultarPrecio());
        assertEquals("PROGRAMADO", concierto.consultarEstado());
        assertEquals("Rolling Stones", concierto.consultarBandaPrincipal());
        assertEquals(8000.0, concierto.consultarCosteMontaje());
        assertEquals("Paint It Black", concierto.consultarListaCanciones());
    }

    @Test
    void testConsultarBandaPrincipal() {
        assertEquals("Rolling Stones", concierto.consultarBandaPrincipal());
    }

    @Test
    void testConsultarCosteMontaje() {
        assertEquals(8000.0, concierto.consultarCosteMontaje());
    }

    @Test
    void testConsultarListaCanciones() {
        assertEquals("Paint It Black", concierto.consultarListaCanciones());
    }

    @Test
    void testModificarListaCanciones() {
        concierto.modificarListaCanciones("Angie");
        assertEquals("Angie", concierto.consultarListaCanciones());
    }

    @Test
    void testCalcularCosteOperativo() {
        assertEquals(8000.0, concierto.calcularCosteOperativo());
    }

    @Test
    void testCalcularPrecioVentaRecomendado() {
        assertEquals(10400.0, concierto.calcularPrecioVentaRecomendado());
    }

    @Test
    void testHerenciaMetodos() {
        concierto.modificarPrecio(55.0);
        assertEquals(55.0, concierto.consultarPrecio());

        concierto.modificarEstado("VENDIDO");
        assertEquals("VENDIDO", concierto.consultarEstado());
    }
}