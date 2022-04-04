package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Evento {
	private int idEvento;
	private String evento;
	private LocalDate fecha;
	private LocalTime hora;
	private Set<Cliente> clientes = new HashSet<Cliente>();
	
	
	// CONSTRUCTORS
	
	
	public Evento() {}
	
	
	public Evento(String evento, LocalDate fecha, LocalTime hora) {
		super();
		this.evento = evento;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	
	// GETTERS AND SETTERS
	
	
	public int getIdEvento() {
		return idEvento;
	}
	
	
	protected void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	
	
	public String getEvento() {
		return evento;
	}
	
	
	public void setEvento(String evento) {
		this.evento = evento;
	}
	
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	public LocalTime getHora() {
		return hora;
	}
	
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
	public Set<Cliente> getClientes() {
		return clientes;
	}
	
	
	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	public boolean agregar(Cliente cliente){
	
		return this.clientes.add(cliente);
		
	}
	
	
	public boolean eliminar(Cliente cliente){
		
		return this.clientes.remove(cliente);
		
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idEvento);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return idEvento == other.idEvento;
	}

	
	@Override
	public String toString() {
		return "IdEvento: " + idEvento + " Nombre: " + evento + " Fecha: " + fecha + " Hora: " + hora;
	}
	
	
}
