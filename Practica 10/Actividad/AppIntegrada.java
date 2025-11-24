package actividad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.sound.sampled.*;
import java.io.File;

public class AppIntegrada extends JFrame {

    public AppIntegrada() {
        setTitle("Aplicación Integrada - Binding, Gráficos y Multimedia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Binding", crearPanelBinding());

        tabbedPane.addTab("Gráficos", new PanelGraficos());

        tabbedPane.addTab("Multimedia", crearPanelMultimedia());

        add(tabbedPane);
        setVisible(true);
    }

    private JPanel crearPanelBinding() {
        JPanel panel = new JPanel(new FlowLayout());

        Persona persona = new Persona("Juan Perez", 25, "Masculino");

        JTextField nombreField = new JTextField(persona.getNombre(), 15);
        JTextField edadField = new JTextField(String.valueOf(persona.getEdad()), 15);
        JTextField sexoField = new JTextField(persona.getSexo(), 15);

        JButton actualizarBtn = new JButton("Actualizar Modelo");

        actualizarBtn.addActionListener(e -> {
            persona.setNombre(nombreField.getText());
            try {
                persona.setEdad(Integer.parseInt(edadField.getText()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Edad inválida");
            }
            persona.setSexo(sexoField.getText());

            JOptionPane.showMessageDialog(panel,
                "Modelo actualizado:\nNombre: " + persona.getNombre() +
                "\nEdad: " + persona.getEdad() +
                "\nSexo: " + persona.getSexo());
        });

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Edad:"));
        panel.add(edadField);
        panel.add(new JLabel("Sexo:"));
        panel.add(sexoField);
        panel.add(actualizarBtn);

        return panel;
    }

    class PanelGraficos extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                 RenderingHints.VALUE_ANTIALIAS_ON);

            int rectWidth = 100, rectHeight = 50;
            AffineTransform original = g2d.getTransform();

            g2d.setColor(Color.GRAY);
            g2d.fillRect(50, 50, rectWidth, rectHeight);

            g2d.translate(200, 0);
            g2d.setColor(Color.BLUE);
            g2d.fillRect(50, 50, rectWidth, rectHeight);
            g2d.setTransform(original);

            g2d.rotate(Math.toRadians(45), 100, 75);
            g2d.setColor(Color.GREEN);
            g2d.fillRect(50, 50, rectWidth, rectHeight);
            g2d.setTransform(original);

            g2d.translate(50, 150);
            g2d.scale(1.5, 0.5);
            g2d.setColor(Color.ORANGE);
            g2d.fillRect(50, 50, rectWidth, rectHeight);
            g2d.setTransform(original);

            g2d.translate(250, 150);
            g2d.shear(0.5, 0);
            g2d.setColor(Color.MAGENTA);
            g2d.fillRect(50, 50, rectWidth, rectHeight);
            g2d.setTransform(original);

            g2d.setColor(Color.BLACK);
            g2d.drawString("Ejemplo de Transformaciones con Graphics2D", 50, 300);
        }
    }

    private JPanel crearPanelMultimedia() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel labelImagen = new JLabel(new ImageIcon("imagen.jpg")); 
        panel.add(labelImagen, BorderLayout.CENTER);

        JButton btnAudio = new JButton("Reproducir Audio");
        btnAudio.addActionListener(e -> reproducirAudio("audio.wav")); 
        panel.add(btnAudio, BorderLayout.SOUTH);

        return panel;
    }

    private void reproducirAudio(String ruta) {
        try {
            File audioFile = new File(ruta);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al reproducir audio: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppIntegrada::new);
    }
}


