package main.java.proyecto1;

import java.util.Date;

public class Servicio extends Producto {
    private int duracionEstimada;
    private Date fechaComienzo;
    private Date fechaFin;

    public Servicio() {

    }

    public Servicio(int duracionEstimada, Date fechaComienzo, Date fechaFin, int producto, String nombre, double precio) {
        super(producto, nombre, precio);
        this.duracionEstimada = duracionEstimada;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
    }

    public int getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public Date getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(Date fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo Servicio, " + "duracionEstimada: " + duracionEstimada + ", fechaComienzo: " + fechaComienzo + ", fechaFin: " + fechaFin;
    }
}
