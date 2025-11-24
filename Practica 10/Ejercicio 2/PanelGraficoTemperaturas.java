package ejercicio2;

import javax.swing.*;
import java.awt.*;

public class PanelGraficoTemperaturas extends JPanel {
    private int[] temperaturas;

    public void setTemperaturas(int[] temperaturas) {
        this.temperaturas = temperaturas;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (temperaturas == null) return;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);

        int ancho = getWidth();
        int alto = getHeight();
        int margen = 50;
        int espacio = (ancho - 2*margen) / (temperaturas.length - 1);

        for (int i = 0; i < temperaturas.length - 1; i++) {
            int x1 = margen + i * espacio;
            int y1 = alto - margen - temperaturas[i]*3;
            int x2 = margen + (i+1) * espacio;
            int y2 = alto - margen - temperaturas[i+1]*3;

            g2d.fillOval(x1-5, y1-5, 10, 10);
            g2d.drawLine(x1, y1, x2, y2);
        }

        int xLast = margen + (temperaturas.length-1)*espacio;
        int yLast = alto - margen - temperaturas[temperaturas.length-1]*3;
        g2d.fillOval(xLast-5, yLast-5, 10, 10);
    }
}
