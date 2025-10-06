package ejercicio23;


public class main {
    public static void main(String[] args) {
        InventarioModelo modelo = new InventarioModelo();
        InventarioVista vista = new InventarioVista();
        Jugador jugador = new Jugador("Marth", 100, 3);

        modelo.agregarItem(new Item("Estoque", 1, "Arma", "Ataque"));
        modelo.agregarItem(new Item("Poción de salud", 2, "Pocion", "Salud"));

        InventarioControlador controlador = new InventarioControlador(modelo, vista, jugador);

        controlador.mostrarInventario();
        controlador.equiparItem("Estoque");

        Enemigo enemigo = new Enemigo("Dragon", 50, 2, "Wyvern");
        controlador.iniciarCombate(enemigo);
    }
}