package ejercicio;

public class PruebaContenedor {
    public static void main(String[] args) {
        Contenedor<String, Integer> contenedor = new Contenedor<>();
        contenedor.agregarPar("Melgar", 1915);
        contenedor.agregarPar("Arequipa", 2025);

        contenedor.mostrarPares();

        Par<String, Integer> par = contenedor.obtenerPar(1);
        System.out.println("Segundo par: " + par);
    }
}