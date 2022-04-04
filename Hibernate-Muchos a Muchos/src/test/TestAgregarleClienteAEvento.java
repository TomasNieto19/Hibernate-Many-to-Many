package test;

import negocio.ClienteABM;
import negocio.EventoABM;


public class TestAgregarleClienteAEvento {

	public static void main(String[] args) throws Exception {

		
		// LE AGREGO 3 CLIENTES AL EVENTO CON ID 5.
		
		
		long idCliente11 = 11;
		long idCliente12 = 12;
		long idCliente13 = 13;
		

		ClienteABM.getInstance().agregarleEventoACliente(ClienteABM.getInstance().traer(idCliente11), EventoABM.getInstance().traer(5));
		
		
		ClienteABM.getInstance().agregarleEventoACliente(ClienteABM.getInstance().traer(idCliente12), EventoABM.getInstance().traer(5));
		
		
		ClienteABM.getInstance().agregarleEventoACliente(ClienteABM.getInstance().traer(idCliente13), EventoABM.getInstance().traer(5));
		
		
	}
}
