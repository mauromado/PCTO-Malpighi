package persistenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import java.util.Locale;
import java.util.StringTokenizer;

import model.Cpu;
import model.Monitor;
import model.PcComponent;
import model.PowerSupply;
import model.Ram;

public class MyPcComponentPersister implements PcComponentPersister{
	private static final String SEPARATOR = ";";
	private static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance(Locale.ITALY);
	
	
	private PcComponent readComponent(String line) throws BadFileFormatException {
		 StringTokenizer st = new StringTokenizer(line,SEPARATOR);
		 if(!st.hasMoreTokens()) {
			 throw new BadFileFormatException("Manca il tipo del componente.");
		 }
		 String componentType = st.nextToken();
		 switch(componentType.toLowerCase()) {
		 case "cpu": 
			 return readCpu(st);
		 case "ram":
			 return readRam(st);
		 case "powersupply":
			 return readPowerSupply(st);
		 case "monitor":
			 return readMonitor(st);
		default:
			throw new BadFileFormatException("Formato del nome non valido.");
		}
		 
		 
	}
	
	private float parseFloat(String numero, String message) throws BadFileFormatException{
		try {
			Number value = NUMBER_FORMAT.parse(numero);
			return value.floatValue();
		}catch(ParseException e) {
			throw new BadFileFormatException(message);
		}
	}
	
	private boolean parseBoolean(String bool, String message)throws BadFileFormatException{
		bool.toLowerCase();
		if(bool.contains("y")) {
			return true;
		}
		if(bool.contains("n")) {
			return false;
		}
		throw new BadFileFormatException(message);
	}
	
	private LocalDate parseLocalDate(String localDate, String message) throws BadFileFormatException {
		try {
			LocalDate data = null;
			LocalDate.parse(localDate);
			return data;
		}catch(DateTimeParseException e) {
			throw new BadFileFormatException(message);
		}
	}
	
	private int parseInt(String numero,String message) throws BadFileFormatException {
		try {
			Number value = NUMBER_FORMAT.parse(numero);
			return value.intValue();
		}catch(ParseException e) {
			throw new BadFileFormatException(message);
		}
	}
	
	private void leggiCampiComuni(PcComponent component, StringTokenizer st) throws BadFileFormatException{
		component.setManufacturer(st.nextToken());
		component.setModel(st.nextToken());
		component.setPrice(parseFloat(st.nextToken(),"Prezzo non valido."));
		component.setDescription(st.nextToken());
		component.setAvailable(parseBoolean(st.nextToken(),"Availability non valida."));
		component.setInserted(parseLocalDate(st.nextToken(),"Formato data non valido."));
		component.setOutOfProduction(parseLocalDate(st.nextToken(),"Formato data non valido."));
	}
	
	private PcComponent readCpu(StringTokenizer st)throws BadFileFormatException{
		if(st.countTokens()!=10) {
			throw new BadFileFormatException("File scritto in modo errato.");
		}
		Cpu cpu = new Cpu();
		leggiCampiComuni(cpu, st);
		cpu.setNumberOfCores(parseInt(st.nextToken(),"Numero di core non valido."));
		cpu.setFrequencyInGHz(parseInt(st.nextToken(),"Frequenza non valida."));
		cpu.setIntegratedGpu(parseBoolean(st.nextToken(),"Integrazione gpu non valida."));
		return cpu;
	}
	
	private PcComponent readRam(StringTokenizer st) throws BadFileFormatException {
		if(st.countTokens()!=10) {
			throw new BadFileFormatException("File scritto in modo errato.");
		}
		Ram ram = new Ram();
		leggiCampiComuni(ram,st);
		ram.setCapacityInMB(parseInt(st.nextToken(),"Capacita non valida."));
		ram.setStandard(st.nextToken());
		ram.setFrequencyInMHz(parseInt(st.nextToken(),"Frequenza non valida"));
		return ram;
	}
	
