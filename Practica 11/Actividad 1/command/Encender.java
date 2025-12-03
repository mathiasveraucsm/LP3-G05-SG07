package actividad1_command;


public class Encender implements Comando {
	
	private Televisor tv;
 
	public Encender(Televisor tv) { 
		this.tv = tv; 
	}
 
	public void ejecutar() { 
		tv.encender(); 
	}
 
}
