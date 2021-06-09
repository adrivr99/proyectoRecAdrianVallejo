package main.java.proyecto1;

import java.util.Scanner;

public class Cliente {
    private String NIF;
    private String nombre;
    private String apellidos;
    private String direccion;

    public Cliente() {
    }

    public Cliente(String NIF, String nombre, String apellidos, String direccion) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cliente addCliente(Cliente cliente){
        Scanner teclado = new Scanner(System.in);
        String nif = leerNif();
        cliente.setNIF(nif);
        System.out.println("Introduce el nombre:");
        String nombre = teclado.nextLine();
        cliente.setNombre(nombre);
        System.out.println("Introduce los apellidos");
        String apellidos = teclado.nextLine();
        cliente.setApellidos(apellidos);
        System.out.println("Introduce la direccion (Calle, Número, Ciudad, País");
        String direccion = teclado.nextLine();
        cliente.setDireccion(direccion);
        return cliente;
    }

    public Cliente updateCliente(Cliente cliente){
        Scanner teclado = new Scanner(System.in);
        String nif = leerNif();
        cliente.setNIF(nif);
        System.out.println("Introduce el nombre:");
        String nombre = teclado.nextLine();
        cliente.setNombre(nombre);
        System.out.println("Introduce los apellidos");
        String apellidos = teclado.nextLine();
        cliente.setApellidos(apellidos);
        System.out.println("Introduce la direccion (Calle, Número, Ciudad, País");
        String direccion = teclado.nextLine();
        cliente.setDireccion(direccion);
        return cliente;
    }

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

    @Override
    public String toString() {
        return "----------------------------------------------------------------------------------------------------------------------------\n"+
                "Cliente: " + nombre + " " + apellidos + ", DNI:" + NIF + ", domicilio: " + direccion + " \n" +
                "----------------------------------------------------------------------------------------------------------------------------";
    }
}
