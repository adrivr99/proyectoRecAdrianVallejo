package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPedido;

	private String direccionCliente;

	private boolean envio;

	@Temporal(TemporalType.DATE)
	private Date fechaPedido;

	private String formaPago;

	private String numeroPedido;
	
	private static int contador;

	//bi-directional many-to-one association to Listaproducto
	@OneToMany(mappedBy="pedido")
	private List<Listaproducto> listaproductos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente clienteBean;

	public Pedido() {
		contador++;
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getDireccionCliente() {
		return this.direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public boolean getEnvio() {
		return this.envio;
	}

	public void setEnvio(boolean envio) {
		this.envio = envio;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getNumeroPedido() {
		return this.numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public List<Listaproducto> getListaproductos() {
		return this.listaproductos;
	}

	public void setListaproductos(List<Listaproducto> listaproductos) {
		this.listaproductos = listaproductos;
	}

	public Listaproducto addListaproducto(Listaproducto listaproducto) {
		getListaproductos().add(listaproducto);
		listaproducto.setPedido(this);

		return listaproducto;
	}

	public Listaproducto removeListaproducto(Listaproducto listaproducto) {
		getListaproductos().remove(listaproducto);
		listaproducto.setPedido(null);

		return listaproducto;
	}

	public Cliente getClienteBean() {
		return this.clienteBean;
	}
	
	public Pedido asignarNumeroPedido(Pedido pedido) {
        pedido.setNumeroPedido(this.contador + "-" + LocalDate.now().getYear());
        return pedido;
    }

	public void setClienteBean(Cliente clienteBean) {
		this.clienteBean = clienteBean;
	}

	@Override
	public String toString() {
		/*StringBuilder builder = new StringBuilder();
		builder.append("Pedido [idPedido=");
		builder.append(idPedido);
		builder.append(", direccionCliente=");
		builder.append(direccionCliente);
		builder.append(", envio=");
		builder.append(envio);
		builder.append(", fechaPedido=");
		builder.append(fechaPedido);
		builder.append(", formaPago=");
		builder.append(formaPago);
		builder.append(", numeroPedido=");
		builder.append(numeroPedido);
		builder.append(", listaproductos=");
		builder.append(listaproductos);
		builder.append(", clienteBean=");
		builder.append(clienteBean);
		builder.append("]");
		return builder.toString();*/
		return "-----------------------------------------------------"
        + "\nNumero Pedido: " + numeroPedido
        + "\nFecha: " + fechaPedido + "\n"
        + "-----------------------------------------------------\n"
        + "Cliente: " + clienteBean.getNombre() + " " + clienteBean.getApellidos() + ", DNI:" + clienteBean.getNif()
        + "\nDireccion Cliente: " + clienteBean.getDireccion() + " \n"
        + "-----------------------------------------------------\n"
        + listaproductos.toString()
        + "\nForma de pago: " + formaPago
        + "\nEnvio: " + envio
        + "\n-----------------------------------------------------";
	}
	
	

}