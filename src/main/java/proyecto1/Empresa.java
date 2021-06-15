package proyecto1;

import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private String CIF;
    private String direccion;
    private String ciudad;
    private String pais;
    private int telefono = 9;

    // Constructor sin parámetros
    public Empresa() {
    }

    // Constructor parametrizado
    public Empresa(String nombre, String CIF, String direccion, String ciudad, String pais, int telefono) {
        this.nombre = nombre;
        this.CIF = CIF;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.telefono = telefono;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "-----------------------------------------------------\n"
                + "\t\t\t\t" + nombre + "\n" + direccion + " " + ciudad + ", " + pais + "\nTel: " + telefono;
    }
}
