package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import operazioni.Somma;

public class TestSomma {
	
	@Test
	public void sommaPositiviSuccess() {
		Somma s1 = new Somma(2,3);
		assertEquals("Risultato della Somma atteso di 5",5.0,s1.calcolaSomma(),0.001);
		
	}
	
	@Test
	public void sommaNegativiSuccess() {
		Somma s1 = new Somma(-2,-3);
		assertEquals("Risultato della Somma atteso di -5 ",-5.0,s1.calcolaSomma(),0.001);
		
	}
	
	@Test
	public void sommaDiscordi1Success() {
		Somma s1 = new Somma(-2,3);
		assertEquals("Risultato della Somma atteso di 1 ",1.0,s1.calcolaSomma(),0.001);
		
	}
	
	@Test
	public void sommaDiscordi2Success() {
		Somma s1 = new Somma(2,-3);
		assertEquals("Risultato della Somma atteso di -1",-1.0,s1.calcolaSomma(),0.001);
		
	}
}
