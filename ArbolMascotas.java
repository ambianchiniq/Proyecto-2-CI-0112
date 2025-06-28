import java.util.ArrayList;

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
        if(mascota.getId() < nodo.getDato().getId()) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), mascota));
        } else if (mascota.getId() > nodo.getDato().getId()) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho, mascota));
        } //esto tambien hace que si son iguales (que no deberia de pasar) no se inserta

        return nodo;

    }

    //busca por id de la mascota
    public Mascota buscarPorId (int id){
        return buscarRec(raiz, id);
    
    }

    //busca recursivamente el id
    private Mascota buscarRecursivo(NodoArbol<Mascota> nodo, int id) {
        if (nodo == null) return null;

        if (id == nodo.getDato().getId()) {
            return nodo.getDato();
        }
        
        if (id < nodo.getDato().getId()) {
            return buscarRecursivo(nodo.getIzquierdo(), id);
        } else {
            return buscarRecursivo(nodo.getDerecho(), id);
        }
    }

    //para eliminar mascota 
    public void eliminar(int id) {
        raiz = eliminarRecursivo(raiz, id);
    }

    private NodoArbol<Mascota> eliminarRecursivo(NodoArbol<Mascota> nodo, int id) {
        if (nodo == null) return null;

        if (id < nodo.getDato().getId()) {
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), id));
        } else if (id > nodo.getDato().getId()) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), id));
        } else {
            //para nodos con un solo hijo o sin hijos
            if(nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            //nodo para dos hijos hace que obtiene el sucesor con el minimo a la derecha
            NodoArbol<Mascota> sucesor = obtenerMinimo(nodo.getDerecho());
            nodo.setDato(sucesor.getDato());
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesor.getDato().getId()));
        }

        return nodo;
    }


    // Mostrar recorrido inorden (mascotas ordenadas por ID)
    //Rec es recursivo pero el nombre iba a quedar muy largo
    public void mostrarInorden() {
        mostrarInordenRec(raiz);
    }

    private void mostrarInordenRec(NodoArbol<Mascota> nodo) {
        if (nodo != null) {
            mostrarInordenRec(nodo.getIzquierdo());
            System.out.println(nodo.getDato()); // para consola
            mostrarInordenRec(nodo.getDerecho());
        }
    }

    // Convertir recorrido inorden a arreglo de Strings para GUI
    public String[] obtenerMascotasOrdenadas() {
        ArrayList<String> lista = new ArrayList<>();
        llenarInordenEnLista(raiz, lista);
        return lista.toArray(new String[0]);
    }

    private void llenarInordenEnLista(NodoArbol<Mascota> nodo, ArrayList<String> lista) {
        if (nodo != null) {
            llenarInordenEnLista(nodo.getIzquierdo(), lista);
            lista.add(nodo.getDato().toString());
            llenarInordenEnLista(nodo.getDerecho(), lista);
        }
    }

    // Para guardar desde archivo externo
    public NodoArbol<Mascota> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<Mascota> raiz) {
        this.raiz = raiz;
    }
}
