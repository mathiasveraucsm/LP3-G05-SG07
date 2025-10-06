package ejercicio23;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public int atacar() {
        return 4 * nivel;
    }

    public void recibirDanio(int danio) {
        salud -= danio;
    }

    public int getSalud() { return salud; }
    public String getNombre() { return nombre; }
}