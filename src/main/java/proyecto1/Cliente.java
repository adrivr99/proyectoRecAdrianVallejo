package main.java.proyecto1;

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

    @Override
    public String toString() {
        return "----------------------------------------------------------------------------------------------------------------------------\n"+
                "Cliente: " + nombre + " " + apellidos + ", DNI:" + NIF + ", domicilio: " + direccion + " \n" +
                "----------------------------------------------------------------------------------------------------------------------------";
    }
}
