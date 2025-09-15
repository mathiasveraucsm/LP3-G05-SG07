package experienciaPractica;

import java.util.*;

public class main {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("001", "John ", 500.0);
        CuentaCredito cuenta2 = new CuentaCredito("002", "Jane", 200.0, 300.0);

        List<String> transacciones = new ArrayList<>();

        try {
            cuenta1.depositar(150.0);
            transacciones.add("CuentaBancaria,Deposito,150.0");

            cuenta1.retirar(100.0);
            transacciones.add("CuentaBancaria,Retiro,100.0");

            cuenta1.transferir(cuenta2, 200.0);
            transacciones.add("CuentaBancaria,Transferencia a CuentaCredito,200.0");

            cuenta2.retirar(400.0); 
            transacciones.add("CuentaCredito,Retiro,400.0");

            cuenta2.retirar(200.0); 
            transacciones.add("CuentaCredito,Retiro,200.0");
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Excepción: " + e.getMessage());
        }

        System.out.println("\n📊 Saldos finales:");
        System.out.println(cuenta1.getTitular() + ": $" + cuenta1.consultarSaldo());
        System.out.println(cuenta2.getTitular() + ": $" + cuenta2.consultarSaldo());

        System.out.println("\n🧾 Reporte de transacciones:");
        ReporteTransacciones reporte = new ReporteTransacciones();
        try {
            reporte.generarReportePorTipoCuenta(transacciones);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Error al generar reporte: " + e.getMessage());
        }
    }
}