public class Ejercicio2
{
	public static void main(String[] args) {
	  int[] dados = {0, 0, 0, 0, 0, 0};
		for (int i = 0; i < 20000; i++) {
		    int tirada = (int)(Math.random() * 6) + 1;
		    dados[tirada - 1] = dados[tirada - 1] + 1;
		}
		System.out.println("Los resultados de las 20000 tiradas de dados son:");
		for (int j = 0; j < 6; j++) {
		    System.out.println("Cantidad de veces que salió el número " + (j+1) + ": " + dados[j]);
		}
	}
}
