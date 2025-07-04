import java.io.*;
import javax.swing.*;

public class ArchivoMascotas {
    //guarda el arbol en el archivo
    public static void guardarMascotas(ArbolMascotas arbol, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            guardarRecursivo(arbol.getRaiz(), writer);
            writer.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
        }
    }

    //recorre el arbol recursivamente para escribir cada mascota
    private static void guardarRecursivo(NodoArbol<Mascota> nodo, PrintWriter writer) {
        if (nodo != null) {
            guardarRecursivo(nodo.getIzquierdo(), writer);
            Mascota m = nodo.getDato();
            writer.println(m.getId() + "," + m.getNombre() + "," + m.getEspecie() + "," + m.getDueno());
            guardarRecursivo(nodo.getDerecho(), writer);
        }
    }

    // metodo para cargar desde archivo tambien debe ir aqui
}
