package persone;

public class Persona {
	protected String nome;
	protected String cognome;
	protected int eta;
	
	public Persona(String nome, String cognome, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public int getEtà() {
		return eta;
	}

	public String dettagli() {
		StringBuilder dettagli = new StringBuilder();
		dettagli.append("nome: ").append(nome).append("\n");
		dettagli.append("cognome: ").append(cognome).append("\n");
		dettagli.append("età: ").append(eta).append("\n");
		return dettagli.toString();
		}
}
