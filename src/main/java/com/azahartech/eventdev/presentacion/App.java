package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.servicio.*;
import com.azahartech.eventdev.util.UtilidadValidacion;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static ServicioUsuario SERVICIO_USUARIO = new ServicioUsuario();
    private final static ServicioEvento SERVICIO_EVENTO = new ServicioEvento();

    private static boolean continuidad = true;

    public static void main(String[] args) {
        System.out.println("""
                           =====================================================
                                EVENTDEV V1.0 - SISTEMA DE GESTIÓN INTEGRAL     
                           =====================================================
                           """);

        System.out.println("[FASE 1: REGISTRO DE USUARIOS]");
        registrarUsuarios();

        System.out.println("[FASE 2: REGISTRO DE EVENTOS]");
        registrarEventos();

        System.out.println("[FASE 3: CONTROL DE ESTADOS]");
        controlEstados();

        System.out.println("[FASE 4: PASARELA DE PAGOS]");
        pasarelaPagos();

        System.out.println("[FASE 4: CONSULTAS Y STREAMS]");
        consultasYStreams();

        System.out.println("[FASE 5: EXPORTACIÓN POLIMÓRFICA]");
        exportacionPolimorfica();

        System.out.println("[FASE 6: CIERRE ESPECÍFICO DE EVENTOS]");
        cierreEspecificoEventos();

        System.out.println("""
                           =====================================================
                                           FIN DE LA DEMOSTRACIÓN
                           =====================================================
                           """);

        SCANNER.close();
    }

    private static void registrarUsuarios(){
        boolean otroUsuario;

        do{
            Usuario usuario;

            String nombre, email, telefono;
            boolean esVip;

            System.out.print("Introduce el nombre:");
            nombre = SCANNER.nextLine();

            do {
                continuidad = true;
                System.out.print("Introduce el email:");
                email = SCANNER.nextLine();

                if (!UtilidadValidacion.esEmailValido(email)) {
                    System.out.println("Error: El email es incorrecto.");
                    continuidad = false;
                }
            } while (!continuidad);


            do {
                continuidad = true;
                System.out.print("Introduce el telefono:");
                telefono = SCANNER.nextLine();

                if (!UtilidadValidacion.esTelefonoValido(telefono)) {
                    System.out.println("Error: El email es incorrecto.");
                    continuidad = false;
                }
            } while (!continuidad);

            System.out.print("Eres Vip (Si/No defecto:No):");
            esVip = SCANNER.nextLine().equalsIgnoreCase("si");

            usuario = new Usuario(nombre, email, telefono, esVip);

            SERVICIO_USUARIO.registrarUsuario(usuario);

            System.out.println("Quieres añadir a otro usuario? (Si/No)");
            otroUsuario = SCANNER.nextLine().equalsIgnoreCase("si");

        } while (otroUsuario);

    }

    private static void registrarEventos(){
        boolean otroEvento;
        do {
            Evento evento = null;
            Recinto recinto;

            String nombre, nombreRecinto, direccionRecinto;
            double precio = 0;
            LocalDate fecha = null;
            TipoEvento tipo;
            int aforoMaximo = 0;

            int opcion;

            System.out.print("Introduce el nombre del evento:");
            nombre = SCANNER.nextLine();

            do {
                continuidad = true;
                try {
                    System.out.print("Introduce el fecha del evento (YYYY-MM-DD):");
                    fecha = LocalDate.parse(SCANNER.nextLine());
                } catch (RuntimeException e) {
                    System.out.println("Formato invalido.");
                    continuidad = false;
                }
            } while (!continuidad);

            System.out.print("Introduce el nombre del recinto:");
            nombreRecinto = SCANNER.nextLine();

            System.out.print("Introduce la direccion del recinto:");
            direccionRecinto = SCANNER.nextLine();

            do {
                continuidad = true;

                try {
                    System.out.print("Introduce el aforo maximo del recinto:");
                    aforoMaximo = SCANNER.nextInt();
                    SCANNER.nextLine();

                    if (aforoMaximo <= 0) {
                        continuidad = false;
                        System.out.println("Error: El valor tiene que ser mayor o igual a 0.");
                    }
                } catch (RuntimeException e) {
                    SCANNER.nextLine();
                    System.out.println("Error: El valor introducido tiene que ser digitos.");
                    continuidad = false;
                }
            } while (!continuidad);

            recinto = new Recinto(nombreRecinto, direccionRecinto, aforoMaximo);

            do {
                continuidad = true;
                try {
                    System.out.print("Introduce el precio del evento:");
                    precio = SCANNER.nextDouble();
                    SCANNER.nextLine();

                    if (precio <= 0) {
                        System.out.println("Error: El valor tiene que ser mayor o igual a 0.");
                        continuidad = false;
                    }
                } catch (RuntimeException e) {
                    SCANNER.nextLine();
                    System.out.println("Error: El valor introducido tiene que ser digitos.");
                    continuidad = false;
                }
            } while (!continuidad);

            do {
                continuidad = true;
                try {
                    opcion = -1;
                    System.out.println("Dime el tipo de evento que es: ");
                    System.out.println("""
                            1. CONCIERTO
                            2. TEATRO
                            3. DEPORTE
                            4. FESTIVAL
                            """);
                    System.out.print("Dime una opcion:");
                    opcion = SCANNER.nextInt();
                    SCANNER.nextLine();

                    if (opcion < 1 || opcion > 4) {
                        System.out.println("Error: La opcion es invalida");
                        continuidad = false;
                    }
                } catch (RuntimeException e) {
                    SCANNER.nextLine();

                    System.out.println("Error: El valor introducido tiene que ser digitos.");

                    opcion = -1;

                    continuidad = false;
                }
            } while (!continuidad);

            switch (opcion) {
                case 1:
                    String bandaPrincipal, listaCanciones;
                    double costeMontaje = 0;

                    tipo = TipoEvento.CONCIERTO;

                    System.out.print("Introduce el nombre de la banda principal:");
                    bandaPrincipal = SCANNER.nextLine();

                    do {
                        continuidad = true;
                        try {
                            System.out.print("Introduce el coste  del evento:");
                            costeMontaje = SCANNER.nextDouble();
                            SCANNER.nextLine();

                            if (costeMontaje <= 0) {
                                System.out.println("Error: El valor tiene que ser mayor o igual a 0.");
                                continuidad = false;
                            }
                        } catch (RuntimeException e) {
                            SCANNER.nextLine();
                            System.out.println("Error: El valor introducido tiene que ser digitos.");
                            continuidad = false;
                        }
                    } while (!continuidad);

                    System.out.print("Introduce las conciones que han tocado la banda principal:");
                    listaCanciones = SCANNER.nextLine();

                    evento = new Concierto(nombre, fecha, recinto, precio, tipo, bandaPrincipal, costeMontaje, listaCanciones);

                    break;
                case 2:
                    System.out.println("PROXIMAMENTE");
                    break;
                case 3:
                    String equipoLocal, equipoVisitante;
                    double costeSeguridad = 0;

                    System.out.print("Introduce el nombre del equipo Local:");
                    equipoLocal = SCANNER.nextLine();

                    System.out.print("Introduce el nombre del equipo Visitante:");
                    equipoVisitante = SCANNER.nextLine();

                    do {
                        continuidad = true;
                        try {
                            System.out.print("Introduce el coste  del evento:");
                            costeSeguridad = SCANNER.nextDouble();
                            SCANNER.nextLine();

                            if (costeSeguridad <= 0) {
                                System.out.println("Error: El valor tiene que ser mayor o igual a 0.");
                                continuidad = false;
                            }
                        } catch (RuntimeException e) {
                            SCANNER.nextLine();
                            System.out.println("Error: El valor introducido tiene que ser digitos.");
                            continuidad = false;
                        }
                    } while (!continuidad);

                    evento = new Partido(nombre, fecha, recinto, precio, equipoLocal, equipoVisitante, costeSeguridad);
                    break;
                case 4:
                    System.out.println("PROXIMAMENTE");
                    break;
            }

            System.out.println("Se ha creado el evento");
            SERVICIO_EVENTO.registrarEvento(evento);

            System.out.print("Quieres crear otro evento (Si/No defecto:no):");
            otroEvento = SCANNER.nextLine().equalsIgnoreCase("si");
        } while (otroEvento);
    }

    private static void controlEstados(){
        Evento evento = SERVICIO_EVENTO.listarTodosLosEventos().get(0);
    }

    private static void pasarelaPagos(){
        Usuario usuario = SERVICIO_USUARIO.listarTodosLosUsuario().get(0);
    }

    private static void consultasYStreams(){
        System.out.println("> Búsqueda instantánea (ID: EVT-2026-DEFAU): " + SERVICIO_EVENTO.buscarEventoPorId("EVT-2026-DEFAU"));
        System.out.println("> Catálogo completo ordenado:");
        SERVICIO_EVENTO.mostrarTodoElCatalogo();
    }

    private static void exportacionPolimorfica(){
        for (Evento evento : SERVICIO_EVENTO.listarTodosLosEventos()) {
            System.out.println("----------------------------------------------------");
            System.out.println("EXPORTANDO XML: ");
            System.out.println(evento.aXML());
            System.out.println("EXPORTANDO CSV: ");
            System.out.println(evento.aCSV());
        }

        for (Usuario usuario : SERVICIO_USUARIO.listarTodosLosUsuario()) {
            System.out.println("----------------------------------------------------");
            System.out.println("EXPORTANDO XML: ");
            System.out.println(usuario.aXML());
            System.out.println("EXPORTANDO CSV: ");
            System.out.println(usuario.aCSV());
        }

    }

    private static void cierreEspecificoEventos(){
        for (Evento evento : SERVICIO_EVENTO.listarTodosLosEventos()) {
            System.out.println("Cerrando Evento: " + evento.getNombre());
            evento.finalizarEvento();
            System.out.println("[OK] Evento finalizado con éxito.");
        }
    }
}