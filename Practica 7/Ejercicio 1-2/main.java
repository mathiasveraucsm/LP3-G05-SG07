package ejercicio12;

public class main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        gestor.añadirPersonaje(new Personaje("Caballero", 2, 2, 2, 1));
        gestor.añadirPersonaje(new Personaje("Guerrero", 2, 4, 4, 2));
        gestor.añadirPersonaje(new Personaje("Arquero", 2, 3, 1, 4));

        gestor.modificarPersonaje("Arquero", 3, 4, 2, 5);
        gestor.borrarPersonaje("Guerrero");

        gestor.mostrarPersonajes();
    }
}