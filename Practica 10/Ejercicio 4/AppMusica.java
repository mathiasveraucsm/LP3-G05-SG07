package ejercicio4;

import javax.swing.*;
import java.awt.*;

public class AppMusica extends JFrame {
    private MusicPlayer player;

    public AppMusica() {
        setTitle("Reproductor de Música");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        player = new MusicPlayer();
        player.cargar("musica.wav"); 

        JButton playBtn = new JButton("Reproducir");
        JButton pauseBtn = new JButton("Pausar");
        JButton resumeBtn = new JButton("Reanudar");

        playBtn.addActionListener(e -> player.reproducir());
        pauseBtn.addActionListener(e -> player.pausar());
        resumeBtn.addActionListener(e -> player.reanudar());

        add(playBtn);
        add(pauseBtn);
        add(resumeBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AppMusica();
    }
}