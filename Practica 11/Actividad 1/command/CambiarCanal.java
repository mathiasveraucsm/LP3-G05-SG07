package actividad1_command;


public class CambiarCanal implements Comando {
	
	private Televisor tv;
	
	public CambiarCanal(Televisor tv) { 
		this.tv = tv; 
	}
	
	public void ejecutar() { 
		tv.cambiarCanal(); 
	}
	
}