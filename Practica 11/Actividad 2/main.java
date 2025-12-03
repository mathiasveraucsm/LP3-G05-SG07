package actividad2;

import actividad1_command.*;
import actividad1_observer.*;
import actividad1_strategy.*;

public class main {
	
    public static void main(String[] args) {
    	
        Notificador notificador = new Notificador();
        Usuario u1 = new UsuarioConcreto("Mathias");
        notificador.agregarUsuario(u1);

        Producto producto = new Producto("Smart TV", 1500);
        producto.setPromocion(new PromocionPorcentaje(15));

        Televisor tv = new Televisor();
        ControlRemoto control = new ControlRemoto();

        notificador.notificar("Nueva promoción en Smart TV 📺");
        producto.mostrarPrecioFinal();

        control.setComando(new Encender(tv));
        control.presionarBoton();

        control.setComando(new CambiarCanal(tv));
        control.presionarBoton();

        control.setComando(new Apagar(tv));
        control.presionarBoton();
        
    }
    
}
