import java.util.InputMismatchException;
import java.util.Scanner;
public class Recorrido {
    int cantidad = 0;
    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.println("Id: " + nodo.getDato().getId() + "\t  Nombre: " + nodo.getDato().getNombre()+ "\t en existencia: " + nodo.getDato().getCantidad() + " piezas \t  Precio: $" + nodo.getDato().getPrecio());
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
        }
    }
    public void añadirPiezas(Nodo nodo, int id){
        int opcion;
        if (nodo != null) {
            if (nodo.getDato().getId()==id) {
                System.out.println("El producto existe, ¿desea añadir mas piezas? (1.-SI 2.-NO)");
                opcion = decidirInt();
                if (opcion == 1) {
                    System.out.println("¿cuantas piezas desea añadir?");
                    cantidad = decidirInt();
                    nodo.getDato().setCantidad( nodo.getDato().getCantidad() + cantidad); 
                }
                cantidad = 1;
            }else{
                System.out.println("Id unico");
            }
            añadirPiezas(nodo.getIzq(), id);
            añadirPiezas(nodo.getDer(), id);
        }
    }
    public int evaluar(){
        return cantidad;
    }
    public int decidirInt(){
        int indice = 0;
        boolean excepcion = true;
        do{
            try{
                indice = validarEleccion();
                excepcion = false;
            }catch(InputMismatchException e){
                System.out.println("\n¡opcion erronea, debe introducir un numero entero!\n");
                System.out.print("Vuelva a introducir la opcion: ");
            }
            
        }while(excepcion);
        
        return indice;
    } 
    public int validarEleccion() throws InputMismatchException{
        Scanner entrada = new Scanner(System.in);
        int eleccion, count =0 ;
        do{
            if (count>0) {
                System.out.println("¡no deben ser numeros negativos!");
            }
            count++; 
            eleccion = entrada.nextInt();
        }while(eleccion<=0);
        return eleccion;
    }
}