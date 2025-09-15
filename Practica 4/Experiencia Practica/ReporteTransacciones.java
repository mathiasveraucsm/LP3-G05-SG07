package experienciaPractica;

import java.io.*;
import java.util.*;

public class ReporteTransacciones {

    public void generarReportePorTipoCuenta(List<String> transacciones) {
        if (transacciones == null || transacciones.isEmpty()) {
            throw new HistorialVacioException("No hay transacciones en el historial.");
        }

        Map<String, List<String>> agrupadas = new HashMap<>();

        for (String t : transacciones) {
            String tipo = t.contains("Credito") ? "CuentaCredito" : "CuentaBancaria";
            agrupadas.computeIfAbsent(tipo, k -> new ArrayList<>()).add(t);
        }

        for (Map.Entry<String, List<String>> entry : agrupadas.entrySet()) {
            System.out.println("Tipo: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
