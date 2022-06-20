package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Cpu extends PcComponent implements Serializable{
	private static final long serialVersionUID = 1L;
	private int numberOfCores;
	private float frequencyInGHz;
	private boolean integratedGpu;
	
	public Cpu(String manufacturer, String model, float price, String description, boolean Available,
			LocalDate inserted, LocalDate outOfProduction, int numberOfCores, float frequencyInGHz,
			boolean integratedGpu) {
		super(manufacturer, model, price, description, Available, inserted, outOfProduction);
		this.numberOfCores = numberOfCores;
		this.frequencyInGHz = frequencyInGHz;
		this.integratedGpu = integratedGpu;
	}
	
	public Cpu() {
	}

	public int getNumberOfCores() {
		return numberOfCores;
	}

	public void setNumberOfCores(int numberOfCores) {
		this.numberOfCores = numberOfCores;
	}

	public float getFrequencyInGHz() {
		return frequencyInGHz;
	}

	public void setFrequencyInGHz(float frequencyInGHz) {
		this.frequencyInGHz = frequencyInGHz;
	}

	public boolean isIntegratedGpu() {
		return integratedGpu;
	}

	public void setIntegratedGpu(boolean integratedGpu) {
		this.integratedGpu = integratedGpu;
	}
	
	
	
}
