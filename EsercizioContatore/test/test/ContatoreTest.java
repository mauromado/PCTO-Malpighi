package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import contatore.Contatore;

public class ContatoreTest {
	
	@Test
	public void inc3Success() {
		Contatore c1= new Contatore();
		c1.reset();
		c1.inc(3);
		assertEquals("incremento atteso di 3",3,c1.getValore());
		
	}
}
