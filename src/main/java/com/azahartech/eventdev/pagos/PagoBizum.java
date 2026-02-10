package com.azahartech.eventdev.pagos;

public class PagoBizum implements ProcesadorPago {
    String telefono;
    int pin;

    public PagoBizum(String telefono, int pin) {
        this.telefono = telefono;
        this.pin = pin;
    }

    @Override
    public boolean procesarPago(double cantidad) {
        System.out.println("Procesando pago de " + cantidad + " con teléfono " + telefono);

        if (Math.random() < 0.1) {
            System.out.println("Error técnico: La conexión con Bizum ha fallado.");
            return false;
        }

        if (telefono.matches("\\d{9}")) {
            return true;
        } else {
            System.out.println("Error: Número de teléfono inválido.");
            return false;
        }
    }
}