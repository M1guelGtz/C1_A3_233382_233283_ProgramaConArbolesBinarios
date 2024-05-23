import java.util.Scanner;
public class Recorrido {
    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato().getNombre()+ "\t en existencia: " + nodo.getDato().getCantidad() + " piezas");
            preorden(nodo.getIzq());
            preorden(nodo.getDer());
        }
    }
    
    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.getIzq());
            System.out.println(nodo.getDato().getNombre()+ " en existencia: " + nodo.getDato().getCantidad() + " piezas");
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
    public void añadirPiezas(Nodo nodo, int id){
        Scanner scanner = new Scanner(System.in);
        if (nodo != null) {
            if (nodo.getDato().getId()==id) {
                System.out.println("El producto ya existe, ¿desea añadir mas piezas? (1.-SI 2.-NO)");
                int opcion = scanner.nextInt();
                if (opcion == 1) {
                    System.out.println("¿cuantas piezas desea añadir?");
                    int cantidad = scanner.nextInt();
                    nodo.getDato().setCantidad( nodo.getDato().getCantidad() + cantidad); 
                }
            }
            preorden(nodo.getIzq());
            preorden(nodo.getDer());
        }
        
    }
}