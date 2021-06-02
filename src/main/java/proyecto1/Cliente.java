package main.java.proyecto1;

public class Cliente {
    private String NIF;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String ciudad;
    private String pais;

    public Cliente() {
    }

    public Cliente(String NIF, String nombre, String apellidos, String direccion, String ciudad, String pais) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
    }


}
