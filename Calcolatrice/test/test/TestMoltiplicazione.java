package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import operazioni.Moltiplicazione;



public class TestMoltiplicazione {
	
	@Test
	public void moltiplicazionePositiviSuccess() {
		Moltiplicazione m = new Moltiplicazione(5,4);
		assertEquals("Risultato della moltiplicazone atteso di 20",20.0,m.calcolaMoltiplicazione(),0.001);
		
	}
	
	@Test
	public void moltiplicazioneNegativiSuccess() {
		Moltiplicazione m = new Moltiplicazione(-5,-4);
		assertEquals("Risultato della moltiplicazone atteso di 20",20.0,m.calcolaMoltiplicazione(),0.001);
		
	}
	
	@Test
	public void moltiplicazioneDiscordi1Success() {
		Moltiplicazione m = new Moltiplicazione(-5,4);
		assertEquals("Risultato della moltiplicazone atteso di -20",-20.0,m.calcolaMoltiplicazione(),0.001);
		
	}
	
	@Test
	public void moltiplicazioneDiscordi2Success() {
		Moltiplicazione m = new Moltiplicazione(5,-4);
		assertEquals("Risultato della moltiplicazone atteso di -20",-20.0,m.calcolaMoltiplicazione(),0.001);
		
	}
}
