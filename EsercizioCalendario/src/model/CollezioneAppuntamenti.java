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
	
	public void aggiungiAppuntamento(Appuntamento appuntamento) {
		if(appuntamenti.isEmpty()) {
			appuntamenti.add(appuntamento);
		} else {
			if(!appuntamenti.contains(appuntamento)) {
				appuntamenti.add(appuntamento);
			}
			
		}
		
	}
	
	public void rimuoviAppuntamento(Appuntamento app) {
		appuntamenti.remove(app);
	}

}
