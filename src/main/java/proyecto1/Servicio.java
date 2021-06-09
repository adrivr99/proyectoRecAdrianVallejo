package main.java.proyecto1;

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

    public Servicio addServicio(Servicio servicio){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre del producto: ");
        String nombre = teclado.nextLine();
        servicio.setNombre(nombre);
        System.out.println("Introduce el precio:");
        String precioString = teclado.nextLine();
        double precio = Double.parseDouble(precioString);
        servicio.setPrecio(precio);
        System.out.println("Introduce la duración estimada:");
        String duracionString = teclado.nextLine();
        double duracion = Double.parseDouble(duracionString);
        servicio.setDuracionEstimada(duracion);
        System.out.println("Introduce la fecha de Inicio (yy-MM-dd)");
        String fechaIni = teclado.nextLine();
        LocalDate fechaInicio = LocalDate.parse(fechaIni);
        servicio.setFechaComienzo(fechaInicio);
        System.out.println("Introduce la fecha de Inicio (yy-MM-dd)");
        String fechaFin = teclado.nextLine();
        LocalDate fechaFinalizacion = LocalDate.parse(fechaFin);
        servicio.setFechaFin(fechaFinalizacion);
        return servicio;
    }

    @Override
    public String toString() {
        return super.toString() + ". Tipo Servicio, " + "duracionEstimada: " + duracionEstimada + ", fechaComienzo: " + fechaComienzo + ", fechaFin: " + fechaFin;
    }
}
