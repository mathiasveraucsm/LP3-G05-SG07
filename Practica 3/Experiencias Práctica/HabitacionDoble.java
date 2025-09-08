package lp3prac3;

public class HabitacionDoble extends Habitacion {
    public HabitacionDoble(int numero) {
        super(numero, "Doble");
    }

    @Override
    public double calcularPrecio() {
        return 120.0;
    }
}
