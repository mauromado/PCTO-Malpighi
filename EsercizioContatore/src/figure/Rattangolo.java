package figure;

public class Rattangolo extends FiguraGeometrica{
	private double lato1;
	private double lato2;
	
	public Rattangolo( double lato1, double lato2) throws Exception {
		super(4);
		this.lato1 = lato1;
		this.lato2 = lato2;
		setLato(lato1,1);
		setLato(lato2,2);
		setLato(lato1,3);
		setLato(lato2,4);
	}

	@Override
	double area() {
		return lato1*lato2;
	}
	
	public void stampaArea() {
		 System.out.println( "l'area del rettanagolo vale: " +this.area() );
	}
	
}
