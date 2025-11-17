package Ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import javax.swing.*;
import java.awt.event.*;

public class ejercicio1 extends JFrame {
    private JPanel contentPane;
    private JButton btnSaludar;
    private JTextField txtIngresaTextoAqui;

    public ejercicio1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnSaludar = new JButton("Saludar");
        btnSaludar.setBounds(171, 53, 120, 30);
        contentPane.add(btnSaludar);
        
        txtIngresaTextoAqui = new JTextField();
        txtIngresaTextoAqui.setText("Ingresa texto aqui...");
        txtIngresaTextoAqui.setBounds(154, 113, 120, 18);
        contentPane.add(txtIngresaTextoAqui);
        txtIngresaTextoAqui.setColumns(10);

        btnSaludar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hola Mundo");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio1 frame = new ejercicio1();
            frame.setVisible(true);
        });
    }
}
