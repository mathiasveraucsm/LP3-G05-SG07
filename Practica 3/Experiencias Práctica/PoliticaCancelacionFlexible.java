package lp3prac3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return ChronoUnit.HOURS.between(LocalDateTime.now(), reserva.getFechaCheckIn()) >= 24;
    }
}