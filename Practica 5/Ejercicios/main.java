package ejercicio;

public class main {
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Melgar", 1915);
        Par<Double, Boolean> par2 = new Par<>(3.14, true);
        Par<Persona, Integer> par3 = new Par<>(new Persona("Mathias", 22), 100);

        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);
    }
}