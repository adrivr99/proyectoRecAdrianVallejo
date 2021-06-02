package main.java.proyecto1;

import java.util.Date;

public class Articulo extends  Producto{
    private double peso;
    private Date fechaFabricacion;

    public Articulo() {

    }

    public Articulo(double peso, Date fechaFabricacion, int producto, String nombre, double precio) {
        super(producto, nombre, precio);
        this.peso = peso;
        this.fechaFabricacion = fechaFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo Articulo " + " peso: " + peso + ", fechaFabricacion: " + fechaFabricacion;
    }
}
