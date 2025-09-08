package lp3prac3;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class main {
    public static void main(String[] args) {
    	
        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion();

        Habitacion h101 = new HabitacionIndividual(101);
        Habitacion h102 = new HabitacionDoble(102);
        Habitacion h201 = new Suite(201);
        HabitacionConServicio h301 = new HabitacionConServicio(301);

        System.out.println("Precio h101: $" + h101.calcularPrecio());
        System.out.println("Precio h102: $" + h102.calcularPrecio());
        System.out.println("Precio h201: $" + h201.calcularPrecio());
        System.out.println("Precio h301: $" + h301.calcularPrecio());

        LocalDate fechaInicio = LocalDate.of(2025, 9, 10);
        LocalDate fechaFin = LocalDate.of(2025, 9, 12);

        boolean disponible = gestor.verificarDisponibilidad(h201, fechaInicio, fechaFin);
        System.out.println("¿Suite 201 disponible del 10 al 12? " + disponible);

        if (disponible) {
            PoliticaCancelacion politica = new PoliticaCancelacionFlexible();
            Reserva reserva = new Reserva(h201, LocalDateTime.of(2025, 9, 10, 14, 0), politica);
            gestor.agregarReserva(reserva);
            System.out.println("Reserva creada para habitación " + h201.getNumero());

            boolean puedeCancelar = reserva.cancelar();
            System.out.println("¿Se puede cancelar la reserva? " + puedeCancelar);

            CanalNotificacion canal = new EnviadorCorreo();
            NotificadorReserva notificador = new NotificadorReserva(canal);
            notificador.notificar("Reserva confirmada para habitación " + h201.getNumero());
        }

        h301.limpiar();
        h301.entregarComida();

        boolean disponibleDespues = gestor.verificarDisponibilidad(h201, fechaInicio, fechaFin);
        System.out.println("¿Suite 201 disponible después de reservar? " + disponibleDespues);
    }
}