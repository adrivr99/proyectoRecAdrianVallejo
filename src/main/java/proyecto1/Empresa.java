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

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", CIF='" + CIF + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", telefono=" + telefono;
    }
}
