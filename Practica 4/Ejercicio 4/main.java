package ejercicio4;

import java.util.NoSuchElementException;


public class main {
	public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();

        try {
            registro.agregarEstudiante(new Estudiante("Ana", 2024123456));
            registro.agregarEstudiante(new Estudiante("Julio", 2023249411));
            registro.agregarEstudiante(new Estudiante("", 1111111111)); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar estudiante: " + e.getMessage());
        }

        try {
            Estudiante encontrado = registro.buscarEstudiante("Ana");
            System.out.println("Estudiante encontrado: " + encontrado.getNombre() + ", Código: " + encontrado.getCodigo());
            Estudiante encontrado1 = registro.buscarEstudiante("Julio");
            System.out.println("Estudiante encontrado: " + encontrado1.getNombre() + ", Código: " + encontrado1.getCodigo());


            registro.buscarEstudiante("Luis"); 
        } catch (NoSuchElementException e) {
            System.out.println("Error al buscar estudiante: " + e.getMessage());
        }
    }

}
