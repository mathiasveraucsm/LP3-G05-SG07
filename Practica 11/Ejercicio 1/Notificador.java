package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Notificador {
	
	private List<Usuario> usuarios = new ArrayList<>();

	public void suscribir(Usuario usuario) {
		usuarios.add(usuario);
	}

	public void desuscribir(Usuario usuario) {
		usuarios.remove(usuario);
	}

	public void enviarNotificacion(Notificacion notificacion) {
		for (Usuario u : usuarios) {
			u.recibirNotificacion(notificacion);
		}
	}
	
}