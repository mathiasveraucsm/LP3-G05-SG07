package lp3prac3;

import java.time.LocalDateTime;

public class Reserva {
    private Habitacion habitacion;
    private LocalDateTime fechaCheckIn;
    private PoliticaCancelacion politica;

    public Reserva(Habitacion habitacion, LocalDateTime fechaCheckIn, PoliticaCancelacion politica) {
        this.habitacion = habitacion;
        this.fechaCheckIn = fechaCheckIn;
        this.politica = politica;
    }

    public boolean cancelar() {
        return politica.puedeCancelar(this);
    }

    public LocalDateTime getFechaCheckIn() {
        return fechaCheckIn;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }
}