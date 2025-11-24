package ejercicio4;

import javax.sound.sampled.*;
import java.io.File;

public class MusicPlayer {
    private Clip clip;
    private long pausaPos = 0;

    public void cargar(String ruta) {
        try {
            File file = new File(ruta);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reproducir() {
        if (clip != null) {
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }

    public void pausar() {
        if (clip != null && clip.isRunning()) {
            pausaPos = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    public void reanudar() {
        if (clip != null) {
            clip.setMicrosecondPosition(pausaPos);
            clip.start();
        }
    }
}