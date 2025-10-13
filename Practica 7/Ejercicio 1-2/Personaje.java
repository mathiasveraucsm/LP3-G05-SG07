package ejercicio12;

public class Personaje {
    private String tipo;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    private boolean disponible;

    public Personaje(String tipo, int vida, int ataque, int defensa, int alcance) {
        this.tipo = tipo;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
        this.disponible = true;
    }

    public Personaje(String tipo, int vida, int ataque, int defensa, int alcance, boolean disponible) {
        this(tipo, vida, ataque, defensa, alcance);
        this.disponible = disponible;
    }

    public static Personaje fromString(String linea) {
        String[] partes = linea.split(",");
        return new Personaje(
            partes[0],
            Integer.parseInt(partes[1]),
            Integer.parseInt(partes[2]),
            Integer.parseInt(partes[3]),
            Integer.parseInt(partes[4]),
            Boolean.parseBoolean(partes[5])
        );
    }
    
    public String getTipo() { return tipo; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAlcance() { return alcance; }
    public boolean isDisponible() { return disponible; }

    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public void setAlcance(int alcance) { this.alcance = alcance; }

    public void borrar() {
        this.disponible = false;
    }

    @Override
    public String toString() {
        return String.format("Tipo: %s | Vida: %d | Ataque: %d | Defensa: %d | Alcance: %d | Disponible: %s",
                tipo, vida, ataque, defensa, alcance, disponible ? "Sí" : "No");
    }


    public String toFileString() {
        return String.format("%s,%d,%d,%d,%d,%b", tipo, vida, ataque, defensa, alcance, disponible);
    }

}
