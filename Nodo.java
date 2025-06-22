
// <T> es el tipo de dato que almacena el nodo
public class Nodo<T> {
    public T dato; //Es el dato almacenado en el nodo
    //Estos siguientes son para la referencia al siguiente y anterior nodo para la lista y la lista doble
    public Nodo<T> next; 
    public Nodo<T> prev;
    //Hijo derecho e izquierdo para el arbol
    public Nodo<T> left;
    public Nodo<T> right;


    //Constructor para lista enlazada
    public Nodo(T dato) {
        this.dato = dato;
        this.next = null;
        this.prev = null;
        this.left = null;
        this.right = null;
    }


    //Constructor para el arbol binario 
    public Nodo(T dato, Nodo<T> left, Nodo<T> right) {
        this.dato = dato;
        this.left = left;
        this.right = right;
        this.next = null;
        this.prev = null;
    }
}