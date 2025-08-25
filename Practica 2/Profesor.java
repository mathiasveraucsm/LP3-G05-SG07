package lp3prac2;

import java.util.ArrayList;

public class Profesor extends Persona {
	private int sueldo;
	private ArrayList<Curso> listaCursos;
	public Profesor(String n, String a, int e, int s, ArrayList<Curso> l) {
		super(n, a, e);
		this.edad = e;
		this.sueldo = s;
		this.listaCursos = l;
	}

	@Override
	public void mostrarInformacion() {
		System.out.println("Nombre del Profesor: " + this.nombre);
		System.out.println("Apellido del Profesor: " + this.apellido);
		System.out.println("Edad del Profesor: " + this.edad);
		System.out.println("Sueldo del Profesor: " + this.sueldo);
		System.out.println("Lista de Cursos del Profesor: ");
		for (Curso curso : this.listaCursos) {
			System.out.println(curso.getNombre());
		}
	}


	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int s) {
		this.sueldo = s;
	}

	public ArrayList<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(ArrayList<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

}
