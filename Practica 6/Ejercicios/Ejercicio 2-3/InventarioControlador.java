package ejercicio23;


public class InventarioControlador {
    private InventarioModelo modelo;
    private InventarioVista vista;
    private Jugador jugador;

    public InventarioControlador(InventarioModelo modelo, InventarioVista vista, Jugador jugador) {
        this.modelo = modelo;
        this.vista = vista;
        this.jugador = jugador;
    }

    public void mostrarInventario() {
        vista.mostrarInventario(modelo.obtenerInventario());
    }

    public void mostrarDetalleItem(String nombre) {
        Item item = modelo.obtenerItem(nombre);
        vista.mostrarDetalleItem(item);
    }

    public void iniciarCombate(Enemigo enemigo) {
        vista.mostrarMensaje("¡Comienza el combate!");
        int turno = 1;

        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            vista.mostrarMensaje("\nTurno " + turno);

            int danioJugador = jugador.atacar();
            enemigo.recibirDanio(danioJugador);
            vista.mostrarMensaje(jugador.getNombre() + " ataca y causa " + danioJugador + " de daño.");

            if (enemigo.getSalud() > 0) {
                int danioEnemigo = enemigo.atacar();
                jugador.recibirDanio(danioEnemigo);
                vista.mostrarMensaje(enemigo.getNombre() + " contraataca y causa " + danioEnemigo + " de daño.");
            }

            vista.mostrarEstadoCombate(jugador, enemigo);
            turno++;
        }

        if (jugador.getSalud() > 0) {
            vista.mostrarMensaje("\n¡Victoria del jugador!");
        } else {
            vista.mostrarMensaje("\nEl jugador ha sido derrotado.");
        }
    }

    public void equiparItem(String nombre) {
        Item item = modelo.obtenerItem(nombre);
        if (item != null) {
            jugador.equipar(item);
            vista.mostrarMensaje("Item equipado: " + item.getNombre());
        } else {
            vista.mostrarMensaje("Item no encontrado.");
        }
    }
}