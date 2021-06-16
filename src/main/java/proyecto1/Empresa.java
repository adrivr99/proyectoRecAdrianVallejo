package proyecto1;

import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private String CIF;
    private String direccion;
    private int telefono = 9;
    private ArrayList <Cliente> listaClientes;
    private ArrayList <Pedido> listaPedidos;
    private ArrayList <Producto> listaProductos;

    // Constructor sin parámetros
    public Empresa() {
    }

    // Constructor parametrizado


    public Empresa(String nombre, String CIF, String direccion, int telefono, ArrayList<Cliente> listaClientes, ArrayList<Pedido> listaPedidos, ArrayList<Producto> listaProductos) {
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

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
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
