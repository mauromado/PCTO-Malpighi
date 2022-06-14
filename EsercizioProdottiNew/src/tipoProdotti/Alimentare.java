package tipoProdotti;

import java.text.DateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.FormatStyle;
import java.util.Locale;
//import java.time.format.DateTimeFormat;
import java.util.Locale;
import java.util.Date;

import prodotti.Prodotto;

public class Alimentare extends Prodotto {
	private LocalDate scadenza;

	public Alimentare(String codice, String descrizione, double prezzo, LocalDate scadenza) {
		super(codice, descrizione, prezzo);
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
		/*Locale.getDefault()
		DateTimeFormat formatterShort =
				DateTimeFormat.ofLocalizedDate(FormatStyle.SHORT);*/
		StringBuilder a = new StringBuilder();
		a.append(super.toString()).append("\nLa scadenza é: ").append(scadenza);
		return a.toString();
	}
	@Override
	public void applicaSconto() {
		Duration d1=Duration.ofDays(10);
		Instant i1=Instant.now();
		Instant i2=Instant.parse(scadenza.toString());
		Duration d2=Duration.between(i2, i1);
		if (d1.compareTo(d2)<0) {
			prezzo=prezzo-0.2*prezzo;
		}
		else {
			System.out.println("Nessuno sconto applicabile ");
		}
	}
}
