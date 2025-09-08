package lp3prac3;

public class HabitacionIndividual extends Habitacion {
    public HabitacionIndividual(int numero) {
        super(numero, "Individual");
    }

    @Override
    public double calcularPrecio() {
        return 80.0;
    }
}
