public class Recorrido {
    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato().getNombre() + " (" + nodo.getDato().getCantidad() + ")");
            preorden(nodo.getIzq());
            preorden(nodo.getDer());
        }
    }
    
    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.getIzq());
            System.out.println(nodo.getDato().getNombre() + " (" + nodo.getDato().getCantidad() + ")");
            inorden(nodo.getDer());
        }
    }
    
    public void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.getIzq());
            postorden(nodo.getDer());
            System.out.println(nodo.getDato().getNombre() + " (" + nodo.getDato().getCantidad() + ")");
        }
    }
}