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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Cliente: " + "NIF: " + NIF + ", nombre: " + nombre + ", apellidos: " + apellidos + ", direccion: "
                + direccion + ", ciudad: " + ciudad + ", pais: " + pais;
    }
}
