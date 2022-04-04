package test;


import negocio.ClienteABM;
import negocio.EventoABM;

public class TestEliminarleClienteAEvento {

	public static void main(String[] args) throws Exception {

		
			// ELIMINO EL CLIENTE 13 DEL EVENTO 5.
		
			long idCliente13 = 13;
			int idEvento5 = 5;
			

			EventoABM.getInstance().eliminarleClienteAEvento(ClienteABM.getInstance().traer(idCliente13), EventoABM.getInstance().traer(idEvento5));


	}
}