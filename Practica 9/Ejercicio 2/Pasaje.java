package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pasaje extends JFrame implements ActionListener {
    private JTextField tfName, tfAddress, tfAge;
    private JCheckBox cbLuggage, cbMeal;
    private JRadioButton rbFirst, rbSecond;
    private JComboBox<String> cbDestination;
    private JList<String> listQuality;
    private JButton btnToggle, btnInfo;

    public Pasaje() {
        super("Compra de Pasaje");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(520, 360);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int r = JOptionPane.showConfirmDialog(Pasaje.this,
                        "¿Salir de la aplicación?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (r == JOptionPane.YES_OPTION) dispose();
            }
        });

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6,6,6,6);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Row 0
        c.gridx = 0; c.gridy = 0; add(new JLabel("Nombre:"), c);
        c.gridx = 1; tfName = new JTextField(20); add(tfName, c);

        c.gridx = 0; c.gridy = 1; add(new JLabel("Dirección:"), c);
        c.gridx = 1; tfAddress = new JTextField(20); add(tfAddress, c);

        c.gridx = 0; c.gridy = 2; add(new JLabel("Edad:"), c);
        c.gridx = 1; tfAge = new JTextField(4); add(tfAge, c);

        // Checkboxes
        c.gridx = 0; c.gridy = 3; add(new JLabel("Servicios opcionales:"), c);
        JPanel pChecks = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        cbLuggage = new JCheckBox("Equipaje (+$5)");
        cbMeal = new JCheckBox("Comida (+$3)");
        pChecks.add(cbLuggage); pChecks.add(cbMeal);
        c.gridx = 1; add(pChecks, c);

        // Radio buttons
        c.gridx = 0; c.gridy = 4; add(new JLabel("Piso:"), c);
        rbFirst = new JRadioButton("1er piso"); rbSecond = new JRadioButton("2do piso");
        ButtonGroup bg = new ButtonGroup(); bg.add(rbFirst); bg.add(rbSecond);
        JPanel pRad = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0)); pRad.add(rbFirst); pRad.add(rbSecond);
        c.gridx = 1; add(pRad, c);

        // Combo box
        c.gridx = 0; c.gridy = 5; add(new JLabel("Destino:"), c);
        cbDestination = new JComboBox<>(new String[] {"Lima", "Arequipa", "Cusco", "Trujillo"});
        c.gridx = 1; add(cbDestination, c);

        // List
        c.gridx = 0; c.gridy = 6; add(new JLabel("Calidad de servicio:"), c);
        listQuality = new JList<>(new String[] {"Económico", "Standard", "VIP"});
        listQuality.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane sp = new JScrollPane(listQuality); sp.setPreferredSize(new Dimension(180,60));
        c.gridx = 1; add(sp, c);

        // Buttons
        JPanel pButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        btnToggle = new JButton("Bloquear/Desbloquear");
        btnInfo = new JButton("Mostrar Información");
        btnToggle.addActionListener(this); btnInfo.addActionListener(this);
        pButtons.add(btnToggle); pButtons.add(btnInfo);
        c.gridx = 0; c.gridy = 7; c.gridwidth = 2; add(pButtons, c);

        // MouseAdapter: doble clic en la lista muestra la selección
        listQuality.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String sel = listQuality.getSelectedValue();
                    if (sel != null) JOptionPane.showMessageDialog(Pasaje.this,
                            "Seleccionaste: " + sel);
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnToggle) {
            boolean enabled = !tfName.isEnabled();
            tfName.setEnabled(enabled); tfAddress.setEnabled(enabled); tfAge.setEnabled(enabled);
            cbLuggage.setEnabled(enabled); cbMeal.setEnabled(enabled);
            rbFirst.setEnabled(enabled); rbSecond.setEnabled(enabled);
            cbDestination.setEnabled(enabled); listQuality.setEnabled(enabled);
        } else if (src == btnInfo) {
            String name = tfName.getText().trim();
            String addr = tfAddress.getText().trim();
            String age = tfAge.getText().trim();
            String services = (cbLuggage.isSelected() ? "Equipaje " : "") +
                              (cbMeal.isSelected() ? "Comida" : "");
            String piso = rbFirst.isSelected() ? "1er piso" : rbSecond.isSelected() ? "2do piso" : "No seleccionado";
            String dest = (String) cbDestination.getSelectedItem();
            String quality = listQuality.getSelectedValue();
            String msg = String.format("Nombre: %s\nDirección: %s\nEdad: %s\nServicios: %s\nPiso: %s\nDestino: %s\nCalidad: %s",
                    name, addr, age, services.isEmpty() ? "Ninguno" : services, piso, dest, quality == null ? "Ninguna" : quality);
            JOptionPane.showMessageDialog(this, msg, "Resumen del Pasajero", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Pasaje().setVisible(true));
    }
}