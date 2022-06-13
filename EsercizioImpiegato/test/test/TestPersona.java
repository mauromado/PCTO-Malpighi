package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import persone.Impiegato;

public class TestPersona {
	@Test
	public void testAumentaSalarioSuccess() throws Exception{
		Impiegato imp = new Impiegato("francesco","cassani",35, 100);
		imp.aumentaSalario(10);
		assertEquals("salario deve essere 110",110,imp.getSalario(),0.01);
	}
	

}
