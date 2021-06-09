package main.java.proyecto1;

import java.time.LocalDate;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class Articulo extends  Producto{
    private double peso;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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

    public Articulo addArticulo(Articulo articulo){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre del producto: ");
        String nombre = teclado.nextLine();
        articulo.setNombre(nombre);
        System.out.println("Introduce el precio:");
        String precioString = teclado.nextLine();
        double precio = Double.parseDouble(precioString);
        articulo.setPrecio(precio);
        System.out.println("Introduce el peso:");
        String pesoString = teclado.nextLine();
        double peso = Double.parseDouble(pesoString);
        articulo.setPeso(peso);
        System.out.println("Introduce la fecha de fabricacion (yy-MM-dd)");
        String fechaString = teclado.nextLine();
        LocalDate fechaFabricacion = LocalDate.parse(fechaString);
        articulo.setFechaFabricacion(fechaFabricacion);
        return articulo;
    }

    @Override
    public String toString() {
        return super.toString() + ". Tipo Articulo " + " peso: " + peso + ", fechaFabricacion: " + fechaFabricacion;
    }
}
