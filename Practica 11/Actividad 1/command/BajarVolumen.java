package actividad1_command;


public class BajarVolumen implements Comando {
	
	private Televisor tv;
	
	public BajarVolumen(Televisor tv) { 
		this.tv = tv;
	}
	
	public void ejecutar() {	
		tv.bajarVolumen(); 
	}
	
}