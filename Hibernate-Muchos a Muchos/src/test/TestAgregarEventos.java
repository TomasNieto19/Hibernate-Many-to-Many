package test;

import java.time.LocalDate;
import java.time.LocalTime;
import negocio.EventoABM;

public class TestAgregarEventos {

	public static void main(String[] args) {
		
		
		// INSERTO EVENTOS A LA BD.
		
		
		EventoABM.getInstance().agregar("Argentina VS Venezuela", LocalDate.now(), LocalTime.of(20, 30));

		
		EventoABM.getInstance().agregar("Ecuador VS Argentina", LocalDate.now(), LocalTime.of(20, 00));
		
		
	}
}