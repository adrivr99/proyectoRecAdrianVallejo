package main.java.proyecto1;

import java.util.Date;

public class Pedido {
    private int numeroPedido;
    private Date fechaPedido;
    private String formaPago;
    private String envio;
    private String observaciones;

    public Pedido(int numeroPedido, Date fechaPedido, String formaPago, String envio, String observaciones) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.formaPago = formaPago;
        this.envio = envio;
        this.observaciones = observaciones;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
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

    @Override
    public String toString() {
        return "Pedido " +
                "numeroPedido: " + numeroPedido + ", fechaPedido: " + fechaPedido + ", formaPago: " + formaPago
                + ", envio: " + envio + ", observaciones: " + observaciones;
    }
}
