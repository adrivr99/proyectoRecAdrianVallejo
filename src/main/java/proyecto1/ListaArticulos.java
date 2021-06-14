package main.java.proyecto1;

public class ListaArticulos {
    private Articulo articulo;
    private int cantidad;

    public ListaArticulos() {
    }

    public ListaArticulos(Articulo articulo, int cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String toString() {
        return  "\n" +articulo.getNombre() + " x " + articulo.getPrecio() + "€. Cantidad: " + cantidad + " uds." +
                "\n-----------------------------------------------------\n";
    }
}
