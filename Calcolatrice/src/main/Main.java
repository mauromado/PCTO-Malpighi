package main;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import operazioni.Divisione;
import operazioni.Moltiplicazione;
import operazioni.Somma;
import operazioni.Sottrazione;

public class Main {
	private static List<Integer> scelte = Arrays.asList(1,2,3,4);
	public static void main(String[] args) throws Exception {
		System.out.println("scegli l'operazione da eseguire:\n1 - Somma\n2 - Sottrazzione\n3 - Moltiplicazione\n4 - Divisione");
		Scanner sc = new Scanner(System.in);
		
		int scelta = sc.nextInt();
		
		if(!scelte.contains(scelta)) {
			throw new Exception("La scelta non è accettabile!");
		}
		
		System.out.println("inserire i due operandi: \n");
		double n1 = sc.nextDouble();
		double n2 = sc.nextDouble();
		
		switch(scelta){
			case 1:
				Somma s = new Somma(n1,n2);
				s.stampaSomma();
				break;
			
			case 2:
				Sottrazione st = new Sottrazione(n1,n2);
				st.stampaSottrazione();
				break;
			
			case 3:
				Moltiplicazione m = new Moltiplicazione(n1,n2);
				m.stampaMoltiplicazione();
				break;
			
			case 4:
				Divisione d = new Divisione(n1,n2);
				d.stampaDivisione();
		 		break;
		 	
			default:
			 
		}
		
		
	}

}
