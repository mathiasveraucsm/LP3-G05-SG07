package lp3prac3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorDisponibilidadHabitacion {
    private List<Reserva> reservas;

    public GestorDisponibilidadHabitacion() {
        this.reservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public boolean verificarDisponibilidad(Habitacion habitacion, LocalDate inicio, LocalDate fin) {
        for (Reserva r : reservas) {
            if (r.getHabitacion().getNumero() == habitacion.getNumero()) {
                LocalDate inicioReserva = r.getFechaCheckIn().toLocalDate();
                LocalDate finReserva = inicioReserva.plusDays(1); // Suponiendo 1 noche por defecto

                boolean seSolapan = !(fin.isBefore(inicioReserva) || inicio.isAfter(finReserva));
                if (seSolapan) {
                    return false;
                }
            }
        }
        return true;
    }
}