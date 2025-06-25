
//clase para manejar la cola FIFO
public class ColaAtencion<T> {
    private NodoCola<T> frente; //primer elemento de la lista
    private NodoCola<T> fin; //ultimo elemento de la lista
    private int tamano; //cantidad de elementos en la lista

    //Constructor para la lista vacia
    public ColaAtencion() {
        frente = null;
        fin = null; 
        tamano = 0;
    }

    //metodo para agregar elemento al final de la lista osea es la cola
    public void agregarFinal(T mascota) {
        NodoCola<T> nuevo = new NodoCola<>(mascota);

        if(estaVacia()) {
            frente = nuevo;

        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamano++;
    }

    //metodo para eliminar y retornar el primer elemento de la lista y utiliza el if por si esta vacia
    public T eliminarInicio (String mensajeVacio) {
        if (estaVacia()) {
            System.out.println(mensajeVacio); //para la consola (depuracion)
            return null;
        }

        T atendida = frente.dato;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        tamano--;

        return atendida;
    }

    //Verifica si la lista esta vacia
    public boolean estaVacia() {
        return frente == null;
    }

    //retorna el tamano de la lista 
    public int getTamano() {
        return tamano;
    }

    // obtiene la proxima mascota sin removerla
    public T verProxima() {
        if(estaVacia()); return null;
        return frente.dato;
    }

    //Necesitamos un metodo que convierta la cola en array para el GUI

}