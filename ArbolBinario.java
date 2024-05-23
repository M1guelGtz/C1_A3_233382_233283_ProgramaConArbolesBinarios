import java.util.Scanner;

public class ArbolBinario {
    public void visualizarMenu(){
        int opc, valor;
        String nombre;
        Scanner scanner = new Scanner(System.in);
        Nodo raiz= new Nodo();
        do {
            System.out.println("");
            System.out.println("1. Agregar Producto\n2. Imprimir recorrido\n3. ver total de nodos");
            opc=scanner.nextInt();
            switch (opc) {
                case 1:
                    Producto objetoProducto = new Producto();
                    System.out.print("Nombre del Producto: ");
                    nombre=scanner.nextLine();
                    nombre=scanner.nextLine();
                    objetoProducto.setNombre(nombre);
                    int count=0;
                    do{
                        if (count>0) {
                            System.out.println("\n-------Debe ser un codigo de 3 digitos--------\n");
                        }
                        count++;
                        System.out.print("Codigo de Producto: ");
                        valor = scanner.nextInt();
                        
                    }while(valor<99 || valor > 1000);
                    objetoProducto.setCodigo(valor);
                    System.out.print("Agregue un Precio Para " + objetoProducto.getNombre() + ":");
                    Float Precio = scanner.nextFloat();
                    objetoProducto.setPrecio(Precio);
                    System.out.print("¿cuantas Piezas desea añadir?");
                    valor=scanner.nextInt();
                    objetoProducto.setExistencia(valor);
                    raiz.setDato(objetoProducto);
                    crearArbol(raiz);
                    break;
                case 2:
                    Recorrido r= new Recorrido();
                    System.out.println("Pre-orden");
                    r.preOrden(raiz);
                    System.out.println("");
                    System.out.println("In-orden");
                    r.inOrden(raiz);
                    System.out.println("");
                    System.out.println("Post-orden");
                    r.postOrden(raiz);
                    break;
                case 3:
                    int total = calcularTotal(raiz);
                    System.out.println("el total es: " + total);
                    break;
                default:
                    break;
            }
        } while (opc<4);
    }

    public void crearArbol(Nodo nodo){
        int valor, respuesta;
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Existe nodo por por la izquierda de "+ nodo.getDato().getNombre()+":(1)SI (2)NO?");
        respuesta = scanner.nextInt();

        if (respuesta==1) {
            System.out.print("Ingrese el valor del nodo: ");
            valor = scanner.nextInt();
            /*Nodo subizq = new Nodo (valor); 
            nodo.setIzq(subizq);
            crearArbol(subizq);*/
        }
        System.out.println("¿Existe nodo por la derecha de "+ nodo.getDato()+":(1)SI (2)NO?");
        respuesta = scanner.nextInt();

        if (respuesta==1) {
            System.out.print("Ingrese le valor del nodo:");
            valor = scanner.nextInt();
            /*Nodo subder = new Nodo (valor); 
            nodo.setDer(subder);
            crearArbol(subder);*/
        }
    }
    public int calcularTotal (Nodo raiz) {
        if (raiz != null) {
            return 1 + calcularTotal(raiz.getIzq()) + calcularTotal(raiz.getDer());
        }
        else{
            return 0;
        }
    }
}
