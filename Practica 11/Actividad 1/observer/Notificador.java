package actividad1_observer;

//Notificador.java
import java.util.ArrayList;
import java.util.List;

public class Notificador {
	private List<Usuario> usuarios = new ArrayList<>();

	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public void eliminarUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}

	public void notificar(String mensaje) {
		for (Usuario u : usuarios) {
			u.actualizar(mensaje);
		}
	}
	
}