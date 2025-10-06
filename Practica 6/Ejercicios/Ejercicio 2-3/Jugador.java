package ejercicio23;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private Item equipado;

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
    }

    public void equipar(Item item) {
        this.equipado = item;
    }

    public int atacar() {
        if (equipado != null && equipado.getEfecto().equalsIgnoreCase("Ataque")) {
            return 10 * nivel;
        }
        return 5 * nivel;
    }

    public void recibirDanio(int danio) {
        salud -= danio;
    }

    public int getSalud() { return salud; }
    public String getNombre() { return nombre; }
}