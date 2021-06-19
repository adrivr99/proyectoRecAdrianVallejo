package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Listaproducto;

public class ControladorListaProducto {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyectoRecAdrianVallejo");
	private EntityManager em;
	private Query consulta;
	
	public void createListaProducto(Listaproducto lp) {
		// Usando el EntityManagerFactory creamos un objeto EntityManager
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// Se guarda el objeto en el contexto de persistencia (caché intermedia)
		// lp es una entidad conectada
		this.em.persist(lp);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public void borrarListaProducto(Listaproducto lp) {
		this.em = entityManagerFactory.createEntityManager();
		Listaproducto aux = null;
		this.em.getTransaction().begin();
		// Si lp no es un objeto gestionado por el contexto de persistencia
		if (!this.em.contains(lp)) {
			// Carga c en el contexto de persistencia y se guarda en aux
			aux = this.em.merge(lp);
		}
		// Ahora se puede borrar usando aux, porque es una entidad gestionada por la
		// caché
		this.em.remove(aux);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public void modifyListaProducto(Listaproducto lp) {
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// merge(Objeto) - Si una entidad con el mismo identificador que lp existe en el
		// contexto de persistencia (caché), se actualizan sus atributos y se devuelve
		// como entidad gestionada
		// Si el objeto lp no existe en la base de datos, se comporta como persist() y la
		// entidad gestionada es la devuelta por merge(), por lo que v es una entidad desconectada
		this.em.merge(lp);
		this.em.getTransaction().commit();
		this.em.close();

	}
	
	public Listaproducto findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Listaproducto aux = null;
		// Se crea el objeto Query a partir de una SQL nativa
		this.consulta = em.createNativeQuery("Select * from cliente where id = ?", Listaproducto.class);
		this.consulta.setParameter(1, pk);
		aux = (Listaproducto) consulta.getSingleResult();
		this.em.close();
		return aux;

	}
	
	public List<Listaproducto> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Listaproducto.findAll");
		List<Listaproducto> listaClientes = (List<Listaproducto>) consulta.getResultList();
		this.em.close();
		return listaClientes;
	}
}
