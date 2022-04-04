package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Evento;

public class EventoDao {
	private static Session session;
	private Transaction tx;
	private static EventoDao instancia = null;

	
	// PATRON DE DISEÑO SINGLETON.
	
	
	protected EventoDao() {}
	
	
	public static EventoDao getInstance() {
		if (instancia == null)
			instancia = new EventoDao();
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
	
	
	public int agregar(Evento objeto) {

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

	
	public void actualizar(Evento objeto) throws HibernateException {
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

	
	public void eliminar(Evento objeto) throws HibernateException {
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
	
	
	public Evento traer(int idEvento) throws HibernateException {
		Evento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Evento) session.get(Evento.class, idEvento);
		} finally {
			session.close();
		}
		return objeto;
	}

	
	public Evento traerEventoYClientes(int idEvento) {
		
		Evento objeto = null;
		
		try {
			
			iniciaOperacion();
			
			String hql = "from Evento e where e.idEvento = " + idEvento;
			
			objeto = (Evento) session.createQuery(hql).uniqueResult();
			
			Hibernate.initialize(objeto.getClientes());
			
		} 
		
		finally {

			session.close();
			
		}
		
		return objeto;
	}
	
}	