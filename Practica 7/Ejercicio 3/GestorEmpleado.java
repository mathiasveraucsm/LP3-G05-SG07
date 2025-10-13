package ejercicio3;

import java.io.*;
import java.util.*;

public class GestorEmpleado {
    private final String archivo = "src/ejercicio3/empleados.txt";

    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(Empleado.fromFileString(linea));
            }
        } catch (IOException e) {
            System.out.println("Error al leer empleados: " + e.getMessage());
        }
        return lista;
    }

    public void agregar(Empleado e) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(e.toFileString());
            System.out.println("Empleado agregado correctamente.");
        } catch (IOException ex) {
            System.out.println("Error al agregar empleado: " + ex.getMessage());
        }
    }

    public void eliminar(int numero) {
        List<Empleado> lista = listar();
        boolean eliminado = false;

        try (PrintWriter pw = new PrintWriter(new FileWriter("temp.txt"))) {
            for (Empleado e : lista) {
                if (e.getNumero() != numero) {
                    pw.println(e.toFileString());
                } else {
                    eliminado = true;
                }
            }
        } catch (IOException ex) {
            System.out.println("Error al eliminar empleado: " + ex.getMessage());
            return;
        }

        new File(archivo).delete();
        new File("temp.txt").renameTo(new File(archivo));

        System.out.println(eliminado ? "Empleado eliminado." : "Empleado no encontrado.");
    }

    public void modificar(int numero, String nuevoNombre, double nuevoSueldo) {
        List<Empleado> lista = listar();
        boolean modificado = false;

        try (PrintWriter pw = new PrintWriter(new FileWriter("temp.txt"))) {
            for (Empleado e : lista) {
                if (e.getNumero() == numero) {
                    e.setNombre(nuevoNombre);
                    e.setSueldo(nuevoSueldo);
                    modificado = true;
                }
                pw.println(e.toFileString());
            }
        } catch (IOException ex) {
            System.out.println("Error al modificar empleado: " + ex.getMessage());
            return;
        }

        new File(archivo).delete();
        new File("temp.txt").renameTo(new File(archivo));

        System.out.println(modificado ? "Empleado modificado." : "Empleado no encontrado.");
    }
}
