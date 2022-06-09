package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import operazioni.Sottrazione;

public class TestSottrazione {
	
	@Test
	public void sottrazionePositiviSuccess() {
		Sottrazione s = new Sottrazione(5,4);
		assertEquals("Risultato della Sottrazione atteso di 1",1.0,s.calcolaSottrazione(),0.001);
		
	}
	
	@Test
	public void sottrazionenegativiSuccess() {
		Sottrazione s = new Sottrazione(-5,-4);
		assertEquals("Risultato della Sottrazione atteso di -1",-1.0,s.calcolaSottrazione(),0.001);
		
	}
	
	@Test
	public void sottrazioneDiscordi1Success() {
		Sottrazione s = new Sottrazione(-5,4);
		assertEquals("Risultato della Sottrazione atteso di -9",-9.0,s.calcolaSottrazione(),0.001);
		
	}
	
	@Test
	public void sottrazioneDiscordi2Success() {
		Sottrazione s = new Sottrazione(5,-4);
		assertEquals("Risultato della Sottrazione atteso di 9",9.0,s.calcolaSottrazione(),0.001);
		
	}

}
