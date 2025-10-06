package ejercicio1;

import java.util.List;
import java.util.Scanner;

public class Vista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar producto al catálogo");
        System.out.println("2. Listar productos");
        System.out.println("3. Agregar producto al carrito");
        System.out.println("4. Ver carrito");
        System.out.println("5. Eliminar producto del carrito");
        System.out.println("6. Aplicar descuento");
        System.out.println("7. Calcular envío");
        System.out.println("8. Realizar compra");
        System.out.println("9. Ver historial de compras");
        System.out.println("10. Salir");
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }

    public void mostrarProductos(List<Producto> productos, String titulo) {
        System.out.println("\n" + titulo);
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            productos.forEach(p -> System.out.println("- " + p));
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarTotal(double total) {
        System.out.printf("Total a pagar: S/ %.2f\n", total);
    }

    public void cerrar() {
        scanner.close();
    }
}