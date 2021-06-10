package main.java.proyecto1;

import java.util.ArrayList;

public class ListaProductos {
    private Producto producto;
    private int cantidad;

    public ListaProductos() {
    }

    public ListaProductos(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return  "\n" +producto.getNombre() + " x " + producto.getPrecio() + "€. Cantidad: " + cantidad + " uds." +
                "\n-----------------------------------------------------\n";
    }
}
