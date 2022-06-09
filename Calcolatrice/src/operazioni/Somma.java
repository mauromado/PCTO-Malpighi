package operazioni;

public class Somma {
	private double n1;
	private double n2;
	
	public Somma(double n1,double n2) {
		this.n1=n1;
		this.n2=n2;
	}
	
	public double calcolaSomma() {
		return n1+n2;
	}
	
	public void stampaSomma() {
		System.out.println("La somma fra i due numeri inseriti vale: " + calcolaSomma());
	}
	}
