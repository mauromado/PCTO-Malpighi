package persistenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import model.Cpu;
import model.PcComponent;

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
	
	private void leggiCampiComuni(PcComponent component, StringTokenizer st) throws BadFileFormatException{
		component.setManufacturer(st.nextToken());
		component.setModel(st.nextToken());
		component.setPrice(parseFloat(st.nextToken(),"Prezzo non valido."));
		component.setDescription(st.nextToken());
		//boolean ---> parse boolean
		//local date ---> parse Local Date 
		//local date 2
	}
	
	private PcComponent readCpu(StringTokenizer st)throws BadFileFormatException{
		//check token count 
		Cpu cpu = new Cpu();
		leggiCampiComuni(cpu, st);
		//leggi campi non comuni 
		//int --> parse int 
		return cpu;
	}
	

	@Override
	public List<PcComponent> load(Reader reader)throws IOException, BadFileFormatException{
		BufferedReader buffReader = new BufferedReader(reader);
		ArrayList<PcComponent> listPcComponent = new ArrayList<PcComponent>();
		String line;
		
	}
}
