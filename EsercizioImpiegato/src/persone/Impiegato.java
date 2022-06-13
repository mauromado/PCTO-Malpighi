package persone;

public class Impiegato extends Persona{
	private double salario;

	public Impiegato(String nome, String cognome, int eta, double salario) throws Exception {
		super(nome, cognome, eta);
		
		if(salario<0) {
			throw new Exception("salario minore di 0");
		}
		this.salario = salario;
	}
	@Override
	public String dettagli() {
		StringBuilder dettagli = new StringBuilder();
		dettagli.append(super.dettagli());
		dettagli.append("salario: ").append(salario).append("\n");
		return dettagli.toString();
		
	}
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario=salario;
	}
	
	public void aumentaSalario(double percentuale){
		setSalario(this.salario+this.salario*(percentuale/100));
	}
}
