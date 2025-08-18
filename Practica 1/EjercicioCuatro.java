package Ejercicios;
import java.util.Scanner;

public class EjercicioCuatro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        double num = sc.nextInt();

        System.out.println("Ingrese un número: ");
        double num2 = sc.nextInt();

        System.out.println("Ingrese un número: ");
        double num3 = sc.nextInt();

        System.out.println(calcularMenor(num, num2, num3));
    }

    public static double calcularMenor(double args1, double args2, double args3) {
        return Math.min(args1, Math.min(args2, args3));        
    }
}