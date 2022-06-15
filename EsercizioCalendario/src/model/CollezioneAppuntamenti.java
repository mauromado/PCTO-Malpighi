package model;

import java.util.ArrayList;
import java.util.List;

public class CollezioneAppuntamenti {
	private List<Appuntamento> appuntamenti;
	
	public CollezioneAppuntamenti() {
		this.appuntamenti= new ArrayList<>();
	}

	public List<Appuntamento> getAppuntamenti() {
		return appuntamenti;
	}

	public void setAppuntamenti(List<Appuntamento> appuntamenti) {
		this.appuntamenti = appuntamenti;
	}
	
	public void aggiuntaAppuntamento(Appuntamento app) {
		for(Appuntamento a : appuntamenti) {
			if(a.equals(app)) {
				System.out.println("l'appuntamento è gia presente");
			}
			else {
				appuntamenti.add(app);
			}
		}
		
	}
	
	public void rimuoviAppuntamento(Appuntamento app) {
		appuntamenti.remove(app);
	}

}
