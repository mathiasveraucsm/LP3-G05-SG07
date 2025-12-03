package actividad1_observer;

//ObserverDemo.java
public class Observer {
	public static void main(String[] args) {
		Notificador notificador = new Notificador();

		Usuario u1 = new UsuarioConcreto("Juan");
		Usuario u2 = new UsuarioConcreto("Carlos");

		notificador.agregarUsuario(u1);
		notificador.agregarUsuario(u2);

		notificador.notificar("Nuevo producto disponible 🎉");
	}
}
