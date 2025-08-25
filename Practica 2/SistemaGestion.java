package lp3prac2;

import java.util.ArrayList;

public class SistemaGestion {
	private Estudiante[] listaEstudiantes;
	private Profesor[] listaProfesores;
	private Curso[] listaCursos;
	private String nombre;
	
	public SistemaGestion(Estudiante[] e, Profesor[] p, Curso[] c, String n) {
		this.listaEstudiantes = e;
		this.listaProfesores = p;
		this.listaCursos = c;
		this.nombre = n;
	}
	
	public boolean buscarEstudianteEnCurso(Estudiante e, Curso c) {
		ArrayList<Estudiante> estudiantes = c.getListaEstudiantes();
	    for (int j = 0; j < estudiantes.size(); j++) {
	        if (e.getCodigoEstudiante().equals(estudiantes.get(j).getCodigoEstudiante())) {
	            return true; // 
	        }
	    }
	    return false;
	}

	
	
	public void inscribirEstudiante(Estudiante e, Curso c) {
        if (buscarEstudianteEnCurso(e, c)) {
            System.out.println("El estudiante " + e.getNombre() + " ya está matriculado en " + c.getNombre());
        } else {
            c.agregarEstudiante(e);
            System.out.println("Estudiante " + e.getNombre() + " matriculado en " + c.getNombre());
        }
    }
	
	public Estudiante[] getListaEstudiantes() {
		return listaEstudiantes;
	}
	
	public void setListaEstudiantes(Estudiante[] listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}
	
	public Curso[] getListaCursos() {
		return listaCursos;
	}
	
	public void setListaCursos(Curso[] listaCursos) {
		this.listaCursos = listaCursos;
	}
	
	public Profesor[] getListaProfesores() {
		return listaProfesores;
	}
	
	public void setListaProfesores(Profesor[] listaProfesores) {
		this.listaProfesores = listaProfesores;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
