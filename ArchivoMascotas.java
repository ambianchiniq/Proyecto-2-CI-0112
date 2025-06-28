public class ArchivoMascotas {
    public static void guardarMascotas(ArbolMascotas arbol, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            guardarRecursivo(arbol.getRaiz(), writer);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
        }
    }

    private static void guardarRecursivo(NodoArbol<Mascota> nodo, PrintWriter writer) {
        if (nodo != null) {
            guardarRecursivo(nodo.getIzquierdo(), writer);
            Mascota m = nodo.getDato();
            writer.println(m.getId() + "," + m.getNombre() + "," + m.getEspecie() + "," + m.getDuenio());
            guardarRecursivo(nodo.getDerecho(), writer);
        }
    }

    // método para cargar desde archivo también debe ir aquí
}