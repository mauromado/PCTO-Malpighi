package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import figure.Cerchio;

public class TestCerchio {
	@Test
	public void testCerchioPerimetroSuccess() throws Exception {
		Cerchio c = new Cerchio(3);
		assertEquals("perimetro atteso di 18.84956 ", 2 * Math.PI * 3, c.calcolaCrf(), 0.001);
	}
	
	@Test
	public void testCerchioAreaSuccess() throws Exception {
		Cerchio c = new Cerchio(3);
		assertEquals("area attesa di 28.27433 ", Math.PI*3*3, c.calcolaArea(), 0.001);
	}

	@Test
	public void testCerchioFail() throws Exception {
		Exception exception = assertThrows(" Lunghezza raggio non valida ", Exception.class, () -> {
			new Cerchio(-1);
		});
		String expectedMessage = "Lunghezza raggio non valida";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

}
