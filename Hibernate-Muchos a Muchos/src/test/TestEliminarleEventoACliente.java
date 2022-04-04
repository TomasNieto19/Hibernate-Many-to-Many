package test;

import negocio.ClienteABM;
import negocio.EventoABM;


public class TestEliminarleEventoACliente {

	public static void main(String[] args) throws Exception {
		
		
		// ELIMINO EVENTO 5 DEL CLIENTE.
		
		
		long idCliente8 = 8;
		int idEvento3 = 3;
		

		ClienteABM.getInstance().eliminarleEventoACliente(ClienteABM.getInstance().traer(idCliente8), EventoABM.getInstance().traer(idEvento3));

		
	}
}
