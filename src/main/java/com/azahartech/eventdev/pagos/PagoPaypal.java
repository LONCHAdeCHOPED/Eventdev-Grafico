package com.azahartech.eventdev.pagos;

public class PagoPaypal implements ProcesadorPago {
    String emailUsuario;

    public PagoPaypal(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public boolean procesarPago(double cantidad) {
        System.out.println("Redirigiendo a PayPal para el usuario " + emailUsuario);
        System.out.println("Cobro de " + cantidad + " realizado");
        return true;
    }
}
