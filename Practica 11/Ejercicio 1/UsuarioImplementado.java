package ejercicio1;


public class UsuarioImplementado implements Usuario {
	
	private String nombre;

	public UsuarioImplementado(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void recibirNotificacion(Notificacion notificacion) {
		System.out.println(nombre + " recibió: " + notificacion.getMensaje());
	}
	
}