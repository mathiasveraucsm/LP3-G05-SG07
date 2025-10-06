package actividad1;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;
    
    public PedidoVista() {
        scanner = new Scanner(System.in);
    }
    
    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }
    
    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo de plato: ");
        return scanner.nextLine();
    }
    
    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println((i + 1) + ". " + pedidos.get(i));
            }
        }
    }
    
    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE PEDIDOS AVANZADO ===");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos Activos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido por Nombre");
        System.out.println("6. Buscar Pedido por Tipo");
        System.out.println("7. Contar Pedidos");
        System.out.println("8. Marcar Pedido como Completo");
        System.out.println("9. Mostrar Pedidos Pendientes");
        System.out.println("10. Mostrar Historial de Pedidos");
        System.out.println("11. Mostrar Contador de Pendientes");
        System.out.println("12. Salir");
    }
    
    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public String solicitarNombreParaBuscar() {
        System.out.print("Introduce el nombre a buscar: ");
        return scanner.nextLine();
    }
    
    public String solicitarTipoParaBuscar() {
        System.out.print("Introduce el tipo a buscar: ");
        return scanner.nextLine();
    }
    
    public String solicitarNombreParaEliminar() {
        System.out.print("Introduce el nombre del pedido a eliminar: ");
        return scanner.nextLine();
    }
    
    public String solicitarNombreParaCompletar() {
        System.out.print("Introduce el nombre del pedido a marcar como completo: ");
        return scanner.nextLine();
    }
    
    public int solicitarNumeroPedido() {
        System.out.print("Introduce el número del pedido: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public void cerrarScanner() {
        scanner.close();
    }
}

