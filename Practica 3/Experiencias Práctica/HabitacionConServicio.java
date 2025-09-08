package lp3prac3;

public class HabitacionConServicio extends Habitacion implements ServicioLimpieza, ServicioComida {
    public HabitacionConServicio(int numero) {
        super(numero, "Con Servicio");
    }

    @Override
    public double calcularPrecio() {
        return 150.0;
    }

    @Override
    public void limpiar() {
        System.out.println("Habitación limpiada.");
    }

    @Override
    public void entregarComida() {
        System.out.println("Comida entregada.");
    }
}