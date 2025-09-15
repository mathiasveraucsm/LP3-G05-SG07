package experienciaPractica;

import java.io.*;
import java.util.*;

public class LectorArchivo {

    public List<String> leerTransacciones(String rutaArchivo) {
        List<String> transacciones = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(rutaArchivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (!linea.contains(",")) throw new FormatoIncorrectoException("Formato incorrecto en línea: " + linea);
                transacciones.add(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Archivo no encontrado: " + rutaArchivo);
        }

        return transacciones;
    }
}