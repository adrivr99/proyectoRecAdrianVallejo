package main.java.proyecto1;

import java.util.ArrayList;

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

    // Método para añadir un artículo de la Lista de Articulos dentros de la listaPedidosArticulos
    // Para ello se selecciona el producto por su id y se pasa al método como parametro
    // para un vez listado el array, se selecione el articulo que tiene ese id
    public Articulo addArticuloLista (ArrayList<Articulo> listaArticulos, int elegirProducto){
        for (int i = 0; i < listaArticulos.size(); i++) {
            if (listaArticulos.get(i).getProducto() == elegirProducto){
                return  listaArticulos.get(i);
            }
        }
        return null;
    }

    public String toString() {
        return  "\n" +articulo.getNombre() + " x " + articulo.getPrecio() + "€. Cantidad: " + cantidad + " uds." +
                "\n-----------------------------------------------------\n";
    }
}
