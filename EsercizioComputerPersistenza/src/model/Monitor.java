package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Monitor extends PcComponent implements Serializable{
	private static final long serialVersionUID = 1L;
	private String resolution;
	private String aspectRatio;
	private int responseTimeInMs;
	
	public Monitor(String manufacturer, String model, float price, String description, boolean Available,
			LocalDate inserted, LocalDate outOfProduction, String resolution, String aspectRatio,
			int responseTimeInMs) {
		super(manufacturer, model, price, description, Available, inserted, outOfProduction);
		this.resolution = resolution;
		this.aspectRatio = aspectRatio;
		this.responseTimeInMs = responseTimeInMs;
	}
	
	public Monitor() {
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(String aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	public int getResponseTimeInMs() {
		return responseTimeInMs;
	}

	public void setResponseTimeInMs(int responseTimeInMs) {
		this.responseTimeInMs = responseTimeInMs;
	}
	
}
