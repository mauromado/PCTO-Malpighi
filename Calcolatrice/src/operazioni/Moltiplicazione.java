package operazioni;

public class Moltiplicazione {
	private double n1;
	private double n2;
	
	public Moltiplicazione(double n1,double n2) {
		this.n1=n1;
		this.n2=n2;
	}
	
	public double calcolaMoltiplicazione() {
		return n1*n2;
	}
	
	public void stampaMoltiplicazione() {
		String stamp = "La moltiplicazione fra i due numeri inseriti vale: " + calcolaMoltiplicazione(); 
		System.out.println(stamp);
	}
}
