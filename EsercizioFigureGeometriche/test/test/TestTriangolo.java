package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import figure.Triangolo;

public class TestTriangolo {
	@Test
	public void testTriangoloPerimetroSuccess() throws Exception {
		Triangolo t = new Triangolo (3,4,5,2);
		assertEquals("perimetro atteso di 12 ", 12 , t.calcolaPerimetro(), 0.001);
	}
	
	@Test
	public void testTriangoloAreaSuccess() throws Exception {
		Triangolo t = new Triangolo (3,4,5,2);
		assertEquals("area attesa di 3 ", 3, t.calcolaArea(), 0.001);
	}
	
	@Test
	public void testTriangoloBaseFail() throws Exception {
		Exception exception = assertThrows(" Lunghezza base non valida ", Exception.class, () -> {
			new Triangolo (-3,4,5,2);
		});
		String expectedMessage = "Lunghezza base non valida";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testTriangoloLato2Fail() throws Exception {
		Exception exception = assertThrows(" Lunghezza lato2 non valida ", Exception.class, () -> {
			new Triangolo (3,-4,5,2);
		});
		String expectedMessage = "Lunghezza lato2 non valida";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testTriangoloLato3Fail() throws Exception {
		Exception exception = assertThrows(" Lunghezza lato3 non valida ", Exception.class, () -> {
			new Triangolo (3,4,-5,2);
		});
		String expectedMessage = "Lunghezza lato3 non valida";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testTriangoloAltezzaFail() throws Exception {
		Exception exception = assertThrows(" Lunghezza altezza non valida ", Exception.class, () -> {
			new Triangolo (3,4,5,-2);
		});
		String expectedMessage = "Lunghezza altezza non valida";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testDisuguagliazaTriangolareFail() throws Exception {
		Exception exception = assertThrows("Il triangolo non rispetta la disuguagliaza triangolare", Exception.class, () -> {
			new Triangolo (3,3,19,2);
		});
		String expectedMessage = "Il triangolo non rispetta la disuguagliaza triangolare";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
