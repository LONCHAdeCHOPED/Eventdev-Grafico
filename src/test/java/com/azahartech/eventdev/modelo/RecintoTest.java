package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecintoTest {

    @Test
    void testConstructorYConsultar(){
        Recinto recinto = new Recinto("Palacio", "Calle mayor", 500);

        assertEquals("Palacio", recinto.getNombre());
        assertEquals("Calle mayor", recinto.getDireccion());
        assertEquals(500, recinto.getAforoMaximo());

    }

    @Test
    void testReservarAsientoVip() {
        Recinto recinto = new Recinto("Palacio", "Calle mayor", 500);

        assertTrue(recinto.reservarAsientoVip(1));
        assertEquals(9, recinto.contarAsientosVipLibres());
    }

    @Test
    void testReservarAsientoVipReservado(){
        Recinto recinto = new Recinto("Palacio", "Calle mayor", 500);

        recinto.reservarAsientoVip(2);
        assertFalse(recinto.reservarAsientoVip(2));
    }

    @Test
    void testContarAsientosVipLibres() {
        Recinto recinto = new Recinto("Palacio", "Calle mayor", 500);

        assertEquals(10, recinto.contarAsientosVipLibres());
    }

    @Test
    void testReservarAsientoVipFueraDeRango(){
        Recinto recinto = new Recinto("Palacio", "Calle mayor", 500);

        assertFalse(recinto.reservarAsientoVip(11));
    }
}