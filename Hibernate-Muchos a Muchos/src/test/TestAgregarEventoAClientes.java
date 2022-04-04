package test;

import negocio.ClienteABM;
import negocio.EventoABM;

public class TestAgregarEventoAClientes {

	public static void main(String[] args) throws Exception {

		
		// AL EVENTO ID 13 LE INSERTO 3 CLIENTES.
		
		
		long idCliente8 = 8;
		long idCliente9 = 9;
		long idCliente10 = 10;
		
		
		EventoABM.getInstance().agregarleClienteAEvento(ClienteABM.getInstance().traer(idCliente8), EventoABM.getInstance().traer(3));
		
		
		EventoABM.getInstance().agregarleClienteAEvento(ClienteABM.getInstance().traer(idCliente9), EventoABM.getInstance().traer(3));
		
		
		EventoABM.getInstance().agregarleClienteAEvento(ClienteABM.getInstance().traer(idCliente10), EventoABM.getInstance().traer(3));
		
		
	}
}
