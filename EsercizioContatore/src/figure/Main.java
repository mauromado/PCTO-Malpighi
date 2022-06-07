package figure;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/**
	 	FiguraGeometrica f1 = new FiguraGeometrica(3);
		 
		
		try {
		FiguraGeometrica f2= new FiguraGeometrica(-1);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("il lato vale "+f1.getLato(2));
		
		try {
			System.out.println("il lato vale "+f1.getLato(8));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			f1.setLato(8,2);
			System.out.println("il lato vale "+f1.getLato(2));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("il perimetro vale "+f1.perimetro());
		*/
		Cerchio c1 = new Cerchio(5);
		Rattangolo r1 = new Rattangolo(2,4);
		Triangolo t1 = new Triangolo(2,4,5,2);
		
		c1.stampaArea();
		c1.toStringP();
		
		r1.stampaArea();
		r1.toStringP();
		
		t1.stampaArea();
		t1.toStringP();
	
	
	}

}
