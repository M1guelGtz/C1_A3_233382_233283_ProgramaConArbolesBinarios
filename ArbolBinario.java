import java.util.InputMismatchException;
import java.util.Scanner;

public class ArbolBinario {

    public  void main(String[] args) {
        visualizarMenu();
    }

    public void visualizarMenu() {
        int opc;
        Nodo raiz = null;
        Recorrido r = new Recorrido();
        do {
            System.out.println("\n----------------Menu--------------\n");
            System.out.println("1. Agregar nuevo producto\n2. Añadir existencia de producto\n3. Ver lista de Productos\n4. Salir");
            System.out.print("eleccion:");
            opc = decidirInt();
            switch (opc) {
                case 1:
                    raiz = agregarProducto(raiz);
                    break;
                case 2:
                    actualizarCantidad(raiz);
                    break;
                case 3:
                    if (raiz == null) {
                        System.out.println("El árbol está vacío.");
                    } else {
                        System.out.println("\n---------------Productos-------------\n");
                        r.preorden(raiz);
                        /*System.out.println("Inorden");
                        r.inorden(raiz);
                        System.out.println("Postorden");
                        r.postorden(raiz);*/
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    Archivo archivo=new Archivo();
                    archivo.escribirInformacion(raiz);
                    break;
                default:
                    System.out.println("\nSeleccione una opcion con su respectivo indice. \n");
            }
        } while (opc != 4);
    }

    public  Nodo agregarProducto(Nodo raiz) {
        int id, valor=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-------Ingrese los datos del Producto---------\n");
        do {
            if (valor>0) {
                System.out.println("debe ser un identificador de 3 digitos");
            }
            valor++;
            System.out.print("ID del producto:");
            id = decidirInt();
        } while (id < 100 || id > 999);
        Recorrido r = new Recorrido();
        r.añadirPiezas(raiz, id);
        if (r.evaluar()==0) {
            
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Piezas a añadir de " + nombre +  ": ");
            int cantidad = decidirInt();
            System.out.print("Ingrese el precio para " + nombre +  ": ");
            float precio = decidirFloat();
            
            Producto producto = new Producto(id, nombre, cantidad, precio);
            
            if (raiz == null) {
                return new Nodo(producto);
            } else {
                insertarNodo(raiz, producto);
            }
        }
        return raiz;
    }
    public void insertarNodo(Nodo nodo, Producto producto) {
        int direccion;
        do{
            System.out.println("¿Enviar el producto a la izquierda (1) o a la derecha (2) de " + nodo.getDato().getNombre() + "?");
            direccion = decidirInt();
        }while(direccion<1 || direccion > 2);
        
        if (direccion == 1) {
            if (nodo.getIzq() == null) {
                nodo.setIzq(new Nodo(producto));
            } else {
                insertarNodo(nodo.getIzq(), producto);
            }
        } else if (direccion == 2) { 
            if (nodo.getDer() == null) {
                nodo.setDer(new Nodo(producto));
            } else {
                insertarNodo(nodo.getDer(), producto);
            }
        }
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
        int eleccion, count=0;
        do{
            if (count>0) {
                System.out.println("¡no deben ser numeros negativos!");
                System.out.print("vuelva a introducir: ");
            }
            count++; 
            eleccion = entrada.nextInt();
        }while(eleccion<=0);
        return eleccion;
    }
    public void actualizarCantidad(Nodo raiz){
        Recorrido r = new Recorrido();
        System.out.println("Ingrese id del Producto;");
        int id = decidirInt();
        r.añadirPiezas(raiz, id);
    }
    public float decidirFloat(){
        float indice = 0;
        boolean excepcion = true;
        do{
            try{
                indice = validarEleccionF();
                excepcion = false;
            }catch(InputMismatchException e){
                System.out.println("\n¡opcion erronea, debe introducir un numero entero!\n");
                System.out.print("Vuelva a introducir la opcion: ");
            }
            
        }while(excepcion);
        
        return indice;
    } 
    public float validarEleccionF() throws InputMismatchException{
        Scanner entrada = new Scanner(System.in);
        int count=0;
        Float eleccion;
        do{
            if (count>0) {
                System.out.println("¡no deben ser numeros negativos!");
                System.out.print("vuelva a introducir: ");
            }
            count++; 
            eleccion = entrada.nextFloat();
        }while(eleccion<=0);
        return eleccion;
    }
}