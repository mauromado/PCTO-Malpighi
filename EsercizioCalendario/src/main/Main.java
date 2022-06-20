package main;

import view.CalendarioView;
import view.Menu;

public class Main {
	
	public static void main (String[] args) {
	 CalendarioView calendario = new CalendarioView();	
	 int option;
	do {
		String[] menuItems = new String[] {
				"Aggiungi appuntamento","Rimuovi appuntamento","Appuntamenti Giornalieri",
				"Appuntamenti Settimanali","Appuntamenti mensili","Vedi tutti"};
		Menu menu = new Menu(menuItems , "AGENDA VITTORIO" );
		option = menu.showAndGetOption();
		switch(option) {
		case 1: calendario.aggiungiAppuntamento();
			break;
		case 2: calendario.rimuoviAppuntamento();
			break;
		case 3: calendario.stampaAppuntamentiGiornalieri();
			break;
		case 4: calendario.stampaAppuntamentiSettimana();
			break;
		case 5: calendario.stampaAppuntamentiMese();
			break;
		case 6: calendario.StampaAppuntamenti();
			break;
		default: 
		}
	}while (option!=0);
	}
}
