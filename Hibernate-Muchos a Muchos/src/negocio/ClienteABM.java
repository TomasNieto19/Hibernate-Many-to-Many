package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;
import datos.Evento;


public class ClienteABM {
	private static ClienteABM instancia = null;

	
	// PATRON DE DISEÑO SINGLETON.
	
	
	protected ClienteABM() {}

	
	public static ClienteABM getInstance() {
		if (instancia == null)
			instancia = new ClienteABM();
		return instancia;
	}
	
	
	// ABM.

	
	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {

		if (ClienteABM.getInstance().traer(dni) != null) {

			throw new Exception("YA HAY UN CLIENTE CON EL DNI: " + dni);

		}

		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);

		return ClienteDao.getInstance().agregar(c);
	}

	
	public void eliminar(long idCliente) throws Exception {
		// en este caso es física en gral. no se se aplicaría este caso de uso, si
		// se hiciera habría que validar que el cliente no tenga dependencias
		// Implementar que si es null que arroje la excepción la Excepción
		Cliente c = ClienteABM.getInstance().traer(idCliente);

		if (c == null) {

			throw new Exception("NO SE PUEDE ELIMINAR EL CLIENTE, ES NULL");

		}

		ClienteDao.getInstance().eliminar(c);
	}

	
	public void eliminar(int dni) throws Exception {

		Cliente c = ClienteABM.getInstance().traer(dni);

		if (c == null) {

			throw new Exception("NO SE PUEDE ELIMINAR EL CLIENTE, ES NULL");

		}

		ClienteDao.getInstance().eliminar(c);
	}

	
	public void actualizar(Cliente c) {

		ClienteDao.getInstance().actualizar(c);
	}

	
	// TRAER.
	
	
	public Cliente traer(long idCliente) {

		Cliente c = ClienteDao.getInstance().traer(idCliente);

		return c;
	}

	
	public Cliente traer(int dni) {

		Cliente c = ClienteDao.getInstance().traer(dni);

		return c;
	}

	
	public List<Cliente> traer() {

		return ClienteDao.getInstance().traer();
	}

	
	public List<Cliente> traer(boolean baja) {

		return ClienteDao.getInstance().traer(baja);
	}

	
	public Cliente traerClienteYEventos(long idCliente) {

		Cliente c = ClienteDao.getInstance().traerClienteYEventos(idCliente);

		return c;
	}

	
	// ADDITIONAL.

	
	public boolean agregarleEventoACliente(Cliente cliente, Evento evento) throws Exception {

		boolean eliminado = cliente.agregar(evento);

		if (!eliminado) {

			throw new Exception("EL CLIENTE YA TIENE ASIGNADO AL EVENTO CON ID: " + evento.getIdEvento());

		}

		ClienteDao.getInstance().actualizar(cliente);

		return eliminado;

	}

	
	public boolean eliminarleEventoACliente(Cliente cliente, Evento evento) throws Exception {

		boolean eliminado = cliente.eliminar(evento);

		if (!eliminado) {

			throw new Exception("EL CLIENTE NO TIENE ASIGNADO AL EVENTO CON ID: " + evento.getIdEvento());

		}

		ClienteDao.getInstance().actualizar(cliente);

		return eliminado;
	}

	
}