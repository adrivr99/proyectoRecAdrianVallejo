package proyecto2;

import java.util.ArrayList;

public class ListaServicios {

    private Servicio servicio;
    private int cantidad;

    public ListaServicios() {
    }

    public ListaServicios(Servicio servicio, int cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Metodo para a�adir un servicio de la Lista de Servicios dentros de la listaPedidosServicios
    // Para ello se selecciona el producto por su id y se pasa al metodo como parametro
    // para un vez listado el array, se selecione el servicio que tiene ese id
    public Servicio addServicioLista(ArrayList<Servicio> listaServicios, int elegirProducto) {
        for (int i = 0; i < listaServicios.size(); i++) {
            if (listaServicios.get(i).getProducto() == elegirProducto) {
                return listaServicios.get(i);
            }
        }
        return null;
    }

    public String toString() {
        return "\n" + servicio.getNombre() + " x " + servicio.getPrecio() + "€. Cantidad: " + cantidad + " uds."
                + "\n-----------------------------------------------------\n";
    }
}
