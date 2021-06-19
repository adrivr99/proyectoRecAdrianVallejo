package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;

	private String apellidos;

	private String direccion;

	private String nif;

	private String nombre;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="clienteBean")
	private List<Pedido> pedidos;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setClienteBean(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setClienteBean(null);

		return pedido;
	}

	@Override
	public String toString() {
		/*StringBuilder builder = new StringBuilder();
		builder.append("Cliente [idCliente=");
		builder.append(idCliente);
		builder.append(", apellidos=");
		builder.append(apellidos);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", nif=");
		builder.append(nif);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", pedidos=");
		builder.append(pedidos);
		builder.append("]");
		return builder.toString();*/
		return "-----------------------------------------------------\n"
        + "ID Cliente: " + idCliente + ". Cliente: " + nombre + " " + apellidos + ", DNI:" + nif
        + "\nDireccion Cliente: " + direccion + " \n"
        + "-----------------------------------------------------\n";
	}
	
	

}