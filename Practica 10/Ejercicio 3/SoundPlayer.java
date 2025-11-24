package ejercicio3;

import javax.sound.sampled.*;
import java.io.File;

public class SoundPlayer {
    public static void playSound(String ruta) {
        try {
            File file = new File(ruta);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}