package proyecto2;

import java.util.List;
import model.*;

public class Empresa {

    private String nombre;
    private String CIF;
    private String direccion;
    private int telefono = 9;
    private List <Cliente> listaClientes;
    private List <Pedido> listaPedidos;
    private List <Producto> listaProductos;

    // Constructor sin parámetros
    public Empresa() {
    }

    // Constructor parametrizado


    public Empresa(String nombre, String CIF, String direccion, int telefono, List<Cliente> listaClientes, List<Pedido> listaPedidos, List<Producto> listaProductos) {
        this.nombre = nombre;
        this.CIF = CIF;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaClientes = listaClientes;
        this.listaPedidos = listaPedidos;
        this.listaProductos = listaProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "-----------------------------------------------------\n"
                + "\t\t\t\t" + nombre + "\n" + direccion + /*" " + ciudad + ", " + pais + */"\nTel: " + telefono;
    }
}
