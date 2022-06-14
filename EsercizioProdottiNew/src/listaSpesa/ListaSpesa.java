package listaSpesa;

import java.util.ArrayList;
import java.util.List;

import prodotti.Prodotto;

public class ListaSpesa {
	public List<Prodotto> prodotti;

	public ListaSpesa() {
		prodotti=new ArrayList<>();
	}
	
	public void addProdotto(Prodotto p) {
		prodotti.add(p);
		
	}
	public double calcolaPrezzoTot() {
		double prezzoTot=0;
		for(int i=0;i<prodotti.size();i++) {
			prezzoTot+=prodotti.get(i).getPrezzo();
		}
		return prezzoTot;
	}
	
	public void stampaProdotti() {
		System.out.println("la tua lista della spesa è composta da: ");
		for(int i=0;i<prodotti.size();i++) {
			System.out.println(prodotti.get(i).toString()+"\n");
		}
		System.out.println("La spesa totale è di: "+calcolaPrezzoTot()+" €");
	}
	
	
}
