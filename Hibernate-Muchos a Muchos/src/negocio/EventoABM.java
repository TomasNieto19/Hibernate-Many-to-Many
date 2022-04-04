package negocio;

import java.time.LocalDate;
import java.time.LocalTime;

import dao.EventoDao;
import datos.Cliente;
import datos.Evento;

public class EventoABM {
	private static EventoABM instancia = null;

	
	// PATRON DE DISEÑO SINGLETON.
	
	
	protected EventoABM() {}
	
	
	public static EventoABM getInstance() {
		if (instancia == null)
			instancia = new EventoABM();
		return instancia;
	}

	
	// ABM.
	

	public int agregar(String evento, LocalDate fecha, LocalTime hora) {

		Evento e = new Evento(evento, fecha, hora);

		return EventoDao.getInstance().agregar(e);
	}
	
	
	public void eliminar(int idEvento) {

		Evento e = EventoDao.getInstance().traer(idEvento);

		EventoDao.getInstance().eliminar(e);
	}
	
	
	public void actualizar(Evento e) {

		EventoDao.getInstance().actualizar(e);

	}

	
	// TRAER.
	
	
	public Evento traer(int idEvento) {

		Evento e = EventoDao.getInstance().traer(idEvento);

		return e;
	}
	
	
	public Evento traerEventoYClientes(int idEvento) {

		Evento e = EventoDao.getInstance().traerEventoYClientes(idEvento);

		return e;
	}

	
	// ADDITIONAL.
	
	
	public boolean agregarleClienteAEvento(Cliente cliente, Evento evento) throws Exception {

		boolean agregado = evento.agregar(cliente);
		
		if (!agregado) {

			throw new Exception("EL EVENTO NO TIENE ASIGNADO AL CLIENTE CON ID: " + cliente.getIdCliente());

		}

		EventoDao.getInstance().actualizar(evento);
		
		return agregado;
	}

	
	public boolean eliminarleClienteAEvento(Cliente cliente, Evento evento) throws Exception {

		boolean eliminado = evento.eliminar(cliente);

		if (!eliminado) {

			throw new Exception("EL EVENTO NO TIENE ASIGNADO AL CLIENTE CON ID: " + cliente.getIdCliente());

		}

		EventoDao.getInstance().actualizar(evento);

		return eliminado;
	}

	
}
