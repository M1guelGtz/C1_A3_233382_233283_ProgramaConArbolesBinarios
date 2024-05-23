import java.io.FileWriter;
import java.io.PrintWriter;

public class Archivo {
    public void escribirInformacion( Nodo nodo) {
        try (FileWriter fichero = new FileWriter("Productos.txt"))
        {
            PrintWriter pw = new PrintWriter(fichero);
            if (nodo != null) {
                if (nodo.getDato().getCantidad()>5) {
                    pw.println("Id: " + nodo.getDato().getId() + "\t  Nombre: " + nodo.getDato().getNombre()+ "\t en existencia: " + nodo.getDato().getCantidad() + " piezas \t  Precio: $" + nodo.getDato().getPrecio());
                    escribirInformacion(nodo.getIzq());
                    escribirInformacion(nodo.getDer());
                }
                else{
                    pw.println("menor a 5");
                    escribirInformacion(nodo.getIzq());
                    escribirInformacion(nodo.getDer());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 

    }
}
