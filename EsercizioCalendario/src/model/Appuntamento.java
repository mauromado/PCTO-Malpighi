package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Appuntamento {
	private LocalDateTime inizio;
	private LocalDateTime fine;
	private String descrizione;
	
	public Appuntamento(LocalDateTime inizio, LocalDateTime fine, String descrizione) {
		this.inizio=inizio;
		this.fine=fine;
		this.descrizione=descrizione;
	}
	
	public Appuntamento(LocalDateTime inizio, Duration durata, String descrizione) {
		this.inizio=inizio;
		setDuration(durata);
		this.descrizione=descrizione;
	}

	public LocalDateTime getInizio() {
		return inizio;
	}

	public void setInizio(LocalDateTime inizio) {
		this.inizio = inizio;
	}

	public LocalDateTime getFine() {
		return fine;
	}

	public void setFine(LocalDateTime fine) {
		this.fine = fine;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Duration getDuration() {
		return Duration.between(inizio, fine);
	}
	
	public void setDuration(Duration durata) {
		fine=inizio.plus(durata);
	}
	
	public String toString() {
		DateTimeFormatter formatter = 
				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,FormatStyle.SHORT);
		return ("Impegno: "+descrizione+" con inizio "+formatter.format(inizio)+
				" e con fine"+formatter.format(fine));
	}
	
	public boolean equals(Appuntamento appuntamento) {
		return inizio.equals(appuntamento.getInizio())&&fine.equals(appuntamento.getFine())
				&&descrizione.equals(appuntamento.getDescrizione());
	}
}
