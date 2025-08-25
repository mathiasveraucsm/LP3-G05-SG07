package lp3prac2;

public abstract class Persona {
	public String nombre;
	public String apellido;
	public int edad;
	
	public Persona(String n, String a, int e) {
		this.nombre = n;
		this.apellido = a;
		this.edad = e;
	}
	
	abstract public void mostrarInformacion();
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	public void setApellido(String a) {
		this.apellido = a;
	}
	
	public void setEdad(int e) {
		this.edad = e;
	}
}
