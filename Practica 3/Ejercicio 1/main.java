package ejercicio1;

public class main {
	public static void main(String[] args) {
	Empleado e1 = new Empleado("Juan", 20.5, "Departamento de Finanzas");
	Empleado e2 = new Empleado("John", 14.7, "Departamento de Contabilidad");
	Empleado e3 = new Empleado("Owain", 40.3, "Departamento de Redes");
	GestorPagoMensual g1 = new GestorPagoMensual();
	System.out.println("El sueldo mensual del empleado/a " + e1.getNombre() + " es igual a: " + g1.calcularPagoMensual(e1) );
	System.out.println("El sueldo mensual del empleado/a " + e2.getNombre() + " es igual a: " + g1.calcularPagoMensual(e2) );
	System.out.println("El sueldo mensual del empleado/a " + e3.getNombre() + " es igual a: " + g1.calcularPagoMensual(e3) );
	}
}
