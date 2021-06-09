package main.java.proyecto1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Pedido {
    private String numeroPedido;
    private Date fechaPedido;
    private String formaPago;
    private String envio;
    private String observaciones;
    private String cliente;
    private char[][] productos;
    private int cantidad;

    public Pedido(String numeroPedido, Date fechaPedido, String formaPago, String envio, String observaciones, String cliente, char[][] productos, int cantidad) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.formaPago = formaPago;
        this.envio = envio;
        this.observaciones = observaciones;
        this.cliente = cliente;
        this.productos = productos;
        this.cantidad = cantidad;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
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
