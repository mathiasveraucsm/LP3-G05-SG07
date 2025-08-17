public class Ejercicio5
{
    public static void main(String[] args) { 
        calcular_cuota(1);
        calcular_cuota(3);
        calcular_cuota(4);
        calcular_cuota(100);
    }
    
    public static void calcular_cuota(int horas) {
        double cuota = 0;
        if (horas >= 1) {
            cuota = cuota + 3;
        }
        if (horas > 2) {
            cuota = cuota + (0.5*(horas-1));
        }
        if (cuota > 12) {
            cuota = 12;
            System.out.println("Por el uso del estacionamiento por " + horas + " hora(s), su cargo correspondiente es de " + cuota + " soles.");
        }
        else if (cuota <= 12) {
            System.out.println("Por el uso del estacionamiento por " + horas + " horas, su cargo correspondiente es de " + cuota + " soles.");
        }
    }
}
