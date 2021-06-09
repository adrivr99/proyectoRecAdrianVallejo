package main.java.proyecto1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Pedido {
    private String numeroPedido; //
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaPedido; //
    private String formaPago;
    private String envio; //
    private String observaciones;
    private String cliente; //
    private char[][] productos;
    private int cantidad;
    private int contador = 1;

    public Pedido() {
    }

    public Pedido(String numeroPedido, LocalDate fechaPedido, String formaPago, String envio, String observaciones, String cliente, char[][] productos, int cantidad) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.formaPago = formaPago;
        this.envio = envio;
        this.observaciones = observaciones;
        this.cliente = cliente;
        this.productos = productos;
        this.cantidad = cantidad;
        ++contador;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public char[][] getProductos() {
        return productos;
    }

    public void setProductos(char[][] productos) {
        this.productos = productos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Pedido asignarNumeroPedido(Pedido pedido){
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy");
        LocalDate fecha = LocalDate.now();
        String anio = sdf.format(fecha);
        pedido.setNumeroPedido(pedido.getContador()+ "/" + anio);
        return pedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido='" + numeroPedido + '\'' +
                ", fechaPedido=" + fechaPedido +
                ", formaPago='" + formaPago + '\'' +
                ", envio='" + envio + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", cliente='" + cliente + '\'' +
                ", productos=" + Arrays.toString(productos) +
                ", cantidad=" + cantidad +
                '}';
    }
}
