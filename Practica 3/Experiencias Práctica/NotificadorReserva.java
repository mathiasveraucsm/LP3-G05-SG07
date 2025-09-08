package lp3prac3;

public class NotificadorReserva {
    private CanalNotificacion canal;

    public NotificadorReserva(CanalNotificacion canal) {
        this.canal = canal;
    }

    public void notificar(String mensaje) {
        canal.enviarNotificacion(mensaje);
    }
}
