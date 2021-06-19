package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int producto;

	private double duracion;

	@Temporal(TemporalType.DATE)
	private Date fechaFabricacion;

	@Temporal(TemporalType.DATE)
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	private String nombre;

	private double peso;

	private double precio;

	private boolean tipo;

	//bi-directional many-to-one association to Listaproducto
	@OneToMany(mappedBy="productoBean")
	private List<Listaproducto> listaproductos;

	public Producto() {
	}

	public int getProducto() {
		return this.producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public double getDuracion() {
		return this.duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public Date getFechaFabricacion() {
		return this.fechaFabricacion;
	}

	public void setFechaFabricacion(Date fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean getTipo() {
		return this.tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public List<Listaproducto> getListaproductos() {
		return this.listaproductos;
	}

	public void setListaproductos(List<Listaproducto> listaproductos) {
		this.listaproductos = listaproductos;
	}

	public Listaproducto addListaproducto(Listaproducto listaproducto) {
		getListaproductos().add(listaproducto);
		listaproducto.setProductoBean(this);

		return listaproducto;
	}

	public Listaproducto removeListaproducto(Listaproducto listaproducto) {
		getListaproductos().remove(listaproducto);
		listaproducto.setProductoBean(null);

		return listaproducto;
	}

	@Override
	public String toString() {
		/*StringBuilder builder = new StringBuilder();
		builder.append("Producto [producto=");
		builder.append(producto);
		builder.append(", duracion=");
		builder.append(duracion);
		builder.append(", fechaFabricacion=");
		builder.append(fechaFabricacion);
		builder.append(", fechaFin=");
		builder.append(fechaFin);
		builder.append(", fechaInicio=");
		builder.append(fechaInicio);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", peso=");
		builder.append(peso);
		builder.append(", precio=");
		builder.append(precio);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", listaproductos=");
		builder.append(listaproductos);
		builder.append("]");
		return builder.toString();*/
		return "Producto: " + producto + ", nombre: " + nombre + ", precio: " + precio;
		
	}
	
	

}