import java.io.*;
import javax.swing.*;

public class ArchivoMascotas {

    // Guarda las mascotas del arbol en el archivo
    public static void guardarEnArchivo(ArbolMascotas arbol) {
        try {
            File archivo = new File("mascotas_guardadas.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

            guardarRecursivo(arbol.getRaiz(), writer);
            writer.close();

            JOptionPane.showMessageDialog(null, "Archivo guardado correctamente.");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar archivo: " + e.getMessage());
        }
    }

    // Recorrido inorden y escritura
    private static void guardarRecursivo(NodoArbol<Mascota> nodo, BufferedWriter writer) throws IOException {
        if (nodo != null) {
            guardarRecursivo(nodo.getIzquierdo(), writer);
            Mascota m = nodo.getDato();
            String linea = m.getId() + "," + m.getNombre() + "," + m.getEspecie() + "," + m.getDuenio();
            writer.write(linea);
            writer.newLine();
            guardarRecursivo(nodo.getDerecho(), writer);
        }
    }
}
