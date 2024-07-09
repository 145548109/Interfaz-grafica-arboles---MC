package interfazGrafica;

import java.util.concurrent.TimeUnit;

public class ArbolBinario extends EstructuraDeDato {

    private int altura;
    private NodoArbol nodoRaiz;
    private VistaArbol viewTree;
    private String aux;

    public String getAux() {
        return aux;
    }

    public VistaArbol getViewTree() {
        return viewTree;
    }

    public void setViewTree(VistaArbol viewTree) {
        this.viewTree = viewTree;
    }

    public ArbolBinario(VistaArbol viewTree) {
        this.viewTree = viewTree;
    }

    public ArbolBinario() {
        this.viewTree = new VistaArbol(this);
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoArbol getNodoRaiz() {
        return nodoRaiz;
    }

    public void setNodoRaiz(NodoArbol nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }

    @Override
    public void agregarNodo(int valor) {
        if (this.nodoRaiz == null) {
            this.nodoRaiz = new NodoArbol(valor);
        } else {
            this.nodoRaiz.insertarNodo(valor);
        }
    }

    @Override
    public void insertarNodo(int dato, int posicion) {
    }

    @Override
    public void recorrer() {
    }

    @Override
    public void borrarNodo(int posicion) {
        if (nodoRaiz == null) {
            return;
        }

        nodoRaiz = nodoRaiz.delete(nodoRaiz, posicion);
        recorrerInOrden();
    }

    @Override
    public void limpiar() {
    }

    @Override
    public void modificarNodo(int posicion) {
    }

    @Override
    public void ordenar() {
    }

    @Override
    public void buscarPorDato(int dato) {
    }

    // PreOrden: Raiz, Izquierdo, Derecho
    public void recorrerPreOrden() {
        StringBuilder recorrido = new StringBuilder();
        this.preOrden(this.nodoRaiz, recorrido);
        viewTree.actualizarRecorrido(recorrido.toString());
    }

    private void preOrden(NodoArbol nodo, StringBuilder recorrido) {
        if (nodo == null) {
            return; // Detener recursividad
        } else {
            recorrido.append(nodo.getValor()).append(" - ");
            viewTree.updateView(nodo);
            try {
                // Pausa de 1 segundo
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            preOrden(nodo.getNodoIzquierdo(), recorrido);
            preOrden(nodo.getNodoDerecho(), recorrido);
        }
    }

    // InOrden: Izquierdo, Raiz, Derecho
    public void recorrerInOrden() {
        StringBuilder recorrido = new StringBuilder();
        this.inOrden(this.nodoRaiz, recorrido);
        viewTree.actualizarRecorrido(recorrido.toString());
    }

    private void inOrden(NodoArbol nodo, StringBuilder recorrido) {
        if (nodo == null) {
            return; // Detener recursividad
        } else {
            inOrden(nodo.getNodoIzquierdo(), recorrido);
            viewTree.updateView(nodo);
            try {
                // Pausa de 1 segundo
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            recorrido.append(nodo.getValor()).append(" - ");
            inOrden(nodo.getNodoDerecho(), recorrido);
        }
    }

    // PostOrden: Izquierdo, Derecho, Raiz
    public void recorrerPostOrden() {
        StringBuilder recorrido = new StringBuilder();
        this.postOrden(this.nodoRaiz, recorrido);
        viewTree.actualizarRecorrido(recorrido.toString());
    }

    public void postOrden(NodoArbol nodo, StringBuilder recorrido) {
        if (nodo == null) {
            return; // Detener recursividad
        } else {
            postOrden(nodo.getNodoIzquierdo(), recorrido);
            postOrden(nodo.getNodoDerecho(), recorrido);
            viewTree.updateView(nodo);
            try {
                // Pausa de 1 segundo
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            recorrido.append(nodo.getValor()).append(" - ");
        }
    }
}