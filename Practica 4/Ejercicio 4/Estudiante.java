package ejercicio4;

public class Estudiante {

	private String nombre;
	private int codigo;
	
	public Estudiante(String n, int c) {
		this.nombre = n;
		this.codigo = c;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
