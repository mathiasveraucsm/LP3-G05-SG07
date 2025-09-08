package lp3prac3;

public class EnviadorCorreo implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Correo enviado: " + mensaje);
    }
}
