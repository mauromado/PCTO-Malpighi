package figure;
import java.lang.Math;

public class Triangolo {
	private double altezza;
	private double base;
	private double lato2;
	private double lato3;
	
	public Triangolo( double base, double lato2, double lato3, double altezza) throws Exception {
		if (base<0) {
			throw new Exception("Lunghezza base non valida");
		}	
		if (lato2<0) {
			throw new Exception("Lunghezza lato2 non valida");
		}	
		if (lato3<0) {
			throw new Exception("Lunghezza lato3 non valida");
		}	
		if (altezza<0) {
			throw new Exception("Lunghezza altezza non valida");
		}
		if (base>lato2+lato3 || lato2>base+lato3 || lato3>base+lato2) {
			throw new Exception("Il triangolo non rispetta la disuguagliaza triangolare");
		}
		
		
		this.base = base;
		this.lato2 = lato2;
		this.lato3 = lato3;
		this.altezza=altezza;
	}
	
	
	public double calcolaPerimetro() {
		return base+lato2+lato3;
	}
	
	public double calcolaArea() {
		return base*altezza/2;
	}
	
	
	public void stampaDati() {
		String result= "L'area del triangolo vale: "+calcolaArea()+"\nIl perimetro vale: " +calcolaPerimetro();
		System.out.println(result);
	}
}
