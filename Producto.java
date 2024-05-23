public class Producto {
    private int id;
    private String nombre;
    private int cantidad;
    private float precio;
    
    public Producto(int id, String n, int c, float p){
        this.id=id;
        this.nombre=n;
        this.cantidad=c;
        this.precio=p;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}