	private PcComponent readPowerSupply(StringTokenizer st) throws BadFileFormatException {
		if(st.countTokens()!=9) {
			throw new BadFileFormatException("File scritto in modo errato.");
		}
		PowerSupply p = new PowerSupply();
		leggiCampiComuni(p,st);
		p.setPowerOutputInW(parseInt(st.nextToken(),"Potenza in output non valida."));
		p.setCertification(st.nextToken());
		return p;
	}
	
	private PcComponent readMonitor(StringTokenizer st) throws BadFileFormatException {
		if(st.countTokens()!=10) {
			throw new BadFileFormatException("File scritto in modo errato.");
		}
		Monitor monitor = new Monitor();
		leggiCampiComuni(monitor,st);
		monitor.setResolution(st.nextToken());
		monitor.setAspectRatio(st.nextToken());
		monitor.setResponseTimeInMs(parseInt(st.nextToken(),"Tempo di risposta del monitor non valido"));
		return monitor;
	}
	
	@Override
	public List<PcComponent> load(Reader reader)throws IOException, BadFileFormatException{
		BufferedReader buffReader = new BufferedReader(reader);
		ArrayList<PcComponent> listPcComponent = new ArrayList<PcComponent>();
		String line;
		while((line = buffReader.readLine())!= null) {
			PcComponent comp = readComponent(line);
			listPcComponent.add(comp);
		}
		return listPcComponent;
	}
	
	private String toLineComponent(PcComponent comp) {
		String componentType = comp.getManufacturer();
		 switch(componentType.toLowerCase()) {
		 case "cpu": 
			 return toLineCpu((Cpu) comp);
		 case "ram":
			 return toLineRam((Ram) comp);
		 case "powersupply":
			 return toLinePowerSupply((PowerSupply) comp);
		 case "monitor":
			 return toLineMonitor((Monitor) comp);
		default:
		}
		return null;
	}
	
	private String toLineBoolean(Boolean bool) {
		if(bool==true) {
			String result = "Y";
			return result;
		}
		String result = "N";
		return result;
	}
	
	private StringBuilder toLineCampiComuni(PcComponent comp) {
		StringBuilder line = new StringBuilder();
		line.append(comp.getManufacturer()).append(";")
			.append(comp.getModel()).append(";")
			.append(comp.getPrice()).append(";")
			.append(comp.getDescription()).append(";")
			.append(toLineBoolean(comp.isAvailable())).append(";")
			.append(comp.getInserted().toString()).append(";")
			.append(comp.getOutOfProduction().toString()).append(";");
		return line;
	}
	
	
	private String toLineCpu(Cpu cpu) {
		StringBuilder line = new StringBuilder();
		line = toLineCampiComuni(cpu);
		line.append(cpu.getNumberOfCores()).append(";")
			.append(cpu.getFrequencyInGHz()).append(";")
			.append(toLineBoolean(cpu.isIntegratedGpu())).append(";");
		return line.toString();
	}
	
	private String toLineRam(Ram ram) {
		StringBuilder line = new StringBuilder();
		line = toLineCampiComuni(ram);
		line.append(ram.getCapacityInMB()).append(";")
			.append(ram.getStandard()).append(";")
			.append(ram.getFrequencyInMHz()).append(";");
		return line.toString();
	}
	
	private String toLinePowerSupply(PowerSupply p) {
		StringBuilder line = new StringBuilder();
		line = toLineCampiComuni(p);
		line.append(p.getPowerOutputInW()).append(";")
			.append(p.getCertification()).append(";");
		return line.toString();
	}
	
	private String toLineMonitor(Monitor monitor) {
		StringBuilder line = new StringBuilder();
		line = toLineCampiComuni(monitor);
		line.append(monitor.getResolution()).append(";")
			.append(monitor.getAspectRatio()).append(";")
			.append(monitor.getResponseTimeInMs()).append(";");
		return line.toString();
	}
	
	@Override
	public void save(List<PcComponent> list, Writer writer) throws IOException {
		String line = null;
		for(PcComponent elemento : list) {
			line = toLineComponent(elemento);
			writer.write(line);
		}
		
		
	}
}
