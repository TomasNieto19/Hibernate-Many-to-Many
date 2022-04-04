package test;

import negocio.ClienteABM;
import java.time.LocalDate;

public class TestAgregarCliente {

	public static void main(String[] args) throws Exception {
		
		
		// INSERTO LOS CLIENTES A LA BD.
		
		
		ClienteABM.getInstance().agregar("Gomez", "Pablo", 42980123, LocalDate.of(2000, 10, 12));
		

		ClienteABM.getInstance().agregar("Diaz", "Agustin", 41299071, LocalDate.of(1999, 9, 10));
		

		ClienteABM.getInstance().agregar("Fernandez", "Julia", 40123472, LocalDate.of(1998, 8, 9));
		

		ClienteABM.getInstance().agregar("Perez", "Lucas", 39776543, LocalDate.of(1998, 12, 25));
		

		ClienteABM.getInstance().agregar("Torres", "Emilia", 38442785, LocalDate.of(1998, 9, 12));
		

		ClienteABM.getInstance().agregar("Flores", "Joaquin", 41567009, LocalDate.of(1999, 4, 7));
		

	}
}