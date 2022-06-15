package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import model.Appuntamento;

public class AppuntamentoTest {
	@Test
	public void testGetSetInizio() {
		LocalDateTime data = LocalDateTime.of(2020, Month.JUNE,4 ,12 ,40);
		Appuntamento app= new Appuntamento(data,Duration.of(0,ChronoUnit.MINUTES),"appuntamento test");
		assertEquals(data, app.getInizio());
		LocalDateTime nuovoInizio = LocalDateTime.of(2021,Month.APRIL,5,3,30);
		app.setInizio(nuovoInizio);
		assertEquals(nuovoInizio,app.getInizio());
	}
	//Aggiungere analogo per fine
	//Aggiungere analogo per duration
	@Test
	public void testEqualsAppuntamentoSuccess() {
		Appuntamento app1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,40)
				,Duration.of(0,ChronoUnit.MINUTES),"appuntamento test");
		Appuntamento app2 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,40),
				Duration.of(0,ChronoUnit.MINUTES),"appuntamento test");
		assertTrue(app1.equals(app2));
	}
	
	@Test
	public void testEqualsAppuntamentoFail() {
		Appuntamento app1 = new Appuntamento(LocalDateTime.of(2021, Month.JUNE,4 ,12 ,40)
				,Duration.of(0,ChronoUnit.MINUTES),
				"appuntamento test");
		Appuntamento app2 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,40)
				,Duration.of(0,ChronoUnit.MINUTES),
				"appuntamento test");
		assertFalse(app1.equals(app2));
	}
}
