package actividad1_command;


public class Apagar implements Comando {
	
	private Televisor tv;
 
	public Apagar(Televisor tv) { 
		this.tv = tv; 
	}
 
	public void ejecutar() { 
		tv.apagar(); 
	}
 
}