package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Ram extends PcComponent implements Serializable{
	private static final long serialVersionUID = 1L;
	private int capacityInMB;
	private String standard;
	private int frequencyInMHz;
	
	public Ram(String manufacturer, String model, float price, String description, boolean Available,
			LocalDate inserted, LocalDate outOfProduction, int capacityInMB, String standard, int frequencyInMHz) {
		super(manufacturer, model, price, description, Available, inserted, outOfProduction);
		this.capacityInMB = capacityInMB;
		this.standard = standard;
		this.frequencyInMHz = frequencyInMHz;
	}
	
	public Ram() {
		
	}

	public int getCapacityInMB() {
		return capacityInMB;
	}

	public void setCapacityInMB(int capacityInMB) {
		this.capacityInMB = capacityInMB;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public int getFrequencyInMHz() {
		return frequencyInMHz;
	}

	public void setFrequencyInMHz(int frequencyInMHz) {
		this.frequencyInMHz = frequencyInMHz;
	}
	
	
	
	
}
