package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Producto;

public class ControladorProducto {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyectoRecAdrianVallejo");
	private EntityManager em;
	private Query consulta;
	
	public void createProducto(Producto p) {
		// Usando el EntityManagerFactory creamos un objeto EntityManager
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// Se guarda el objeto en el contexto de persistencia (caché intermedia)
		// p es una entidad conectada
		this.em.persist(p);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public void borrarProducto(Producto p) {
		this.em = entityManagerFactory.createEntityManager();
		Producto aux = null;
		this.em.getTransaction().begin();
		// Si p no es un objeto gestionado por el contexto de persistencia
		if (!this.em.contains(p)) {
			// Carga v en el contexto de persistencia y se guarda en aux
			aux = this.em.merge(p);
		}
		// Ahora se puede borrar usando aux, porque es una entidad gestionada por la
		// caché
		this.em.remove(aux);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public void modifyProducto(Producto p) {
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// merge(Objeto) - Si una entidad con el mismo identificador que p existe en el
		// contexto de persistencia (caché), se actualizan sus atributos y se devuelve
		// como entidad gestionada
		// Si el objeto p no existe en la base de datos, se comporta como persist() y la
		// entidad gestionada es la devuelta por merge(), por lo que v es una entidad desconectada
		this.em.merge(p);
		this.em.getTransaction().commit();
		this.em.close();

	}
	
	public Producto findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Producto aux = null;
		// Se crea el objeto Query a partir de una SQL nativa
		this.consulta = em.createNativeQuery("Select * from producto where id = ?", Producto.class);
		this.consulta.setParameter(1, pk);
		aux = (Producto) consulta.getSingleResult();
		this.em.close();
		return aux;

	}
	
	public List<Producto> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Producto.findAll");
		List<Producto> listaProductos = (List<Producto>) consulta.getResultList();
		this.em.close();
		return listaProductos;
	}
	
}
