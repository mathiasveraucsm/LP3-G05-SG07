package ejercicio1;

import javax.swing.*;
import java.awt.*;

public class AppProducto extends JFrame {
    private Producto producto;
    private JTextField nombreField, precioField, stockField, categoriaField;
    private JLabel infoLabel;

    public AppProducto() {
        producto = new Producto("Laptop", 2500.0, 10, "Electrónica");

        setTitle("Gestión de Producto");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        nombreField = new JTextField(producto.getNombre(), 15);
        precioField = new JTextField(String.valueOf(producto.getPrecio()), 10);
        stockField = new JTextField(String.valueOf(producto.getCantidadStock()), 10);
        categoriaField = new JTextField(producto.getCategoria(), 15);

        JButton actualizarBtn = new JButton("Actualizar Producto");
        infoLabel = new JLabel("<html>" + producto.toString().replace("\n", "<br>") + "</html>");

        actualizarBtn.addActionListener(e -> {
            producto.setNombre(nombreField.getText());
            producto.setPrecio(Double.parseDouble(precioField.getText()));
            producto.setCantidadStock(Integer.parseInt(stockField.getText()));
            producto.setCategoria(categoriaField.getText());

            infoLabel.setText("<html>" + producto.toString().replace("\n", "<br>") + "</html>");
        });

        add(new JLabel("Nombre:")); add(nombreField);
        add(new JLabel("Precio:")); add(precioField);
        add(new JLabel("Stock:")); add(stockField);
        add(new JLabel("Categoría:")); add(categoriaField);
        add(actualizarBtn);
        add(infoLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AppProducto();
    }
}
