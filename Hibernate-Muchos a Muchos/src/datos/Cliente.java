package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cliente {
	private long idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private LocalDate fechaDeNacimiento;
	private boolean baja;
	private Set<Evento> eventos = new HashSet<Evento>();
	

	// CONSTRUCTORS
	
	
	public Cliente() {} 


	public Cliente(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.baja = false;
	}

	
	// GETTERS AND SETTERS
	
	
	public long getIdCliente() {
		return idCliente;
	}


	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	
	public String getApellido() {
		return apellido;
	}

	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public int getDni() {
		return dni;
	}

	
	public void setDni(int dni) {
		this.dni = dni;
	}

	
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	
	public boolean isBaja() {
		return baja;	
	}

	
	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	
	public Set<Evento> getEventos() {
		return eventos;
	}

	
	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	
	public boolean agregar(Evento evento) {
		
		return this.eventos.add(evento);
	}
	
	
	public boolean eliminar(Evento evento) {
		
		return this.eventos.remove(evento);
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return idCliente == other.idCliente;
	}
	
	
	@Override
	public String toString() {
		return "\nID: " + idCliente + " APELLIDO: " + apellido + " NOMBRE: " + nombre + " DNI:" + dni
				+ " F.NACIMIENTO: " + fechaDeNacimiento + " BAJA:" + baja;
	}


}