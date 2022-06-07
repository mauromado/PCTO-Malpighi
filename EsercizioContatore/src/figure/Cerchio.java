package figure;

public class Cerchio extends FiguraGeometrica{
	private double raggio;
	
	public Cerchio (double raggio) throws Exception{
		super(1);
		this.raggio=raggio;
		setLato(2*Math.PI*this.raggio,1);
	}

	@Override
	double area() {
		return Math.PI*raggio*raggio;
	}
	public void stampaArea() {
		 System.out.println( "l'area del cerchio vale: " +this.area() );
	}

}
