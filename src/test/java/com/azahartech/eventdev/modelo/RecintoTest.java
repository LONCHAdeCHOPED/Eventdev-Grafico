package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecintoTest {

    @Test
    void debe_Devolver_True_Al_Reservar_Un_Asiento_Vip_Y_Debe_Devolver_9_Al_Contar_Asientos_Vips_Libres() {
        Recinto recinto = new Recinto("Palacio", "Calle mayor", 500);

        assertTrue(recinto.reservarAsientoVip(1));
        assertEquals(9, recinto.contarAsientosVipLibres());
    }

    @Test
    void debe_Devolver_False_Al_Intentar_Reservar_Un_Asiento_Vip_Ya_Reservado(){
        Recinto recinto = new Recinto("Palacio", "Calle mayor", 500);

        recinto.reservarAsientoVip(2);
        assertFalse(recinto.reservarAsientoVip(2));
    }

    @Test
    void debe_Devolver_10_Al_Contar_Asientos_Vips_De_Un_Recinto_Por_Primera_Vez() {
        Recinto recinto = new Recinto("Palacio", "Calle mayor", 500);

        assertEquals(10, recinto.contarAsientosVipLibres());
    }

    @Test
    void debe_Devolver_False_Al_Intentar_Reservar_Asiento_Vip_Fuera_Del_Rango_Disponible_De_Asientos(){
        Recinto recinto = new Recinto("Palacio", "Calle mayor", 500);

        assertFalse(recinto.reservarAsientoVip(11));
    }
}