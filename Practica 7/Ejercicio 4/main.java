package ejercicio4;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccione el archivo de texto");

        int resultado = chooser.showOpenDialog(null);
        if (resultado != JFileChooser.APPROVE_OPTION) {
            System.out.println("No se seleccionó ningún archivo. Intente nuevamente.");
            return;
        }

        File archivo = chooser.getSelectedFile();
        ContadorPalabras contador = new ContadorPalabras(archivo);

        try {
            contador.analizar();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}