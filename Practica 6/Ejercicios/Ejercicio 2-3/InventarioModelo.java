package ejercicio23;

import java.util.ArrayList;
import java.util.List;

public class InventarioModelo {
    private List<Item> inventario;

    public InventarioModelo() {
        inventario = new ArrayList<>();
    }

    public void agregarItem(Item item) {
        inventario.add(item);
    }

    public List<Item> obtenerInventario() {
        return inventario;
    }

    public Item obtenerItem(String nombre) {
        return inventario.stream()
            .filter(i -> i.getNombre().equalsIgnoreCase(nombre))
            .findFirst()
            .orElse(null);
    }
}