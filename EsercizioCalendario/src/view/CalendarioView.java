package view;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;

import controller.Calendario;
import ioutils.StdInput;
import model.Appuntamento;
import model.CollezioneAppuntamenti;

public class CalendarioView {
	private Calendario calendario;
	private StdInput stdInput = new StdInput();
	private DateTimeFormatter localDateFormatter;
	private DateTimeFormatter localTimeFormatter;
	
	public CalendarioView() {
		Calendario calendario = new Calendario();
		localDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.ITALY);
		localTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.ITALY);
	}
	
	public void aggiungiAppuntamento() {
		System.out.println("----Data di inizio----");
		
		LocalDate dataInizio = chiediDataUtente();
		if(dataInizio==null) {
			return ;
		}
		LocalTime orarioInizio = chiediTimeUtente();
		if(orarioInizio==null) {
			return ;
		}
		LocalDateTime localDateTimeInizio = LocalDateTime.of(dataInizio, orarioInizio);
		
		
		System.out.println("Inserisci la durata (minuti): ");
		int durataInMinuti = stdInput.readInt(-1);
		if(durataInMinuti<0) {
			System.err.println("Durata non valida.");
			return;
		}
		Duration durata = Duration.ofMinutes(durataInMinuti);//vuole un long
		
		
		System.out.println("Insersci la descrizione dell appuntamento: ");
		String descrizione = stdInput.readString();
		
		
		Appuntamento nuovoAppuntemento = new Appuntamento(localDateTimeInizio,durata,descrizione);
		calendario.aggiungiAppuntamentoCalendario(nuovoAppuntemento);
		System.out.println("Inserimento avvenuto con successo ");
	}
	
	private LocalDate chiediDataUtente() {
		System.out.println("Inserisci la data (gg/mm/aa): ");
		String dataInserita = stdInput.readString();
		try {
			return LocalDate.parse(dataInserita, localDateFormatter);
		}catch(DateTimeParseException e){
			System.err.println("Formato data errato.");
			return null;
		}
		
	}
	
	private LocalTime chiediTimeUtente() {
		System.out.println("Inserisci l'orario (hh:mm): ");
		String orarioInserito = stdInput.readString();
		try {
			return LocalTime.parse(orarioInserito, localTimeFormatter);
		}catch(DateTimeParseException e){
			System.err.println("Formato orario errato.");
			return null;
		}
	}
	public void rimuoviAppuntamento() {
		LocalDate data = chiediDataUtente();
		if (data==null) {
			return;
		}
		CollezioneAppuntamenti giornalieri = calendario.getAppuntamentiGiornalieri(data);
		String[] nomiAppuntamenti = new String[giornalieri.getAppuntamenti().size()];
		
		for(int i=0;i<nomiAppuntamenti.length;i++) {
			nomiAppuntamenti[i] = giornalieri.getAppuntamenti().get(i).getDescrizione();
		}
		
		Menu menuRimozione = new Menu(nomiAppuntamenti,"Menu rimozione Appuntamenti"); 
		int appDaEliminare = menuRimozione.showAndGetOption();
		
		calendario.rimuoviAppuntamentoCalendario(giornalieri.getAppuntamenti().get(appDaEliminare-1));
		System.out.println("Rimozione avvenuta con successo.");
		
	}
}
