package ejercicio23;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo;   
    private String efecto; 
    
    public Item(String nombre, int cantidad, String tipo, String efecto) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.efecto = efecto;
    }

    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public String getTipo() { return tipo; }
    public String getEfecto() { return efecto; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ", " + efecto + ") x" + cantidad;
    }
}