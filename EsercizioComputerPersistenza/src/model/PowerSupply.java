package model;

import java.io.Serializable;
import java.time.LocalDate;

public class PowerSupply extends PcComponent implements Serializable {
	private static final long serialVersionUID = 1L;
	private int powerOutputInW;
	private String certification;
	
	public PowerSupply(String manufacturer, String model, float price, String description, boolean Available,
			LocalDate inserted, LocalDate outOfProduction, int powerOutputInW, String certification) {
		super(manufacturer, model, price, description, Available, inserted, outOfProduction);
		this.powerOutputInW = powerOutputInW;
		this.certification = certification;
	}
	
	public PowerSupply() {
		
	}

	public int getPowerOutputInW() {
		return powerOutputInW;
	}

	public void setPowerOutputInW(int powerOutputInW) {
		this.powerOutputInW = powerOutputInW;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}
	
	
}
