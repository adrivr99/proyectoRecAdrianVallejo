package main.java.proyecto1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Pedido {
    private String numeroPedido; //
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaPedido; //
    private Empresa empresa; //
    private String formaPago; //
    private String direccionCliente; //
    private boolean envio; //
    private ArrayList<ListaArticulos> listaArticulos;
    private ArrayList<ListaServicios> listaServicios;
    private String cliente; //

    private static int contador = 0;

    public Pedido() {
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

    public ArrayList<ListaArticulos> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<ListaArticulos> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public ArrayList<ListaServicios> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<ListaServicios> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Pedido.contador = contador;
    }

    public Pedido asignarNumeroPedido(Pedido pedido){
        pedido.setNumeroPedido(this.contador+ "-" + LocalDate.now().getYear());
        return pedido;
    }


    @Override
    public String toString() {
            return
                empresa +
                "\n-----------------------------------------------------"+
                "\n\t\t\tFecha:" + fechaPedido +
                "\nCLiente: " + cliente + "\t\t\t" + numeroPedido +
                "\nDireccion Cliente: " + direccionCliente +
                "\n-----------------------------------------------------\n" +
                listaArticulos +
                listaServicios +
                "\nForma de pago: " + formaPago +
                "\nEnvio: " + envio +
                "\n-----------------------------------------------------";

    }
}
