package ejercicio3;

import javax.swing.*;
import java.awt.*;

public class AppSonidos extends JFrame {
    public AppSonidos() {
        setTitle("Reproductor de Efectos");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton aplausosBtn = new JButton("Aplausos");
        JButton campanaBtn = new JButton("Campana");
        JButton explosionBtn = new JButton("Explosión");

        aplausosBtn.addActionListener(e -> SoundPlayer.playSound("aplausos.wav"));
        campanaBtn.addActionListener(e -> SoundPlayer.playSound("campana.wav"));
        explosionBtn.addActionListener(e -> SoundPlayer.playSound("explosion.wav"));

        add(aplausosBtn);
        add(campanaBtn);
        add(explosionBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AppSonidos();
    }
}
