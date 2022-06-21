package model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class PcComponent implements Serializable {
	private static final long serialVersionUID = 1L;
	private String description;
	private LocalDate inserted;
	private String manufacturer;
	private String model;
	private LocalDate outOfProduction;
	private float price;
	private boolean Available; 
	
	public PcComponent(String manufacturer,  String model, float price, String description,  boolean Available,
			LocalDate inserted, LocalDate outOfProduction) {
		this.description = description;
		this.inserted = inserted;
		this.manufacturer = manufacturer;
		this.model = model;
		this.outOfProduction = outOfProduction;
		this.price = price;
		this.Available=Available;
	}
	
	public PcComponent() {
		
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getInserted() {
		return inserted;
	}

	public void setInserted(LocalDate inserted) {
		this.inserted = inserted;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDate getOutOfProduction() {
		return outOfProduction;
	}

	public void setOutOfProduction(LocalDate outOfProduction) {
		this.outOfProduction = outOfProduction;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public boolean isAvailable() {
		return Available;
	}

	public void setAvailable(boolean Available) {
		this.Available = Available;
	}
}
