package Ejercicios;
import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese la hora: ");
        int hora = sc.nextInt();
        System.out.println("Ingrese los minutos: ");
        int min = sc.nextInt();
        System.out.println("Ingrese los segundos:");
        int seg = sc.nextInt();
        
        int horaSegundos = hora*3600;
        int minSegundos = min*60;
        int total = horaSegundos + minSegundos + seg;
        
        System.out.println("La hora indicada en segundos es: "+total);
	}

}
