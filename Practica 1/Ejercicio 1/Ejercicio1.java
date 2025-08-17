public class Ejercicio1 {

	public static void main(String[] args) {
		int[] a1 = {1, 2, 3, 4, 5};
		int[] a2 = {10, 20, 30, 40, 50};
		System.out.println("La suma de los elementos del arreglo es igual a: " + sumar_arreglo(a1));
		System.out.println("La suma de los elementos del arreglo es igual a: " + sumar_arreglo(a2));
	}
	
	public static int sumar_arreglo(int[] arr) {
		int suma = 0;
		for (int i = 0; i < arr.length; i++) {
			  suma = suma + arr[i];
			}
		return suma;
	}
  
}
