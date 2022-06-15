package controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

import model.Appuntamento;
import model.CollezioneAppuntamenti;

public class Calendario {
	private CollezioneAppuntamenti appuntamenti;
	
	public Calendario() {
		this.appuntamenti = new CollezioneAppuntamenti();
	}
	
	public void aggiuntaAppuntamento(Appuntamento app) {
		if(appuntamenti.getAppuntamenti().contains(app)) {
			System.out.println("l'appuntamento è gia presente");
		}
		else {
			appuntamenti.getAppuntamenti().add(app);
		}
	}
	
	public void rimuoviAppuntamento(Appuntamento app) {
		appuntamenti.getAppuntamenti().remove(app);
	}
	
	private boolean controlloSovrapposizione(LocalDateTime inizio, LocalDateTime fine,
			LocalDateTime inizioRef, LocalDateTime fineRef) {
		return inizio.isBefore(fineRef)&&fine.isBefore(inizioRef);
	}
	
	private CollezioneAppuntamenti getAppuntamentiFascia(LocalDateTime inizio,LocalDateTime fine){
		CollezioneAppuntamenti coll = new CollezioneAppuntamenti();
		if(!appuntamenti.getAppuntamenti().isEmpty()) {
			for(int i=0;i<appuntamenti.getAppuntamenti().size();i++) {
				Appuntamento app = appuntamenti.getAppuntamenti().get(i);
				if (controlloSovrapposizione(app.getInizio(),app.getFine(),inizio,fine)) {
					coll.getAppuntamenti().add(app);
				}
			
			}
		}
		return coll;
	}
	
	public CollezioneAppuntamenti getAppuntamentiGiornalieri(LocalDate giorno) {
		LocalDateTime inizioGiorno = LocalDateTime.of(giorno,LocalTime.of(0, 0));
		LocalDateTime fineGiorno = inizioGiorno.plusDays(1);
		return getAppuntamentiFascia(inizioGiorno,fineGiorno);
	}
	
	public CollezioneAppuntamenti getAppuntamentiMensili(LocalDate mese) {
		LocalDate primoGiorno = mese.withDayOfMonth(1);
		LocalDateTime inizioMese = LocalDateTime.of(primoGiorno,LocalTime.of(0, 0));
		LocalDateTime fineMese = inizioMese.plusMonths(1);
		return getAppuntamentiFascia(inizioMese,fineMese);
	}
	
	public CollezioneAppuntamenti getAppuntamentiSettimanali(LocalDate settimana) {
		long distanzaUltimoLunedi = settimana.getDayOfWeek().getValue()-DayOfWeek.MONDAY.getValue();
		LocalDate dataInizioSettimana = settimana.minusDays(distanzaUltimoLunedi);
		LocalDateTime inizioSettimana = LocalDateTime.of(dataInizioSettimana,LocalTime.of(0, 0));
		LocalDateTime fineSettimana = inizioSettimana.plusWeeks(1);
		return getAppuntamentiFascia(inizioSettimana,fineSettimana);
	}

	public CollezioneAppuntamenti getAppuntamenti() {
		return appuntamenti;
	}
	
	
}
