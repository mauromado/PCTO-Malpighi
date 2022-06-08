package operazioni;

public class Sottrazione {
	private double n1;
	private double n2;
	
	public Sottrazione(double n1,double n2) {
		this.n1=n1;
		this.n2=n2;
	}
	
	public double calcolaSottrazione() {
		return n1-n2;
	}
	
	public void stampaSottrazione() {
		String stamp = "La sottrazione fra i due numeri inseriti vale: " + calcolaSottrazione(); 
		System.out.println(stamp);
	}
}
