package actividad56;

public class ArrayPersona {
	public Persona arreglo[];
	final int max = 128;
	int tamaño = 0;
	
	public ArrayPersona() {
		this.arreglo = new Persona[this.max];
	}
	
	public void printArray(String nombre) {
		for (int i = 0; i < this.tamaño; i++) {
			if (this.arreglo[i].getNombre().equals(nombre)) {
				System.out.println(this.arreglo[i]);
			}
		}
	}
	
	public void addArray(Persona persona) {
		if (this.tamaño == max)
			System.exit(1);
		this.arreglo[this.tamaño++] = persona;
	}
}
