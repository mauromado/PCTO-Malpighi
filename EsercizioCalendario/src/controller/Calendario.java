package controller;

import model.Appuntamento;
import model.CollezioneAppuntamenti;

public class Calendario {
	private CollezioneAppuntamenti appuntamenti;
	
	public Calendario() {
		this.appuntamenti = new CollezioneAppuntamenti();
	}
	
	public void aggiuntaAppuntamento(Appuntamento app) {
		if(appuntamenti.getAppuntamenti().contains(app)) {
			System.out.println("l'appuntamento è gia presente");
		}
		else {
			appuntamenti.getAppuntamenti().add(app);
		}
	}
}
