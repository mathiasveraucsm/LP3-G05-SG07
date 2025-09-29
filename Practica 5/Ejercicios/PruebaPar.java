package ejercicio;

public class PruebaPar {
    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Melgar", 1915);
        Par<String, Integer> par2 = new Par<>("Melgar", 1915);
        Par<String, Integer> par3 = new Par<>("Arequipa", 2025);

        System.out.println(par1.esIgual(par2)); 
        System.out.println(par1.esIgual(par3)); 
    }
}
