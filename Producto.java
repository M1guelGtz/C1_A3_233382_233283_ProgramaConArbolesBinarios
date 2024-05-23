public class Producto {
    Producto(){}
    private int Codigo;
    private String Nombre;
    private int Existencia;
    private float precio;

    public int getCodigo() {    return Codigo;  }
    public void setCodigo(int codigo) {     Codigo = codigo;    }

    public String getNombre() {     return Nombre;  }
    public void setNombre(String nombre) {  Nombre = nombre;    }

    public int getExistencia() {    return Existencia;    }
    public void setExistencia(int existencia) {    Existencia = existencia;    }

    public float getPrecio() {    return precio;    }
    public void setPrecio(float precio) {    this.precio = precio;  }
    
}
