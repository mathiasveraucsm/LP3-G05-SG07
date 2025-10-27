package ejercicio2;

public class Personaje {
    public int id;
    public String nombre;
    public int ataque;
    public int defensa;

    public Personaje(int id, String nombre, int ataque, int defensa) {
        this.id = id;
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public Object getCampo(String campo) {
        switch (campo.toLowerCase()) {
            case "id": return id;
            case "nombre": return nombre;
            case "ataque": return ataque;
            case "defensa": return defensa;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return id + " " + nombre + " " + ataque + " " + defensa;
    }
}