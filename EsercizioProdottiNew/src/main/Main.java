package main;


import java.time.LocalDate;

import listaSpesa.ListaSpesa;
import prodotti.Prodotto;
import tipoProdotti.Alimentare;
import tipoProdotti.NonAlimentare;

public class Main {

	public static void main(String[] args) {
		//Prodotto p = new Prodotto("03245","controller",100);
		//p.applicaSconto();
		//System.out.println(p.toString());
		
		//System.out.println("\n");
		
		LocalDate data = LocalDate.of(2022,06,20);
		Alimentare a = new Alimentare("9449","limone",10,data);
		//a.applicaSconto();
		System.out.println(a.toString());
		
		//System.out.println("\n");
		
		/*NonAlimentare n = new NonAlimentare("8743","bottglia",20,"plastica");
		//System.out.println(n.toString());
		n.applicaSconto();
		//System.out.println(n.toString());
		
		
		ListaSpesa l1 = new ListaSpesa();
		l1.addProdotto(p);
		l1.addProdotto(n);
		l1.addProdotto(a);
		l1.stampaProdotti();*/
	}

}
