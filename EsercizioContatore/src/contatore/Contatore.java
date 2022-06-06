package contatore;

public class Contatore {
	private int valore;
	
	public Contatore() {

	}


	public void reset(){
		valore=0;
	}
	
	public void inc(int inc){
		valore+=inc;
	}
	
	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}
	
	 public void toString(int valore) {
		 System.out.println( "il valore del contatore è: " +valore);
	}
}
