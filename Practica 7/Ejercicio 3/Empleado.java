package ejercicio3;

public class Empleado {
    private int numero;
    private String nombre;
    private double sueldo;

    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getNumero() { return numero; }
    public String getNombre() { return nombre; }
    public double getSueldo() { return sueldo; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    @Override
    public String toString() {
        return String.format("Número: %d | Nombre: %s | Sueldo: %.2f", numero, nombre, sueldo);
    }

    public String toFileString() {
        return numero + "," + nombre + "," + sueldo;
    }

    public static Empleado fromFileString(String linea) {
        String[] partes = linea.split(",");
        return new Empleado(
            Integer.parseInt(partes[0]),
            partes[1],
            Double.parseDouble(partes[2])
        );
    }
}