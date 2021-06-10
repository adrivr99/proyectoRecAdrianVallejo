package main.java.proyecto1;

public class Empresa {
    private String nombre;
    private String CIF;
    private String direccion;
    private String ciudad;
    private String pais;
    private int telefono = 9;

    public Empresa() {
        this.nombre = "Rocket Mouse";
        this.CIF = "B – 76365789";
        this.direccion = "Avenida España, 10";
        this.ciudad = "La Línea de la Concepción";
        this.pais = "España";
        this.telefono = 956202122;
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
        return  "-----------------------------------------------------\n" +
                "|\t\t\t\t" +nombre + "\n" + "|" + direccion + " " + ciudad + " " + pais +"\n|Tel: " + telefono;
    }
}
