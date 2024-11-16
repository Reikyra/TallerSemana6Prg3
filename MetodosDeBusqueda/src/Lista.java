import javax.swing.*;

public class Lista {

    private Nodo inicio;
    private int tamano;

    public Lista() {
        inicio = null;
        tamano = 0;
    }

    // Método para agregar un producto a la lista
    public void agregar(String producto, JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(producto);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamano++;
        actualizarLista(textArea);
    }

    // Método para eliminar un producto
    public boolean eliminar(String producto, JTextArea textArea) {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "El inventario está vacío.");
            return false;
        }
        if (inicio.producto.equalsIgnoreCase(producto)) {
            inicio = inicio.siguiente;
            tamano--;
            actualizarLista(textArea);
            return true;
        }
        Nodo actual = inicio;
        while (actual.siguiente != null && !actual.siguiente.producto.equalsIgnoreCase(producto)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            tamano--;
            actualizarLista(textArea);
            return true;
        }
        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        return false;
    }

    // Metodo para ordenar alfabéticamente usando Burbuja
    public void ordenarAlfabetico(JTextArea textArea) {
        if (inicio == null || inicio.siguiente == null) return;

        boolean burbuja;
        do {
            burbuja = false;
            Nodo actual = inicio;
            Nodo siguiente = inicio.siguiente;
            while (siguiente != null) {
                if (actual.producto.compareToIgnoreCase(siguiente.producto) > 0) {
                    String temp = actual.producto;
                    actual.producto = siguiente.producto;
                    siguiente.producto = temp;
                    burbuja = true;
                }
                actual = siguiente;
                siguiente = siguiente.siguiente;
            }
        } while (burbuja);

        actualizarLista(textArea);
    }

    // Metodo para buscar un producto de forma lineal
    public int buscarLineal(String producto, JTextArea textArea) {
        Nodo actual = inicio;
        int posicion = 0;
        while (actual != null) {
            if (actual.producto.equalsIgnoreCase(producto)) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1;
    }

    // Metodo para mostrar la lista
    public void mostrarLista(JTextArea textArea) {
        if (inicio == null) {
            textArea.setText("El inventario está vacío.");
        } else {
            StringBuilder listaStr = new StringBuilder();
            Nodo actual = inicio;
            while (actual != null) {
                listaStr.append(actual.producto).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(listaStr.toString());
        }
    }

    private void actualizarLista(JTextArea textArea) {
        mostrarLista(textArea);
    }
}
