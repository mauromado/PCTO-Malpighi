package prodotti;

import java.util.Objects;

public class Prodotto {
	protected String codice;
	protected String descrizione;
	protected double prezzo;
	
	public Prodotto(String codice, String descrizione, double prezzo) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public void applicaSconto() {
		prezzo=prezzo-5%prezzo;
	}

	@Override
	public String toString() {
		StringBuilder p = new StringBuilder();
		p.append("Prodotto: ").append(descrizione)
			.append("\nIl codice a barre è: ").append(codice)
			.append("\nIl prezzo è:").append(prezzo).append(" €");
		return p.toString();
	}
	public boolean equals(Prodotto p) {
		return prezzo == p.getPrezzo()&& 
				codice.contains(p.getCodice())&& 
				descrizione.contains(p.getDescrizione());
	}

	
}
