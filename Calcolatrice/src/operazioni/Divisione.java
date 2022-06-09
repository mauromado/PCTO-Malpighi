package operazioni;

public class Divisione {
	private double dividendo;
	private double divisore;
	
	public Divisione(double dividendo,double divisore) throws Exception {
		if (divisore==0) {
			throw new Exception("La divisione è impossibile.");
		}

		this.dividendo=dividendo;
		this.divisore=divisore;
	}
	
	public double calcolaDivisione() {
		return dividendo/divisore;
	}
	
	public void stampaDivisione() {
		System.out.println("il Quoziente fra i due numeri inseriti vale: " + calcolaDivisione());
	}
}

