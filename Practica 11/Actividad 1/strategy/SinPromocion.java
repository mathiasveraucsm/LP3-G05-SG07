package actividad1_strategy;


public class SinPromocion implements Promocion {
	
	@Override
	public double aplicarDescuento(double precio) {
		return precio;
	}
	
}