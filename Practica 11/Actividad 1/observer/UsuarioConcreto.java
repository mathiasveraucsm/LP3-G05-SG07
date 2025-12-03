package actividad1_observer;

public class UsuarioConcreto implements Usuario {
	private String nombre;

	public UsuarioConcreto(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void actualizar(String mensaje) {
		System.out.println(nombre + " recibió notificación: " + mensaje);
	}
	
}