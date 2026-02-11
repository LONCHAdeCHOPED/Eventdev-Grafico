package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.modelo.Usuario;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServicioUsuarioTest {

    @Test
    void buscarPorNombre_debe_devolver_el_usuario_si_lo_busca_por_su_nombre() {
        Usuario usuarioPepe = new Usuario("pepe", "pepe@gmail.com", "123456789", true);
        ServicioUsuario servicioUsuarioPrueba = new ServicioUsuario();
        servicioUsuarioPrueba.registrarUsuario(usuarioPepe);

        assertEquals(usuarioPepe, servicioUsuarioPrueba.buscarPorNombre("pepe"), "El usuario deberia de ser encontrado por el nombre");
    }

    @Test
    void buscarPorEmail_debe_devolver_el_usuario_si_lo_busca_por_su_nombre() {
        Usuario usuarioPepe = new Usuario("pepe", "pepe@gmail.com", "123456789", true);
        ServicioUsuario servicioUsuarioPrueba = new ServicioUsuario();
        servicioUsuarioPrueba.registrarUsuario(usuarioPepe);
        assertEquals(usuarioPepe, servicioUsuarioPrueba.buscarPorEmail("pepe@gmail.com"), "El usuario deberia de ser encontrado por el email");
    }

    @Test
    void listarTodosLosUsuario_debe_devolver_una_lista_de_los_usuario_guardados() {
        Usuario usuarioPepe = new Usuario("pepe", "pepe@gmail.com", "123456789", true);
        ServicioUsuario servicioUsuarioPrueba = new ServicioUsuario();
        List<Usuario> esperado = new ArrayList<>();
        esperado.add(usuarioPepe);
        servicioUsuarioPrueba.registrarUsuario(usuarioPepe);
        assertIterableEquals(esperado, servicioUsuarioPrueba.listarTodosLosUsuario(), "Deberia de devolver una lista de los usuarios guardados");
    }
}