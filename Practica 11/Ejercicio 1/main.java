package ejercicio1;


public class main {
	
	public static void main(String[] args) {
		
		Notificador notificador = new Notificador();

		Usuario u1 = new UsuarioImplementado("Mathias");
		Usuario u2 = new UsuarioImplementado("Ana");
		Usuario u3 = new UsuarioImplementado("Carlos");

		notificador.suscribir(u1);
		notificador.suscribir(u2);
		notificador.suscribir(u3);

		notificador.enviarNotificacion(new Notificacion("Promoción: 20% de descuento en laptops 💻"));

		notificador.desuscribir(u2);

		notificador.enviarNotificacion(new Notificacion("Nueva actualización de producto 📦"));
		
	}
	
}
