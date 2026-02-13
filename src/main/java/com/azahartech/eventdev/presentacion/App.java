package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.servicio.ServicioUsuario;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static ServicioUsuario SERVICIO_USUARIO = new ServicioUsuario();
    //private final static ServicioEvento SERVICIO_EVENTO = new ServicioEvento();

    private static boolean continuidad = true;

    public static void main(String[] args) {
        System.out.println("""
                           =====================================================
                                EVENTDEV V1.0 - SISTEMA DE GESTIÓN INTEGRAL     
                           =====================================================
                           """);

        System.out.println("[FASE 1: REGISTRO DE USUARIOS]");
        //registrarUsuarios();

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

            System.out.print("Introduce el email:");
            email = SCANNER.nextLine();

            System.out.print("Introduce el telefono:");
            telefono = SCANNER.nextLine();

            System.out.print("Eres Vip (Si/No defecto:No):");
            esVip = SCANNER.nextLine().equalsIgnoreCase("si");

            usuario = new Usuario(nombre, email, telefono, esVip);

            SERVICIO_USUARIO.registrarUsuario(usuario);

            System.out.println("Quieres añadir a otro usuario? (Si/No)");
            otroUsuario = SCANNER.nextLine().equalsIgnoreCase("si");

        } while (otroUsuario);

    }

    private static void registrarEventos(){
        Evento evento;
        Recinto recinto;

        String nombre, nombreRecinto, direccionRecinto;
        double precio;
        LocalDate fecha;
        TipoEvento tipo;
        int aforoMaximo = 0;

        int opcion;

        System.out.print("Introduce el nombre del evento:");
        nombre = SCANNER.nextLine();

        do {
            continuidad = true;
            try{
                System.out.print("Introduce el fecha del evento (YYYY-MM-DD):");
                fecha = LocalDate.parse(SCANNER.nextLine());
            }catch (RuntimeException e){
                System.out.println("Formato invalido.");
                continuidad = false;
            }
        }while (!continuidad);

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

                if (aforoMaximo <= 0){
                    continuidad = false;
                    System.out.println("Error: El aforo maximo tiene que ser mayor o igual a 0.");
                }
            } catch (RuntimeException e) {
                System.out.println("Error: El valor introducido tiene que ser digitos.");
                continuidad = false;
            }
        }while (!continuidad);

        recinto = new Recinto(nombreRecinto, direccionRecinto, aforoMaximo);

        do {
            continuidad = true;
            try {
                System.out.print("Introduce el precio del evento:");
                precio = SCANNER.nextInt();
                SCANNER.nextLine();

                if (precio <= 0){
                    System.out.println("Error: El valor introducido tiene que ser digitos.");
                    continuidad = false;
                }
            } catch (RuntimeException e) {
                System.out.println("Error: El valor introducido tiene que ser digitos.");
                continuidad = false;
            }
        }while (!continuidad);

        do {
            opcion = -1;
            System.out.println("Dime el tipo de evento que es: ");
            System.out.println("""
                    1. CONCIERTO
                    2. TEATRO
                    3. DEPORTE
                    4. FESTIVAL
                    """);
            System.out.print("Dime una opcion:");
            if (opcion < 1 && opcion > 4){
                System.out.println("Error: La opcion es invalida");
            }
        } while (opcion < 1 && opcion > 4);



    }

    private static void controlEstados(){

    }

    private static void pasarelaPagos(){

    }

    private static void consultasYStreams(){

    }

    private static void exportacionPolimorfica(){

    }

    private static void cierreEspecificoEventos(){

    }
}