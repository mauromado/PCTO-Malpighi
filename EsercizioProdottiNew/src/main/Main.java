package main;


import java.time.LocalDate;
import java.util.Scanner;

import listaSpesa.ListaSpesa;
import prodotti.Prodotto;
import tipoProdotti.Alimentare;
import tipoProdotti.NonAlimentare;

public class Main {

	public static void main(String[] args) {
		/*Prodotto p = new Prodotto("03245","controller",100);
		p.applicaSconto();
		System.out.println(p.toString());
		
		System.out.println("\n");
		LocalDate data = LocalDate.of(2022,06,20);
		Alimentare a = new Alimentare("9449","limone",10,data);
		a.applicaSconto();

				System.out.println(a.toString());
		
		System.out.println("\n");
		
		NonAlimentare n = new NonAlimentare("8743","bottglia",20,"plastica");
		System.out.println(n.toString());
		n.applicaSconto();
		System.out.println(n.toString());
		
		
		ListaSpesa l1 = new ListaSpesa();
		l1.addProdotto(p);
		l1.addProdotto(n);
		l1.addProdotto(a);
		l1.stampaProdotti();*/
		Scanner sc = new Scanner(System.in);
		String scelta = "N";
		String tipoProdotto="n/d";
		String codice = "n/d";
		String descrizione= "n/d";
		String materiale="n/d";
		double prezzo=0;
		int giorno=0;
		int mese=0;
		int anno=0;
		ListaSpesa l1 = new ListaSpesa();
		do {
			System.out.println("Inserisci il tipo di prodotto (A/N): ");
			tipoProdotto=sc.next();
			System.out.println("Inserisci il codice del prodotto: ");
			codice=sc.next();
			System.out.println("Inserisci la descrizione del prodotto: ");
			descrizione=sc.next();
			System.out.println("Inserisci il prezzo del prodotto (00.00): ");
			prezzo=sc.nextDouble();
			if(tipoProdotto.equals("A")) {
				System.out.println("Inserisci la scadenza del prodotto (dd-MM-yyyy): ");
				System.out.println("Inserisci il giorno: ");
				giorno=sc.nextInt();
				System.out.println("Inserisci il mese (1-12): ");
				mese=sc.nextInt();
				System.out.println("Inserisci l'anno: ");
				anno=sc.nextInt();
				LocalDate scadenza = LocalDate.of(anno,mese,giorno);
				LocalDate actualDate = LocalDate.now();
				if(scadenza.isBefore(actualDate)) {
					System.out.println("La scadenza deve essere successiva alla data attuale,"
							+ " prodotto non aggiunto alla lista");
				}else {
				Alimentare a = new Alimentare(codice,descrizione,prezzo,scadenza);
				l1.addProdotto(a);
				}
			}else {
				System.out.println("Inserisci il materiale del prodotto: ");
				materiale=sc.next();
				NonAlimentare n = new NonAlimentare(codice,descrizione,prezzo,materiale);
				l1.addProdotto(n);
			}
			System.out.println("aggiungere un altro prodotto? (S/N)");
			scelta=sc.next();
		}while(scelta.equals("S"));
		l1.stampaProdotti();
		System.out.println("Possiedi la tessera fedeltà? (S/N)");
		if(sc.next().equals("S")) {
			l1.calcolaPrezzoTotSconto();
			l1.stampaProdotti();
		}
		
		
	}

}
