package ejercicio23;


import java.util.List;

public class InventarioVista {

    public void mostrarInventario(List<Item> items) {
        System.out.println("Inventario:");
        for (Item item : items) {
            System.out.println("- " + item);
        }
    }

    public void mostrarDetalleItem(Item item) {
        if (item != null) {
            System.out.println("Detalle del Item: " + item);
        } else {
            System.out.println("Item no encontrado.");
        }
    }

    public void mostrarEstadoCombate(Jugador jugador, Enemigo enemigo) {
        System.out.println(jugador.getNombre() + " [Salud: " + jugador.getSalud() + "] vs " +
                           enemigo.getNombre() + " [Salud: " + enemigo.getSalud() + "]");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}