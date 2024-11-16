import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaGUI {
    private JPanel pGeneral;
    private JTextField textField1;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton ordenarButton;
    private JButton buscarLinealButton;
    private JTextArea textArea1;

    Lista lista = new Lista();

    public ListaGUI() {
        // Botón para agregar un producto
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String producto = textField1.getText().trim();
                if (!producto.isEmpty()) {
                    lista.agregar(producto, textArea1);
                    textField1.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "El campo no puede estar vacío.");
                }

            }
        });
        // Botón para eliminar un producto
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String producto = textField1.getText().trim();
                if (!producto.isEmpty()) {
                    lista.eliminar(producto, textArea1);
                    textField1.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "El campo no puede estar vacío.");
                }
            }
        });
            // Botón para ordenar alfabéticamente
        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.ordenarAlfabetico(textArea1);
                JOptionPane.showMessageDialog(null, "Inventario ordenado alfabéticamente.");

            }
        });
        // Botón para buscar un producto
        buscarLinealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String producto = textField1.getText().trim();
                if (!producto.isEmpty()) {
                    int posicion = lista.buscarLineal(producto, textArea1);
                    if (posicion == -1) {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto encontrado en la posición: " + (posicion + 1));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo no puede estar vacío.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Inventario");
        frame.setContentPane(new ListaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
