package ejercicio12;

import java.io.*;
import java.util.*;

public class Gestor {
    private List<Personaje> personajes;
    private final String archivo = "src/ejercicio12/personajes.txt";

    public Gestor() {
        personajes = new ArrayList<>();
        cargarDesdeArchivo();
    }

    public void añadirPersonaje(Personaje p) {
        personajes.add(p);
        guardarEnArchivo();
    }

    public void borrarPersonaje(String tipo) {
        for (Personaje p : personajes) {
            if (p.getTipo().equalsIgnoreCase(tipo)) {
                p.borrar();
                break;
            }
        }
        guardarEnArchivo();
    }

    public void modificarPersonaje(String tipo, int vida, int ataque, int defensa, int alcance) {
        for (Personaje p : personajes) {
            if (p.getTipo().equalsIgnoreCase(tipo) && p.isDisponible()) {
                p.setVida(vida);
                p.setAtaque(ataque);
                p.setDefensa(defensa);
                p.setAlcance(alcance);
                break;
            }
        }
        guardarEnArchivo();
    }

    public void mostrarPersonajes() {
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }

    public Personaje buscarPersonaje(String tipo) {
        for (Personaje p : personajes) {
            if (p.getTipo().equalsIgnoreCase(tipo)) {
                return p;
            }
        }
        return null;
    }

    private void guardarEnArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes) {
                pw.println(p.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    private void cargarDesdeArchivo() {
        File f = new File(archivo);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                personajes.add(Personaje.fromString(linea));
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }
}
