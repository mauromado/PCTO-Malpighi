package persone;

public class Main {

	public static void main(String[] args) throws Exception {
		Persona p = new Persona("marco","lelli",30);
		System.out.println(p.dettagli());
		Impiegato imp = new Impiegato("francesco","cassani",35, 100);
		System.out.println(imp.dettagli());
		imp.aumentaSalario(10);
		System.out.println(imp.dettagli());
	}

}
