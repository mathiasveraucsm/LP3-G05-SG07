package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void eliminarProducto(String nombre) {
        productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotal(double descuento, double envio) {
        double subtotal = productos.stream().mapToDouble(Producto::getPrecio).sum();
        return subtotal * (1 - descuento) + envio;
    }

    public boolean estaVacio() {
        return productos.isEmpty();
    }

    public void vaciar() {
        productos.clear();
    }
}