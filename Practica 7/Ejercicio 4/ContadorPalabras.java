package ejercicio4;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ContadorPalabras {
    private File archivo;

    public ContadorPalabras(File archivo) {
        this.archivo = archivo;
    }

    public void analizar() throws IOException {
        int totalLineas = 0;
        int totalPalabras = 0;
        int totalCaracteres = 0;
        Map<String, Integer> frecuencia = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totalLineas++;
                totalCaracteres += contarCaracteres(linea);
                List<String> palabras = extraerPalabras(linea);
                totalPalabras += palabras.size();

                for (String palabra : palabras) {
                    palabra = palabra.toLowerCase();
                    frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                }
            }
        }

        mostrarResultados(totalLineas, totalPalabras, totalCaracteres, frecuencia);
    }

    private int contarCaracteres(String linea) {
        return (int) linea.chars().filter(c -> c != '\n' && c != '\r').count();
    }

    private List<String> extraerPalabras(String linea) {
        List<String> palabras = new ArrayList<>();
        StringBuilder palabra = new StringBuilder();

        for (char c : linea.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                palabra.append(c);
            } else {
                if (palabra.length() > 0) {
                    palabras.add(palabra.toString());
                    palabra.setLength(0);
                }
            }
        }

        if (palabra.length() > 0) {
            palabras.add(palabra.toString());
        }

        return palabras;
    }

    private void mostrarResultados(int lineas, int palabras, int caracteres, Map<String, Integer> frecuencia) {
        System.out.println("\n📊 Resultados:");
        System.out.println("Total de líneas: " + lineas);
        System.out.println("Total de palabras: " + palabras);
        System.out.println("Total de caracteres (sin saltos de línea): " + caracteres);

        System.out.println("\n🔁 Palabras más frecuentes:");
        frecuencia.entrySet().stream()
            .filter(e -> e.getValue() > 1)
            .sorted((a, b) -> b.getValue() - a.getValue())
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
