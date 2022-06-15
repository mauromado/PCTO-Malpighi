package prodotti;

import java.util.Objects;

public class Prodotto {
	protected String codice;
	protected String descrizione;
	protected double prezzo;
	protected String tipo;
	
	public Prodotto(String codice, String descrizione, double prezzo,String tipo) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.tipo=tipo;
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
	@Override
	public boolean equals(Object p) {
		Prodotto prodotto =(Prodotto) p;
		return prezzo == prodotto.getPrezzo()&& 
				codice.contains(prodotto.getCodice())&& 
				descrizione.contains(prodotto.getDescrizione());
	}

	
}
