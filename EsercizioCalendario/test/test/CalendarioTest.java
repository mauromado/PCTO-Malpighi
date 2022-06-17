package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import controller.Calendario;
import model.Appuntamento;
import model.CollezioneAppuntamenti;

public class CalendarioTest {
	@Test
	public void getAppuntamentiTest (){
		Calendario calendario = new Calendario();
		Appuntamento app1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,00)
				,Duration.of(0,ChronoUnit.MINUTES),"Verifica");
		
		Appuntamento app2 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,5 ,22 ,30)
				,Duration.of(0,ChronoUnit.MINUTES),"Compleanno");
		
		Appuntamento app3 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,6 ,23 ,20)
				,Duration.of(0,ChronoUnit.MINUTES),"Cinema");
		calendario.aggiungiAppuntamentoCalendario(app1);
		calendario.aggiungiAppuntamentoCalendario(app2);
		calendario.aggiungiAppuntamentoCalendario(app3);
		assertNotNull(calendario.getAppuntamenti());
		assertEquals(3,calendario.getAppuntamenti().getAppuntamenti().size());
	}
	
	@Test
	public void aggiungiAppuntamentoCalendarioTest(){
		Calendario calendario = new Calendario();
		Appuntamento app1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,00)
				,Duration.of(0,ChronoUnit.MINUTES),"Verifica");
		
		Appuntamento app2 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,5 ,22 ,30)
				,Duration.of(0,ChronoUnit.MINUTES),"Compleanno");
		
		Appuntamento app3 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,6 ,23 ,20)
				,Duration.of(0,ChronoUnit.MINUTES),"Cinema");
		calendario.aggiungiAppuntamentoCalendario(app1);
		calendario.aggiungiAppuntamentoCalendario(app2);
		calendario.aggiungiAppuntamentoCalendario(app3);
		assertEquals(3,calendario.getAppuntamenti().getAppuntamenti().size());
	}
	
	@Test
	public void rimuoviAppuntamentoCalendarioTest (){
		Calendario calendario = new Calendario();
		Appuntamento app1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,00)
				,Duration.of(0,ChronoUnit.MINUTES),"Verifica");
		
		Appuntamento app2 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,5 ,22 ,30)
				,Duration.of(0,ChronoUnit.MINUTES),"Compleanno");
		
		Appuntamento app3 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,6 ,23 ,20)
				,Duration.of(0,ChronoUnit.MINUTES),"Cinema");
		calendario.aggiungiAppuntamentoCalendario(app1);
		calendario.aggiungiAppuntamentoCalendario(app2);
		calendario.aggiungiAppuntamentoCalendario(app3);
		calendario.rimuoviAppuntamentoCalendario(app1);
		assertEquals(2,calendario.getAppuntamenti().getAppuntamenti().size());
		assertTrue(calendario.getAppuntamenti().getAppuntamenti().contains(app2));
		assertTrue(calendario.getAppuntamenti().getAppuntamenti().contains(app3));
	}
	
	@Test
	public void getAppuntamentiGiornalieriTest(){
		Calendario calendario = new Calendario();
		Appuntamento app1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,00)
				,Duration.of(0,ChronoUnit.MINUTES),"Verifica");
		
		Appuntamento app2 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,5 ,22 ,30)
				,Duration.of(0,ChronoUnit.MINUTES),"Compleanno");
		
		Appuntamento app3 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,6 ,23 ,20)
				,Duration.of(0,ChronoUnit.MINUTES),"Cinema");
		calendario.aggiungiAppuntamentoCalendario(app1);
		calendario.aggiungiAppuntamentoCalendario(app2);
		calendario.aggiungiAppuntamentoCalendario(app3);
		CollezioneAppuntamenti giornalieri = calendario.getAppuntamentiGiornalieri 
				(LocalDate.of(2020, Month.JUNE,4 ));
		assertEquals(1,giornalieri.getAppuntamenti().size());
		assertTrue(giornalieri.getAppuntamenti().contains(app1));	
	}
	
	@Test
	public void getAppuntamentiMensiliTest (){
		Calendario calendario = new Calendario();
		Appuntamento app1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,00)
				,Duration.of(0,ChronoUnit.MINUTES),"Verifica");
		
		Appuntamento app2 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,5 ,22 ,30)
				,Duration.of(0,ChronoUnit.MINUTES),"Compleanno");
		
		Appuntamento app3 = new Appuntamento(LocalDateTime.of(2020, Month.AUGUST,6 ,23 ,20)
				,Duration.of(0,ChronoUnit.MINUTES),"Cinema");
		calendario.aggiungiAppuntamentoCalendario(app1);
		calendario.aggiungiAppuntamentoCalendario(app2);
		calendario.aggiungiAppuntamentoCalendario(app3);
		CollezioneAppuntamenti mensili = calendario.getAppuntamentiMensili 
				(LocalDate.of(2020, Month.JUNE,4 ));
		assertEquals(2,mensili.getAppuntamenti().size());
		assertTrue(mensili.getAppuntamenti().contains(app1));
		assertTrue(mensili.getAppuntamenti().contains(app2));
	}
	
	@Test
	public void getAppuntamentiSettimanaliTest (){
		Calendario calendario = new Calendario();
		Appuntamento app1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,12 ,00)
				,Duration.of(0,ChronoUnit.MINUTES),"Verifica");
		
		Appuntamento app2 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,5 ,22 ,30)
				,Duration.of(0,ChronoUnit.MINUTES),"Compleanno");
		
		Appuntamento app3 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,20,23 ,20)
				,Duration.of(0,ChronoUnit.MINUTES),"Cinema");
		calendario.aggiungiAppuntamentoCalendario(app1);
		calendario.aggiungiAppuntamentoCalendario(app2);
		calendario.aggiungiAppuntamentoCalendario(app3);
		CollezioneAppuntamenti settimanali = calendario.getAppuntamentiSettimanali 
				(LocalDate.of(2020, Month.JUNE,4 ));
		assertEquals(2,settimanali.getAppuntamenti().size());
		assertTrue(settimanali.getAppuntamenti().contains(app1));
		assertTrue(settimanali.getAppuntamenti().contains(app2));
	}
	
	@Test
	public void controlloSovrapposizioneTest() {
		Calendario calendario = new Calendario();
		Appuntamento appRiferimento = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4 ,10 ,00)
				,Duration.of(30,ChronoUnit.MINUTES),"Verifica");
		
		Appuntamento appNonSovrapposto1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4,9 ,00)
				,Duration.of(30,ChronoUnit.MINUTES),"Compleanno");
		
		Appuntamento appSovrapposto1 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4,9 ,45)
				,Duration.of(30,ChronoUnit.MINUTES),"cinema");
		Appuntamento appSovrapposto2 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4,10 ,10)
				,Duration.of(10,ChronoUnit.MINUTES),"bar");
		Appuntamento appSovrapposto3 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4,10 ,25)
				,Duration.of(15,ChronoUnit.MINUTES),"laser game");
		Appuntamento appNonSovrapposto2 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4,11 ,00)
				,Duration.of(15,ChronoUnit.MINUTES),"piscina");
		Appuntamento appSovrapposto4 = new Appuntamento(LocalDateTime.of(2020, Month.JUNE,4,9 ,50)
				,Duration.of(45,ChronoUnit.MINUTES),"laser game");
		calendario.aggiungiAppuntamentoCalendario(appRiferimento);
		calendario.aggiungiAppuntamentoCalendario(appNonSovrapposto1);
		calendario.aggiungiAppuntamentoCalendario(appSovrapposto1);
		calendario.aggiungiAppuntamentoCalendario(appNonSovrapposto2);
		calendario.aggiungiAppuntamentoCalendario(appSovrapposto2);
		calendario.aggiungiAppuntamentoCalendario(appSovrapposto3);
		calendario.aggiungiAppuntamentoCalendario(appSovrapposto4);
		assertFalse(calendario.controlloSovrapposizione
				(appNonSovrapposto1.getInizio(), appNonSovrapposto1.getFine(),
						appRiferimento.getInizio(), appRiferimento.getFine()));
		assertTrue(calendario.controlloSovrapposizione
				(appSovrapposto1.getInizio(), appSovrapposto1.getFine(),
						appRiferimento.getInizio(), appRiferimento.getFine()));
		assertFalse(calendario.controlloSovrapposizione
				(appNonSovrapposto2.getInizio(), appNonSovrapposto2.getFine(),
						appRiferimento.getInizio(), appRiferimento.getFine()));
		assertTrue(calendario.controlloSovrapposizione
				(appSovrapposto2.getInizio(), appSovrapposto2.getFine(),
						appRiferimento.getInizio(), appRiferimento.getFine()));
		assertTrue(calendario.controlloSovrapposizione
				(appSovrapposto3.getInizio(), appSovrapposto3.getFine(),
						appRiferimento.getInizio(), appRiferimento.getFine()));
		assertTrue(calendario.controlloSovrapposizione
				(appSovrapposto4.getInizio(), appSovrapposto4.getFine(),
						appRiferimento.getInizio(), appRiferimento.getFine()));
		
		
	}
}
