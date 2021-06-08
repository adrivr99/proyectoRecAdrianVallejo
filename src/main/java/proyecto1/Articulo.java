package main.java.proyecto1;

import java.time.LocalDate;

public class Articulo extends  Producto{
    private double peso;
    private LocalDate fechaFabricacion;

    public Articulo() {

    }

    public Articulo(double peso, LocalDate fechaFabricacion, int producto, String nombre, double precio) {
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

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    @Override
    public String toString() {
        return super.toString() + ". Tipo Articulo " + " peso: " + peso + ", fechaFabricacion: " + fechaFabricacion;
    }
}
