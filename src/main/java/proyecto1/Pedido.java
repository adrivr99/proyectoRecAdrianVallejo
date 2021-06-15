package proyecto1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
    private Cliente cliente; //

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Pedido.contador = contador;
    }

    // M�todo para asignar un n�mero de pedido al pedido con un contador de instancias
    public Pedido asignarNumeroPedido(Pedido pedido) {
        pedido.setNumeroPedido(this.contador + "-" + LocalDate.now().getYear());
        return pedido;
    }

    // M�todo para introducir un nif de un cliente
    private static String leerNif() {
        Scanner teclado = new Scanner(System.in);
        String nif = null;
        boolean entrada;
        do {
            System.out.println("Introduce el NIF");
            String texto = teclado.next();
            if (texto.length() == 9) {
                nif = texto;
                entrada = true;
            } else {
                System.out.println("Debes introducir 8 letras y un caracter");
                entrada = false;
            }

        } while (!entrada);
        return nif;
    }

    // Método para asignar un cliente al pedido
    public Cliente asignarCliente(ArrayList<Cliente> listaCliente, String nif) {
        for (Cliente cliente : listaCliente) {
            if (cliente.getNIF().equalsIgnoreCase(nif)) {
                return cliente;
            }
        }
        return null;
    }

    // Método para asignar la direccion de cliente al pedido
    public String asignarDireccionCliente(ArrayList<Cliente> listaCliente, Pedido pedido) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getNIF().equalsIgnoreCase(String.valueOf(pedido.getCliente().getNIF()))) {
                pedido.setDireccionCliente(listaCliente.get(i).getDireccion());
                return pedido.getDireccionCliente();
            }
        }
        return null;
    }

    // Método para asignar el metodo de pago al pedido
    public String asignarPago(String metodoPago) {
        if (metodoPago.equalsIgnoreCase("transferencia") || metodoPago.equalsIgnoreCase("tarjeta")) {
            return metodoPago;
        } else {
            return null;
        }
    }

    // Método booleano que devolverá true o false para asignar si el pedido será enviado (true)
    // o si será recogido en tienda (false)
    public boolean asignarEnvio(int envio) {
        boolean envioBoolean = false;
        if (envio == 1) {
            envioBoolean = false;
            return envioBoolean;
        } else if (envio == 2) {
            envioBoolean = true;
            return envioBoolean;
        }
        return envioBoolean;
    }

    @Override
    public String toString() {
        return empresa
                + "\n-----------------------------------------------------"
                + "\nNumero Pedido: " + numeroPedido
                + "\nFecha: " + fechaPedido + "\n"
                + cliente
                + listaArticulos
                + listaServicios
                + "\nForma de pago: " + formaPago
                + "\nEnvio: " + envio
                + "\n-----------------------------------------------------";

    }
}
