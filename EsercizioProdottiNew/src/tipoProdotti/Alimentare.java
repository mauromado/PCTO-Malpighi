package tipoProdotti;

import java.text.DateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
//import java.time.format.DateTimeFormat;
import java.util.Locale;
import java.util.Date;

import prodotti.Prodotto;

public class Alimentare extends Prodotto {
	private LocalDate scadenza;

	public Alimentare(String codice, String descrizione, double prezzo,  LocalDate scadenza) {
		super(codice, descrizione, prezzo,"A");
		this.scadenza = scadenza;
	}

	public LocalDate getScadenza() {
		return scadenza;
	}

	public void setScadenza(LocalDate scadenza) {
		this.scadenza = scadenza;
	}
	
	@Override
	public String toString() {
		Locale.getDefault();
		//DateTimeFormatter formatterShort =
		//		DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter formatterShort =
				DateTimeFormatter.ofPattern("dd-MM-yyyy");
		StringBuilder a = new StringBuilder();
		a.append(super.toString()).append("\nLa scadenza é: ").append(scadenza.format(formatterShort));
		return a.toString();
	}
	@Override
	public void applicaSconto() {
		LocalDate actualDate = LocalDate.now();
		Period p = Period.between(actualDate, scadenza);
		if (p.getDays()<10) {
			prezzo=prezzo-0.2*prezzo;
		}
		else {
			System.out.println("Nessuno sconto applicabile ");
		}
	}
}
