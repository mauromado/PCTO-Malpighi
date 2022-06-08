package figure;

public class Rettangolo {
	private double lato1;
	private double lato2;
	
	public Rettangolo( double lato1, double lato2) throws Exception {
		if (lato1<0) {
			throw new Exception("Lunghezza lato1 non valida");
		}	
		if (lato2<0) {
			throw new Exception("Lunghezza lato2 non valida");
		}	
		
		this.lato1 = lato1;
		this.lato2 = lato2;

	}
	
	public double calcolaPerimetro() {
		return (lato1+lato2)*2;
	}
	
	public double calcolaArea() {
		return lato1*lato2;
	}
	
	public void stampaDati() {
		String result= "L'area del rettangolo vale: "+calcolaArea()+"\nIl perimetro vale: " +calcolaPerimetro();
		System.out.println(result);
	}
}
