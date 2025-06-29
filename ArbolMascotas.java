public class ArbolMascotas {
    private NodoArbol<Mascota> raiz;

    public ArbolMascotas() {
        raiz = null;
    }

    // Inserta mascota nueva en el arbol
    public void insertar(Mascota mascota) {
        raiz = insertarRecursivo(raiz, mascota);
    }

    private NodoArbol<Mascota> insertarRecursivo(NodoArbol<Mascota> nodo, Mascota mascota) {
        if (nodo == null) {
            return new NodoArbol<>(mascota);
        }

        //Compara directamente
        if (mascota.getId() < nodo.getDato().getId()) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), mascota));
        } else if (mascota.getId() > nodo.getDato().getId()) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), mascota));
        }
        // Si el id es igual, no se inserta para evitar duplicados
        return nodo;
    }

    // Busca el id de una mascota
    public Mascota buscarPorId(int id) {
        return buscarRecursivo(raiz, id);
    }

    //Busca recursivamente el id
    private Mascota buscarRecursivo(NodoArbol<Mascota> nodo, int id) {
        if (nodo == null) {
            return null;
        }
        if (id == nodo.getDato().getId()) {
            return nodo.getDato();
        } else if (id < nodo.getDato().getId()) {
            return buscarRecursivo(nodo.getIzquierdo(), id);
        } else {
            return buscarRecursivo(nodo.getDerecho(), id);
        }
    }

    // Elimina una mascota 
    public void eliminar(int id) {
        raiz = eliminarRecursivo(raiz, id);
    }

    private NodoArbol<Mascota> eliminarRecursivo(NodoArbol<Mascota> nodo, int id) {
        if (nodo == null) {
            return null;
        }

        if (id < nodo.getDato().getId()) {
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), id));
        } else if (id > nodo.getDato().getId()) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), id));
        } else {
            // Si encuentra un nodo tiene casos de eliminación: por ejemplo que tenga un solo hijo o que no tenga hijos
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            } else {
                // Nodo con dos hijos y obtiene sucesor (mínimo del subárbol derecho)
                NodoArbol<Mascota> sucesor = obtenerMinimo(nodo.getDerecho());
                nodo.setDato(sucesor.getDato());
                nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesor.getDato().getId()));
            }
        }
        return nodo;
    }

    // Encuentra el nodo con el valor mínimo (más a la izquierda)
    private NodoArbol<Mascota> obtenerMinimo(NodoArbol<Mascota> nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    // Cuenta la cantidad de nodos del árbol
    private int contarNodos(NodoArbol<Mascota> nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }

    // Llena un arreglo con las mascotas en orden solo para el archivo ya que la cola si es FIFO
    private void llenarArrayInorden(NodoArbol<Mascota> nodo, String[] arr, int[] index) {
        if (nodo != null) {
            llenarArrayInorden(nodo.getIzquierdo(), arr, index);
            arr[index[0]] = nodo.getDato().toString();
            index[0]++;
            llenarArrayInorden(nodo.getDerecho(), arr, index);
        }
    }

    // Devuelve un arreglo de String con las mascotas ordenadas por id (La cola si es FIFO)
    public String[] obtenerMascotasOrdenadas() {
        int total = contarNodos(raiz);
        String[] resultado = new String[total];
        int[] index = {0};  // índice por referencia para la recursión
        llenarArrayInorden(raiz, resultado, index);
        return resultado;
    }

    //getters y setters de la raíz
    public NodoArbol<Mascota> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<Mascota> raiz) {
        this.raiz = raiz;
    }

    // Mostrar árbol en orden
    public void mostrarInorden() {
        mostrarInordenRec(raiz);
    }

    private void mostrarInordenRec(NodoArbol<Mascota> nodo) {
        if (nodo != null) {
            mostrarInordenRec(nodo.getIzquierdo());
            System.out.println(nodo.getDato());
            mostrarInordenRec(nodo.getDerecho());
        }
    }
}
