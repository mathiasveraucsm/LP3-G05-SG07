package lp3prac3;

public class Suite extends Habitacion {
    public Suite(int numero) {
        super(numero, "Suite");
    }

    @Override
    public double calcularPrecio() {
        return 200.0;
    }
}
