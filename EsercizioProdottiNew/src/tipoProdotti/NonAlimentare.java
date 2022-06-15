package tipoProdotti;

import prodotti.Prodotto;

public class NonAlimentare extends Prodotto {
	private String materiale;

	public NonAlimentare(String codice, String descrizione, double prezzo, String materiale) {
		super(codice, descrizione, prezzo, "N");
		this.materiale = materiale;
	}

	public String getMateriale() {
		return materiale;
	}

	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}
	@Override
	public String toString() {
		StringBuilder a = new StringBuilder();
		a.append(super.toString()).append("\nmateriale: ").append(materiale);
		return a.toString();
	}
	@Override
	public void applicaSconto() {
		if (materiale.contains("carta")||materiale.contains("vetro")||materiale.contains("plastica")) {
			prezzo=prezzo-0.1*prezzo;
		}
	}
}
