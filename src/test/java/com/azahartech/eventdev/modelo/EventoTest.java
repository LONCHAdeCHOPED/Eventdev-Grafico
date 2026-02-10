package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    private Concierto evento;
    private Recinto recinto;
    private LocalDate fecha;


    @Test
    void testConstructor() {
        assertEquals("Concierto", evento.consultarNombre());
        assertEquals(fecha, evento.consultarFecha());
        assertEquals(recinto, evento.consultarRecinto());
        assertEquals(50.0, evento.consultarPrecio());
        assertEquals("PROGRAMADO", evento.consultarEstado());
    }

    @Test
    void testConsultarNombre() {
        assertEquals("Concierto", evento.consultarNombre());
    }

    @Test
    void testConsultarFecha() {
        assertEquals(fecha, evento.consultarFecha());
    }

    @Test
    void testConsultarPrecio() {
        assertEquals(50.0, evento.consultarPrecio());
    }

    @Test
    void testConsultarRecinto() {
        assertEquals(recinto, evento.consultarRecinto());
    }

    @Test
    void testConsultarEstado() {
        assertEquals("PROGRAMADO", evento.consultarEstado());
    }

    @Test
    void testModificarPrecio() {
        evento.modificarPrecio(75.0);
        assertEquals(75.0, evento.consultarPrecio());
    }

    @Test
    void testModificarEstado() {
        evento.modificarEstado("CANCELADO");
        assertEquals("CANCELADO", evento.consultarEstado());
    }

    @Test
    void testCalcularPrecioVentaRecomendado() {
        assertEquals(6500.0, evento.calcularPrecioVentaRecomendado());
    }

    @Test
    void testConsultarId() {
        assertNull(evento.consultarId());
    }
}