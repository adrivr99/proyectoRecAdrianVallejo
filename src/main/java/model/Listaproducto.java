package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the listaproductos database table.
 * 
 */
@Entity
@Table(name="listaproductos")
@NamedQuery(name="Listaproducto.findAll", query="SELECT l FROM Listaproducto l")
public class Listaproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int cantidad;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="idPedido")
	private Pedido pedido;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="producto")
	private Producto productoBean;

	public Listaproducto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProductoBean() {
		return this.productoBean;
	}

	public void setProductoBean(Producto productoBean) {
		this.productoBean = productoBean;
	}

	@Override
	public String toString() {
		/*StringBuilder builder = new StringBuilder();
		builder.append("Listaproducto [id=");
		builder.append(id);
		builder.append(", cantidad=");
		builder.append(cantidad);
		builder.append(", pedido=");
		builder.append(pedido.getIdPedido());
		builder.append(", productoBean=");
		builder.append(productoBean.getProducto());
		builder.append("]");
		return builder.toString();*/
		return "\nIdPedido: " + id + " " + productoBean.getNombre() + " x " + productoBean.getPrecio() + "�� Cantidad: " + cantidad + " uds."
        + "\n-----------------------------------------------------\n";
	}
	
	

}