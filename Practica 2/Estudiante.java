package lp3prac2;

import java.util.ArrayList;

public class Estudiante extends Persona {
    private String codigoEstudiante;
    private ArrayList<Curso> listaCursos;
    private static int contadorEstudiantes = 1000; 
    
    public Estudiante(String n, String a, int e, ArrayList<Curso> l) {
        super(n, a, e);
        this.setCodigoEstudiante(generarCodigoEstudiante());
        this.setListaCursos(l);
    }

    private String generarCodigoEstudiante() {
        contadorEstudiantes++;
        return String.valueOf(contadorEstudiantes);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre del Estudiante: " + this.nombre);
        System.out.println("Apellido del Estudiante: " + this.apellido);
        System.out.println("Edad del Estudiante: " + this.edad);
        System.out.println("Codigo del Estudiante: " + this.codigoEstudiante);
        System.out.println("Lista de Cursos del Estudiante: ");
        for (Curso curso : this.listaCursos) {
            System.out.println(curso.getNombre());
        }
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String c) {
        this.codigoEstudiante = c;
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }


    public static String obtenerSiguienteCodigo() {
        return String.valueOf(contadorEstudiantes + 1);
    }
}
