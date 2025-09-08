package lp3prac3;

public abstract class Habitacion {
    protected int numero;
    protected String tipo;

    public Habitacion(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public abstract double calcularPrecio();

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }
}

	
	

