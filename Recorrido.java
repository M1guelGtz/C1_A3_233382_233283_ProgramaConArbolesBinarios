public class Recorrido {
    public void preOrden(Nodo raiz){
        if (raiz != null) {
            System.out.print(raiz.getDato() + "\t");
            preOrden(raiz.getIzq());
            preOrden(raiz.getDer());
        }
    }
    public void inOrden(Nodo raiz){
        if (raiz != null) {
            inOrden(raiz.getIzq());
            System.out.print(raiz.getDato() + "\t");
            inOrden(raiz.getDer());
        }
    }
    public void postOrden(Nodo raiz){
        if (raiz != null) {
            postOrden(raiz.getIzq());
            postOrden(raiz.getDer());
            System.out.print(raiz.getDato() + "\t");
        }
    }
}
