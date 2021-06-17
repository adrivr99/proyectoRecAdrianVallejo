package controladores;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Cliente;

public class ControladorCliente {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyectoRecAdrianVallejo");
	private EntityManager em;
	private Query consulta;
	
	public void createCliente(Cliente c) {
		// Usando el EntityManagerFactory creamos un objeto EntityManager
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// Se guarda el objeto en el contexto de persistencia (caché intermedia)
		// c es una entidad conectada
		this.em.persist(c);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public void borrarCliente(Cliente c) {
		this.em = entityManagerFactory.createEntityManager();
		Cliente aux = null;
		this.em.getTransaction().begin();
		// Si v no es un objeto gestionado por el contexto de persistencia
		if (!this.em.contains(c)) {
			// Carga c en el contexto de persistencia y se guarda en aux
			aux = this.em.merge(c);
		}
		// Ahora se puede borrar usando aux, porque es una entidad gestionada por la
		// caché
		this.em.remove(aux);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public void modifyCliente(Cliente c) {
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// merge(Objeto) - Si una entidad con el mismo identificador que v existe en el
		// contexto de persistencia (caché), se actualizan sus atributos y se devuelve
		// como entidad gestionada
		// Si el objeto v no existe en la base de datos, se comporta como persist() y la
		// entidad gestionada es la devuelta por merge(), por lo que v es una entidad desconectada
		this.em.merge(c);
		this.em.getTransaction().commit();
		this.em.close();

	}
	
	public Cliente findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Cliente aux = null;
		// Se crea el objeto Query a partir de una SQL nativa
		this.consulta = em.createNativeQuery("Select * from cliente where id = ?", Cliente.class);
		this.consulta.setParameter(1, pk);
		aux = (Cliente) consulta.getSingleResult();
		this.em.close();
		return aux;

	}
	
	public List<Cliente> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Cliente.findAll");
		List<Cliente> listaClientes = (List<Cliente>) consulta.getResultList();
		this.em.close();
		return listaClientes;
	}
}
