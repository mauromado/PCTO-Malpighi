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
	

}
