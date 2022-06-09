package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import operazioni.Divisione;

public class TestDivisione {
	@Test
	public void divisionePositiviSuccess() throws Exception {
		Divisione d= new Divisione(6,3);
		assertEquals("Risultato della Divisione atteso di 2",2.0,d.calcolaDivisione(),0.001);
		
	}
	
	@Test
	public void divisioneNegativiSuccess() throws Exception {
		Divisione d= new Divisione(-6,-3);
		assertEquals("Risultato della Divisione atteso di 2",2.0,d.calcolaDivisione(),0.001);
		
	}
	
	@Test
	public void divisioneDiscordi1Success() throws Exception {
		Divisione d= new Divisione(-6,3);
		assertEquals("Risultato della Divisione atteso di -2",-2.0,d.calcolaDivisione(),0.001);
		
	}
	
	@Test
	public void divisioneDiscordi2Success() throws Exception {
		Divisione d= new Divisione(6,-3);
		assertEquals("Risultato della Divisione atteso di -2",-2.0,d.calcolaDivisione(),0.001);
		
	}
	
	
	
	@Test
	public void divisioneFail() throws Exception {
		Exception exception = assertThrows("non è stata generata l'eccezione: la divisione è impossibile",
				Exception.class,
				() -> { //funzione 
					new Divisione(6,0);
				});
		String expectedMessage = "La divisione è impossibile.";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));



	}
}
