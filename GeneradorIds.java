public class GeneradorIds {
    private static int contador = 0;

    public static int generarNuevoId() {
        return ++contador;
    }

    //para cargar desde el ultimo archivo o sea si ya hay mascotas en el archivo no se devuelve a 0 (para que no se repita id
    public static void setUltimoId (int ultimoId) {
        contador = ultimoId;
    }
}