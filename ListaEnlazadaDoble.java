
//clase para manejar la lista doblemente enlazada para manejar la cola de espera
public class ListaEnlazadaDoble<T> {
    private Nodo<T> cabeza; //primer elemento de la lista
    private Nodo<T> cola; //ultimo elemento de la lista
    private int tamano; //cantidad de elementos en la lista

    //Constructor para la lista vacia
    public ListaEnlazadaDoble() {
        cabeza = null;
        cola = null; 
        tamano = 0;
    }

    //metodo para agregar elemento al final de la lista osea es la cola
    public void agregarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if(cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;

        } else {
            nuevoNodo.prev = cola;
            cola.next = nuevoNodo;
            cola = nuevoNodo;
        }
        tamano++;
    }

    //metodo para eliminar y retornar el primer elemento de la lista y utiliza el if por si esta vacia
    public T eliminarInicio () {
        if (cabeza == null) {
            return null;
        }

        Nodo<T> temp = cabeza;
        cabeza = cabeza.next;

        if (cabeza != null) {
            cabeza.prev = null;

        } else {
            cola = null; //la lista queda vacia
        }

        tamano--;
        return temp.dato;
    }

    //Verifica si la lista esta vacia
    public boolean estaVacia() {
        return cabeza == null;
    }

    //retorna el tamano de la lista 
    public int getTamano() {
        return tamano;
    }

    //ocupamos un metodo que que obtenga los elementos de la lista como un array para poder imprimirlos en el GUI
}