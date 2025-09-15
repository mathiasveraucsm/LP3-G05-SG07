package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    private List<Estudiante> estudiantes;

    public RegistroEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante == null || estudiante.getNombre() == null || estudiante.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede ser nulo o vacío.");
        }
        estudiantes.add(estudiante);
    }

    public Estudiante buscarEstudiante(String nombre) {
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        throw new NoSuchElementException("Estudiante con nombre '" + nombre + "' no encontrado.");
    }
}