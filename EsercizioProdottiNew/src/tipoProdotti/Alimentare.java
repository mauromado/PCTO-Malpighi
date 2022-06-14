package tipoProdotti;

import java.text.DateFormat;
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
		a.append(super.toString()).append("La scadenza é¨: ").append(scadenza);
		return a.toString();
	}
	
}
