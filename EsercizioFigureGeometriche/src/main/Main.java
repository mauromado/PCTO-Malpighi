package main;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import figure.Cerchio;
import figure.Rettangolo;
import figure.Triangolo;



public class Main {
	
	private static List<String> figure = Arrays.asList("1","2","3");
	
	private static void gestisciRettangolo()throws Exception{
		double lato1, lato2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("inserisci lato 1: ");
		lato1 = sc.nextDouble();
		
		System.out.println("inserisci lato 2: ");
		lato2 = sc.nextDouble();
		
		Rettangolo r = new Rettangolo(lato1,lato2);
		r.stampaDati();
	}
	
	private static void gestisciCerchio()throws Exception{
		double raggio;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("inserisci raggio: ");
		raggio = sc.nextDouble();
		
		Cerchio c = new Cerchio(raggio);
		c.stampaDati();
	}
	
	private static void gestisciTriangolo()throws Exception{
		double base,lato2,lato3,altezza;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("inserisci base: ");
		base= sc.nextDouble();
		
		System.out.println("inserisci lato 2: ");
		lato2 = sc.nextDouble();
		
		System.out.println("inserisci lato 3: ");
		lato3= sc.nextDouble();		
		
		System.out.println("inserisci altezza: ");
		altezza = sc.nextDouble();
		
		Triangolo t = new Triangolo(base,lato2,lato3,altezza);
		t.stampaDati();
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Scegli la figura:");
		System.out.println("1 - Rettangolo\n2 - Cerchio\n3 - Triangolo");
		
		Scanner sc = new Scanner(System.in);
		String scelta = sc.next();
		
		if(!figure.contains(scelta)){
			throw new Exception("Formato non valido!");
		}
		
		switch(scelta) {
			case "1":
				gestisciRettangolo();
				break;
			case "2":
				gestisciCerchio();
				break;
			case "3":
				gestisciTriangolo();
				break;
				
			default:
		}
	
	}

}
