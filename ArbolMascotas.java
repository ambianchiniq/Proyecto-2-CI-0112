public class ArbolMascotas {
    private NodoArbol<Mascota> raiz;

    public ArbolMascotas() {
        raiz = null;
    }


    //Inserta mascota nueva en el arbol
    public void insertar(Mascota mascota) {
        raiz = insertarRecursivo(raiz, mascota);
    }

    private NodoArbol<Mascota> insertarRecursivo(NodoArbol<Mascota> nodo, Mascota mascota) {
        if (nodo == null) {
            return new NodoArbol<>(mascota);
        }

        //compara directamente
        if(mascota.getId() < nodo.dato.getId()) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, mascota);
        } else if (mascota.getId() > nodo.dato.getId()) {
            nodo.derecho = insertarRecursivo(nodo.derecho, mascota);
        } //esto tambien hace que si son iguales (que no deberia de ocurrir) no se inserta

        return nodo;

    }

}