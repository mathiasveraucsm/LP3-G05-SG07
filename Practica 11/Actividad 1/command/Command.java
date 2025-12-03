package actividad1_command;

//CommandDemo.java
public class Command {
	
 public static void main(String[] args) {
	 
     Televisor tv = new Televisor();
     ControlRemoto control = new ControlRemoto();

     control.setComando(new Encender(tv));
     control.presionarBoton();

     control.setComando(new SubirVolumen(tv));
     control.presionarBoton();

     control.setComando(new CambiarCanal(tv));
     control.presionarBoton();

     control.setComando(new Apagar(tv));
     control.presionarBoton();
     
 }
 
}