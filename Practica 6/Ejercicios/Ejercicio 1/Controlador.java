package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private List<Producto> catalogo = new ArrayList<>();
    private Carrito carrito = new Carrito();
    private Historial historial = new Historial();
    private Vista vista = new Vista();
    private double descuento = 0.0;
    private double envio = 0.0;

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerTexto("Opción: ");
            switch (opcion) {
                case "1":
                    String nombre = vista.leerTexto("Nombre del producto: ");
                    double precio = vista.leerDouble("Precio: ");
                    catalogo.add(new Producto(nombre, precio));
                    vista.mostrarMensaje("Producto agregado al catálogo.");
                    break;
                case "2":
                    vista.mostrarProductos(catalogo, "Catálogo de productos");
                    break;
                case "3":
                    String nombreAgregar = vista.leerTexto("Nombre del producto a agregar: ");
                    catalogo.stream()
                        .filter(p -> p.getNombre().equalsIgnoreCase(nombreAgregar))
                        .findFirst()
                        .ifPresentOrElse(
                            carrito::agregarProducto,
                            () -> vista.mostrarMensaje("Producto no encontrado.")
                        );
                    break;
                case "4":
                    vista.mostrarProductos(carrito.getProductos(), "Productos en el carrito");
                    break;
                case "5":
                    String nombreEliminar = vista.leerTexto("Nombre del producto a eliminar: ");
                    carrito.eliminarProducto(nombreEliminar);
                    vista.mostrarMensaje("Producto eliminado del carrito.");
                    break;
                case "6":
                    descuento = vista.leerDouble("Descuento (ej. 0.10 para 10%): ");
                    vista.mostrarMensaje("Descuento aplicado.");
                    break;
                case "7":
                    envio = vista.leerDouble("Costo de envío: ");
                    vista.mostrarMensaje("Costo de envío registrado.");
                    break;
                case "8":
                    if (carrito.estaVacio()) {
                        vista.mostrarMensaje("El carrito está vacío.");
                    } else {
                        double total = carrito.calcularTotal(descuento, envio);
                        vista.mostrarTotal(total);
                        historial.registrarCompra(carrito.getProductos());
                        carrito.vaciar();
                        vista.mostrarMensaje("Compra realizada.");
                    }
                    break;
                case "9":
                    List<List<Producto>> compras = historial.getCompras();
                    if (compras.isEmpty()) {
                        vista.mostrarMensaje("No hay historial de compras.");
                    } else {
                        for (int i = 0; i < compras.size(); i++) {
                            vista.mostrarProductos(compras.get(i), "Compra #" + (i + 1));
                        }
                    }
                    break;
                case "10":
                    vista.mostrarMensaje("Saliendo...");
                    vista.cerrar();
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (!opcion.equals("10"));
    }
}