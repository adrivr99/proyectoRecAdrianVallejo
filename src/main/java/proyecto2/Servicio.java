package proyecto2;

import java.time.LocalDate;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class Servicio extends Producto {

    private double duracionEstimada; // horas
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaComienzo;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
