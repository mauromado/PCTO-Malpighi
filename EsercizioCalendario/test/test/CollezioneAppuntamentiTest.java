package test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import model.Appuntamento;
import model.CollezioneAppuntamenti;

public class CollezioneAppuntamentiTest {
	CollezioneAppuntamenti coll = new CollezioneAppuntamenti();
	
	@Test
	public void aggiuntaAppuntamentoTest() {
		Appuntamento app1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,40)
				,Duration.of(0,ChronoUnit.MINUTES),"appuntamento test1");
		Appuntamento app2 = new Appuntamento(LocalDateTime.of(2021, Month.JUNE,4 ,12 ,40)
				,Duration.of(0,ChronoUnit.MINUTES),"appuntamento test2");
		Appuntamento app3 = new Appuntamento(LocalDateTime.of(2022, Month.JUNE,4 ,12 ,40)
				,Duration.of(0,ChronoUnit.MINUTES),"appuntamento test3");
		Appuntamento app4 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,40)
				,Duration.of(0,ChronoUnit.MINUTES),"appuntamento test1");
		coll.aggiuntaAppuntamento(app1);
		coll.aggiuntaAppuntamento(app2);
		coll.aggiuntaAppuntamento(app3);
		coll.aggiuntaAppuntamento(app4);
		System.out.println(coll.getAppuntamenti().size());
		assertEquals(3,coll.getAppuntamenti().size());
	}
}
