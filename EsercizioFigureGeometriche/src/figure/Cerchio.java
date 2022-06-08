package figure;

public class Cerchio {
	private double raggio;
	
	public Cerchio (double raggio) throws Exception {
		if (raggio<0) {
			throw new Exception("Lunghezza raggio non valida");
		}	
		
		this.raggio=raggio;
	}
	
	public double calcolaCrf(){
		return 2*Math.PI*this.raggio;
	}

	public double calcolaArea() {
		return Math.PI*raggio*raggio;
	}
	public void stampaDati() {
		String result= "L'area del cerchio vale: "+calcolaArea()+"\nLa circonferenza vale: " +calcolaCrf();
		System.out.println(result);
	}

}
