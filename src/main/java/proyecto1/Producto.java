package proyecto1;

public class Producto {

    private int producto;
    private String nombre;
    private double precio;

    public Producto(int producto, String nombre, double precio) {
        this.producto = producto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto() {
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto: " + producto + ", nombre: " + nombre + ", precio: " + precio;
    }
}
