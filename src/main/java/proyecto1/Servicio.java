package main.java.proyecto1;

import java.time.LocalDate;

public class Servicio extends Producto {
    private double duracionEstimada; // horas
    private LocalDate fechaComienzo;
    private LocalDate fechaFin;

    public Servicio() {

    }

    public Servicio(double duracionEstimada, LocalDate fechaComienzo, LocalDate fechaFin, int producto, String nombre, double precio) {
        super(producto, nombre, precio);
        this.duracionEstimada = duracionEstimada;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
    }

    public double getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(double duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public LocalDate getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(LocalDate fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return super.toString() + ". Tipo Servicio, " + "duracionEstimada: " + duracionEstimada + ", fechaComienzo: " + fechaComienzo + ", fechaFin: " + fechaFin;
    }
}
