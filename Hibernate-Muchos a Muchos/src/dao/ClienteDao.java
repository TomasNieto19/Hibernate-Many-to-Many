package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;


public class ClienteDao {
	private static Session session;
	private Transaction tx;
	private static ClienteDao instancia = null; 

	
	// PATRON DE DISE�O SINGLETON.
	
	
	protected ClienteDao() {}

	
	public static ClienteDao getInstance() {
		if (instancia == null)
			instancia = new ClienteDao();
		return instancia;
	}

	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	
	// ABM.
	
	
	public int agregar(Cliente objeto) {
		
		int id = 0;

		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	
	public void actualizar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	
	public void eliminar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	
	// TRAER.
	
	
	public Cliente traer(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.get(Cliente.class, idCliente);
		} finally {
			session.close();
		}
		return objeto;
	}

	
	public Cliente traer(int dni) throws HibernateException {

		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.dni=" + dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	
	@SuppressWarnings("unchecked")
	public List<Cliente> traer() throws HibernateException {
		
		List<Cliente> lista = null;
		
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente c order by c.id").list();
		} finally {
			session.close();
		}
		
		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Cliente> traer(boolean baja) throws HibernateException {
		
		List<Cliente> lista = null;
		
		try {
			
			iniciaOperacion();
			lista = session.createQuery("from Cliente c where c.baja = " + baja).list();
			
		} finally {
			session.close();
		}
		
		return lista;
	}
	
	
	public Cliente traerClienteYEventos(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.idCliente =" + idCliente;
			objeto = (Cliente) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getEventos());
		} finally {
			session.close();
		}
		return objeto;
	}

	
}