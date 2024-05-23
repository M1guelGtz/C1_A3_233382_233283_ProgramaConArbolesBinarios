public class Nodo{
    private Producto dato;
    private Nodo der, izq;

    public Nodo(){}
    public Nodo( Producto Dato){this.dato = Dato;}

    public Producto getDato() { return dato; }
    public void setDato(Producto dato) { this.dato = dato; }
    public Nodo getDer() { return der; }
    public void setDer(Nodo der) { this.der = der; }
    public Nodo getIzq() { return izq; }
    public void setIzq(Nodo izq) { this.izq = izq; }
}