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
    private Empresa empresa;
    private String formaPago;
    private String direccionCliente; //
    private boolean envio;
    private String observaciones;
    private String cliente; //
    private char[][] productos;
    private int cantidad;
    private static int contador = 0;

    public Pedido() {
        contador++;
    }

    public Pedido(String numeroPedido, LocalDate fechaPedido, Empresa empresa,
                  String formaPago, String direccionCliente, boolean envio,
                  String observaciones, String cliente, char[][] productos, int cantidad) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.empresa = empresa;
        this.formaPago = formaPago;
        this.direccionCliente = direccionCliente;
        this.envio = envio;
        this.observaciones = observaciones;
        this.cliente = cliente;
        this.productos = productos;
        this.cantidad = cantidad;
        contador++;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public boolean isEnvio() {
        return envio;
    }

    public void setEnvio(boolean envio) {
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

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Pedido.contador = contador;
    }

    public Pedido asignarNumeroPedido(Pedido pedido){
        pedido.setNumeroPedido(this.contador+ "/" + LocalDate.now().getYear());
        return pedido;
    }


    @Override
    public String toString() {
        if (envio == true){
            return
                    empresa +
                            "\n------------------------------------------------"+
                            "\n\t\t\tFecha:" + fechaPedido +
                            "\nCLiente: " + cliente + "\t\t\t" + numeroPedido +
                            "\nDireccion Cliente: " + envio +
                            "\nForma de pago: " + formaPago +
                            "\nDireccion de envio: " + envio +
                            "\nEnvio: " + "Si [X]\t No [ ]" +
                            "\n------------------------------------------------";
        } else if (envio == false){
            return
                    empresa +
                            "\n------------------------------------------------"+
                            "\n\t\t\tFecha:" + fechaPedido +
                            "\nCLiente: " + cliente + "\t\t\t" + numeroPedido +
                            "\nDireccion Cliente: " + envio +
                            "\nForma de pago: " + formaPago +
                            "\nDireccion de envio: " + envio +
                            "\nObservaciones: " + observaciones +
                            "\n------------------------------------------------";
        }

    }
        /*return "Pedido{" +
                "numeroPedido='" + numeroPedido + '\'' +
                ", fechaPedido=" + fechaPedido +
                ", formaPago='" + formaPago + '\'' +
                ", envio='" + envio + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", cliente='" + cliente + '\'' +
                ", productos=" + Arrays.toString(productos) +
                ", cantidad=" + cantidad +
                '}';
    }*/
}
