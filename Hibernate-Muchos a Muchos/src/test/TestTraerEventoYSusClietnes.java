package test;

import datos.Evento;
import negocio.EventoABM;

public class TestTraerEventoYSusClietnes {

	public static void main(String[] args) {
		
		
		// TRAIGO UN EVENTO Y SUS CLIENTES INICIALIZADOS.

		
		Evento evento = EventoABM.getInstance().traerEventoYClientes(5);
		
		
		System.out.println("\nEVENTO: ");
		System.out.println(evento);
		System.out.println("\nCLIENTES: ");
		System.out.println("\n" + evento.getClientes());
	
		
	}
}