package figure;
import java.lang.Exception;

public abstract class FiguraGeometrica {
	private int nLati;
	private double[] lati;
	
	
	public FiguraGeometrica(int nLati) throws Exception {
		if(nLati<=0) {
			throw new Exception	("numero lati minore uguale di 0");
		}
		
		this.nLati=nLati;
		lati = new double [nLati];
		int i;
		for(i=0;i<nLati;i++) {
			lati [i]=0;
		}
	}


	public double getLato(int posizioneLato) throws Exception{
		if (posizioneLato>nLati || posizioneLato<1) {
			throw new Exception(" getLato- posizione del lato non valida");
		}
		return lati[posizioneLato-1];
	}


	public void setLato(double lato, int posizioneLato) throws Exception {
		if (posizioneLato>nLati || posizioneLato<1) {
			throw new Exception(" setLato- posizione del lato non valida");
		}
		if (lato<0) {
			throw new Exception(" setLato- lunghezza del lato non valida");
		}
		lati[posizioneLato-1]= lato ;
	}
	
	public double perimetro() {
		double perimetro = 0.0;
		for(int i=0;i<nLati;i++) {
			perimetro+= lati[i];
		}
		return perimetro;
	}
	
	abstract double area();
	
	public void toStringP() {
		 System.out.println( "il perimetro vale: " + this.perimetro() );
	}
		
}
