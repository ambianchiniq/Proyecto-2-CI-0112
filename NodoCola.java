
// <T> es el tipo de dato que almacena el nodo
//solo necesita referencia al siguiente nodo porque es una lista simple
public class NodoCola<T> {
    private T dato;
    private NodoCola<T> siguiente;


    //Constructor del nodo
    public NodoCola(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }


    //Setter y getters para obtener los datos luego
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoCola<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola<T> siguiente) {
        this.siguiente = siguiente;
    }
    
}