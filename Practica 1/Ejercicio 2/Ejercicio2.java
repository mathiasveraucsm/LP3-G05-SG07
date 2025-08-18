package Ejercicios;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		int[] numeros = new int[10];
		
		System.out.println("Ingrese el primer nro: ");
		numeros[0] = scanner.nextInt(); //como el cin
		
		for(int i = 1; i < 10; i++) {
			int num;
			while(true) {
				System.out.println("Ingrese el número "+ (i+1)+": "); //como el cout
				num = scanner.nextInt();//cin
				
				if(num > numeros[i-1]) {
					numeros[i] = num; //agregando
					break;
				} else {
					System.out.println("El número debe ser mayor que " + numeros[i-1]+". Intente nuevamente.");
				}
			}
		}
		System.out.println("\nNúmeros ingresados: ");
		for(int n: numeros) {
			System.out.println(n);
		}

	}

}
