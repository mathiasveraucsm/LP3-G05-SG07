package ejercicio3;

import java.util.Scanner;

public class VistaEmpleado {
    private final GestorEmpleado gestor = new GestorEmpleado();
    private final Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Empleados ---");
            System.out.println("1. Listar empleados");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Modificar empleado");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> listar();
                case 2 -> agregar();
                case 3 -> eliminar();
                case 4 -> modificar();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void listar() {
        System.out.println("\n--- Lista de Empleados ---");
        for (Empleado e : gestor.listar()) {
            System.out.println(e);
        }
    }

    private void agregar() {
        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = sc.nextDouble();
        gestor.agregar(new Empleado(numero, nombre, sueldo));
    }

    private void eliminar() {
        System.out.print("Número del empleado a eliminar: ");
        int numero = sc.nextInt();
        gestor.eliminar(numero);
    }

    private void modificar() {
        System.out.print("Número del empleado a modificar: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo sueldo: ");
        double sueldo = sc.nextDouble();
        gestor.modificar(numero, nombre, sueldo);
    }
}
