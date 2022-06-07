package figure;
import java.lang.Math;

public class Triangolo extends FiguraGeometrica{
	private double altezza;
	private double lato1;
	private double lato2;
	private double lato3;
	public Triangolo( double lato1, double lato2, double lato3, double altezza) throws Exception {
		super(3);
		this.lato1 = lato1;
		this.lato2 = lato2;
		this.lato3 = lato3;
		this.altezza=altezza;
		setLato(lato1,1);
		setLato(lato2,2);
		setLato(lato1,3);
	}
	@Override
	double area() {
		return lato1*altezza/2;
	}
	
	public void stampaArea() {
		 System.out.println( "l'area del triangolo vale: " +this.area() );
	}

}
