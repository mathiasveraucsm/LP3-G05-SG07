package actividad1_command;


public class SubirVolumen implements Comando {
	
	private Televisor tv;
	
	public SubirVolumen(Televisor tv) { 
		this.tv = tv; 
	}
	
	public void ejecutar() { 
		tv.subirVolumen(); 
	}
	
}