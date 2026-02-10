package com.azahartech.eventdev.datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioGenericoTest {
    @Test
    void obtener_DeveDevolverTrue_SiSeEliminaCorrectamente() {
        String resultado;
        RepositorioGenerico<String> repositorioGenerico = new RepositorioGenerico<>();
        repositorioGenerico.guardar("Objeto1");
        repositorioGenerico.guardar("Objeto2");
        repositorioGenerico.guardar("Objeto3");

        assertEquals("Objeto2", repositorioGenerico.obtener(1));
    }

    @Test
    void obtener_DeveDevolverTrue_SiElIndiceSuperaElTamañoDelRepositorio() {
        String resultado;
        RepositorioGenerico<String> repositorioGenerico = new RepositorioGenerico<>();
        repositorioGenerico.guardar("Objeto1");
        repositorioGenerico.guardar("Objeto2");
        repositorioGenerico.guardar("Objeto3");

        assertEquals(null, repositorioGenerico.obtener(-1));
        assertEquals(null, repositorioGenerico.obtener(4));
    }

}