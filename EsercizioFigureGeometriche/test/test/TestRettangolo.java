package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import figure.Rettangolo;

public class TestRettangolo {
	@Test
	public void testRettangoloPerimetroSuccess() throws Exception {
		Rettangolo r = new Rettangolo(2,5);
		assertEquals("perimetro atteso di 14 ", 14 , r.calcolaPerimetro(), 0.001);
	}
	
	@Test
	public void testRettangoloAreaSuccess() throws Exception {
		Rettangolo r = new Rettangolo(2,5);
		assertEquals("area attesa di 10 ", 10 , r.calcolaArea(), 0.001);
	}
	
	@Test
	public void testRettangoloLato1Fail() throws Exception {
		Exception exception = assertThrows(" Lunghezza lato1 non valida ", Exception.class, () -> {
			new Rettangolo (-2,3);
		});
		String expectedMessage = "Lunghezza lato1 non valida";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void testRettangoloLato2Fail() throws Exception {
		Exception exception = assertThrows(" Lunghezza lato2 non valida ", Exception.class, () -> {
			new Rettangolo (2,-3);
		});
		String expectedMessage = "Lunghezza lato2 non valida";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
}
