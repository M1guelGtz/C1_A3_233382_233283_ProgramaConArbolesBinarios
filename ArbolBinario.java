import java.util.Scanner;

public class ArbolBinario {

    public static void main(String[] args) {
        visualizarMenu();
    }

    public static void visualizarMenu() {
        int opc;
        Scanner scanner = new Scanner(System.in);
        Nodo raiz = null;
        do {
            System.out.println("1. Agregar producto\n2. Actualizar cantidad de producto\n3. Imprimir recorrido\n4. Salir");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    raiz = agregarProducto(raiz);
                    break;
                case 2:
                    //actualizar
                    break;
                case 3:
                    if (raiz == null) {
                        System.out.println("El árbol está vacío.");
                    } else {
                        Recorrido r = new Recorrido();
                        System.out.println("Preorden");
                        r.preorden(raiz);
                        System.out.println("Inorden");
                        r.inorden(raiz);
                        System.out.println("Postorden");
                        r.postorden(raiz);
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (opc != 4);
    }

    public static Nodo agregarProducto(Nodo raiz) {
        int id;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ingrese el ID del producto (3 dígitos):");
            id = scanner.nextInt();
        } while (id < 100 || id > 999);
        scanner.nextLine();
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la cantidad del producto:");
        int cantidad = scanner.nextInt();
        System.out.println("Ingrese el precio del producto:");
        float precio = scanner.nextFloat();
        
        Producto producto = new Producto(id, nombre, cantidad, precio);
        
        if (raiz == null) {
            return new Nodo(producto);
        } else {
            insertarNodo(raiz, producto);
        }
        return raiz;
    }

    public static void insertarNodo(Nodo nodo, Producto producto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Enviar el producto a la izquierda (1) o a la derecha (2) del nodo con ID " + nodo.getDato().getId() + "?");
        int direccion = scanner.nextInt();
        
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
}