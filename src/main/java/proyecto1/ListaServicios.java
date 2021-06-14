package main.java.proyecto1;

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

    public String toString() {
        return  "\n" +servicio.getNombre() + " x " + servicio.getPrecio() + "€. Cantidad: " + cantidad + " uds." +
                "\n-----------------------------------------------------\n";
    }
}
