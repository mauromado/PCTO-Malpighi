package test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Appuntamento;
import model.CollezioneAppuntamenti;

public class CollezioneAppuntamentiTest {
	
	@Test
	public void aggiungiAppuntamentoTest() {
		CollezioneAppuntamenti collezioneAppuntamenti = new CollezioneAppuntamenti();
		Appuntamento app1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,00)
				,Duration.of(0,ChronoUnit.MINUTES),"Verifica");
		
		Appuntamento app2 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,5 ,22 ,30)
				,Duration.of(0,ChronoUnit.MINUTES),"Compleanno");
		
		Appuntamento app3 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,6 ,23 ,20)
				,Duration.of(0,ChronoUnit.MINUTES),"Cinema");
		
		collezioneAppuntamenti.aggiungiAppuntamento(app1);
		collezioneAppuntamenti.aggiungiAppuntamento(app2);
		collezioneAppuntamenti.aggiungiAppuntamento(app3);
		assertEquals(3,collezioneAppuntamenti.getAppuntamenti().size());
	}
	
	@Test
	public void aggiungiAppuntamentoDuplicatoTest() {
		CollezioneAppuntamenti collezioneAppuntamenti = new CollezioneAppuntamenti();
		Appuntamento app1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,00)
				,Duration.of(0,ChronoUnit.MINUTES),"Verifica");
		collezioneAppuntamenti.aggiungiAppuntamento(app1);
		collezioneAppuntamenti.aggiungiAppuntamento(app1);
		assertEquals(1,collezioneAppuntamenti.getAppuntamenti().size());
	}
	
	//Test remove
	
	//Test get -> assertNotNull
}
