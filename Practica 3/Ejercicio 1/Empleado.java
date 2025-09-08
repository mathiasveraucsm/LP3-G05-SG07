package ejercicio1;

public class Empleado {
	private String nombre;
	private double salario;
	private String departamento;
	
	public Empleado(String n, double s, String d) {
		this.nombre = n;
		this.salario = s;
		this.departamento = d;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
