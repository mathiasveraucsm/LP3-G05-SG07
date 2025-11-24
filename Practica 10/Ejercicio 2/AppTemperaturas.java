package ejercicio2;

import javax.swing.*;
import java.awt.*;

public class AppTemperaturas extends JFrame {
    private JTextField[] campos;
    private PanelGraficoTemperaturas panelGrafico;

    public AppTemperaturas() {
        setTitle("Temperaturas Semanales");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2,7));
        String[] dias = {"Lun","Mar","Mié","Jue","Vie","Sáb","Dom"};
        campos = new JTextField[7];

        for (int i=0; i<7; i++) {
            inputPanel.add(new JLabel(dias[i]));
            campos[i] = new JTextField("0");
            inputPanel.add(campos[i]);
        }

        JButton mostrarBtn = new JButton("Mostrar Gráfico");
        mostrarBtn.addActionListener(e -> {
            int[] temps = new int[7];
            for (int i=0; i<7; i++) {
                temps[i] = Integer.parseInt(campos[i].getText());
            }
            panelGrafico.setTemperaturas(temps);
        });

        panelGrafico = new PanelGraficoTemperaturas();

        add(inputPanel, BorderLayout.NORTH);
        add(mostrarBtn, BorderLayout.SOUTH);
        add(panelGrafico, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AppTemperaturas();
    }
}