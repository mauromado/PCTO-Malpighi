package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void inc0Success() {
		Contatore c1= new Contatore();
		c1.reset();
		c1.inc(3);
		c1.reset();
		assertEquals("incremento atteso di 0",0,c1.getValore());
		
	}
	
	@Test
	public void inc20Success() {
		Contatore c1= new Contatore();
		c1.reset();
		c1.inc(3);
		c1.reset();
		c1.inc(4);
		c1.setValore(20);
		assertEquals("incremento atteso di 20",20,c1.getValore());
		
	}
	
	@Test
	public void min4True() {
		Contatore c1= new Contatore();
		c1.reset();
		c1.inc(3);
		assertTrue("expeted contatore minore di 4",c1.getValore()<4);
		
	}
	
	@Test
	public void min4false() {
		Contatore c1= new Contatore();
		c1.reset();
		c1.inc(3);
		c1.reset();
		c1.setValore(10);
		assertFalse("expeted contatore minore di 4",c1.getValore()<4);
		
	}
}
