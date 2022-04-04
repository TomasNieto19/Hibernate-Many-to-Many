package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerClienteYEventos {

	public static void main(String[] args) {

		
		// TRAIGO UN CLIENTE Y SUS EVENTOS INICIALIZADOS.
		
		
		long idCliente = 9; 
		
		
		Cliente cliente = ClienteABM.getInstance().traerClienteYEventos(idCliente);
		
		
		System.out.println("\nCLIENTE: ");
		System.out.println(cliente);
		System.out.println("\nEVENTOS: ");
		System.out.println("\n" + cliente.getEventos());
		
		
	}
}