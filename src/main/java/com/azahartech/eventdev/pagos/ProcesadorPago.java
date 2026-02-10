package com.azahartech.eventdev.pagos;

/**
 * Representa el procesador de pagos de la Aplicación
 * Esta interfaz define la lógica de cada uno de los tipos
 * específicos de pago (Tarjeta, PayPal, Bizum).
 */

public interface ProcesadorPago {
    /**
     * Ejecuta el procesamiento de un pago basado en una cantidad específica de entradas.
     *
     * @param cant La cantidad total de entradas a cobrar. Debe ser un valor double positivo.
     * @return {@code true} si la transacción fue autorizada y completada con éxito;
     * {@code false} en caso de fondos insuficientes o error aleatorio.
     *
     */
    boolean procesarPago(double cant);
}
