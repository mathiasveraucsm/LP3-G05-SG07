package lp3prac2;

import java.util.ArrayList;

public class Curso {
	private String nombre;
	private int semestre;
	private String codigoCurso;
	private ArrayList<Estudiante> listaEstudiantes;
	private Profesor docente;
	
	public Curso(String n, int s, String c, ArrayList<Estudiante> l, Profesor d) {
		this.setNombre(n);
		this.setSemestre(s);
		this.setCodigoCurso(c);
		this.setListaEstudiantes(l);
		this.setDocente(d);
	}
	
	public void mostrarInformacion() {
		System.out.println("Nombre del Curso: " + this.nombre);
		System.out.println("Semestre del Curso: " + this.semestre);
		System.out.println("Codigo del Curso: " + this.codigoCurso);
		System.out.println("Docente del Curso: " + this.docente.getNombre() + "" + this.docente.getApellido());
		System.out.println("Lista de Estudiantes del Curso: ");
		for (Estudiante estudiante : this.listaEstudiantes) {
			System.out.println(estudiante.getNombre());
		}
	}
	
	public void agregarEstudiante(Estudiante e) {
	    if (this.listaEstudiantes == null) {
	        this.listaEstudiantes = new ArrayList<>();
	    }
	    this.listaEstudiantes.add(e);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public Profesor getDocente() {
		return docente;
	}

	public void setDocente(Profesor docente) {
		this.docente = docente;
	}

	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}
	
}
