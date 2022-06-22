package testPersistenza;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Cpu;
import model.Monitor;
import model.PcComponent;
import model.PowerSupply;
import model.Ram;
import persistenza.BadFileFormatException;
import persistenza.MyPcComponentPersister;

public class MyPcComponentPersisterTest {
	
	private boolean confrontoFile(String file1, String file2) throws IOException {
		FileReader reader1 = new FileReader(file1);
		FileReader reader2 = new FileReader(file2);
		BufferedReader buff1 = new BufferedReader(reader1);
		BufferedReader buff2 = new BufferedReader(reader2);
		String line1 = "", line2 = "" ;
		while((line1 = buff1.readLine())!= null) {
			line2 = buff2.readLine();
			if(line2==null||!line1.contains(line2)) {
				return false;
			}
		}
		return true;
	}
	
	
	@Test 
	public void letturaScritturaTest() throws IOException, BadFileFormatException {
		List<PcComponent> lista = new ArrayList<PcComponent>();
		LocalDate data1 = LocalDate.of(2015,04,28);
		LocalDate data2 = LocalDate.of(2016,01,01);
		Cpu cpu = new Cpu("Cpu","intel",7.3f,"BX80662I76700K Box Core I7-6700K",true,data1,data2,4,2.5f,true);
		Ram ram = new Ram("Ram","Kingston",19.98f,"KVR16LS11/4 Non-ECC CL11 SODIMM",true,data1,data2,4096,"DDR3",1600);
		Monitor monitor = new Monitor("Monitor","Benq",104f,"GW2270H Display da 21,5'' Full-HD",true,data1,data2,"1920x1080","16:9",25);
		PowerSupply p = new PowerSupply("PowerSupply","Thermaltake",54.9f,"Smart SE Alimentatore Modulare",true,data1,data2,530,"n.a.");
		lista.add(p);
		lista.add(monitor);
		lista.add(ram);
		lista.add(cpu);
		FileWriter writer = new FileWriter("damp1.txt");
		FileReader reader = new FileReader("damp1.txt");
		MyPcComponentPersister per1 = new MyPcComponentPersister();
		per1.save(lista, writer);
		List<PcComponent> lista2 = new ArrayList<PcComponent>();
		lista2 = per1.load(reader);
		FileWriter writer2 = new FileWriter("damp2.txt");
		per1.save(lista2, writer2);
		assertTrue(confrontoFile("damp1.txt", "damp2.Txt"));
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testLoadFailForPrice() throws IOException, BadFileFormatException {
		String toRead = "Ram;Kingston;KVR16LS11/4;19.xe98;Non-ECC CL11 SODIMM;Y;2016-04-28;2017-04-15;4096;DDR3;1600;"+
				"Cpu;Intel;BX80662I76700K;34xe7.3;Box Core I7-6700K;Y;2015-04-28;2016-01-01;4;3.5;Y;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testLoadFailForAvailability() throws IOException, BadFileFormatException {
		String toRead = "Ram;Kingston;KVR16LS11/4;19.98;Non-ECC CL11 SODIMM;l;2016-04-28;2017-04-15;4096;DDR3;1600;"+
				"Cpu;Intel;BX80662I76700K;347.3;Box Core I7-6700K;Y;2015-04-28;2016-01-01;4;3.5;Y;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testLoadFailForDate1Format() throws IOException, BadFileFormatException {
		String toRead = "Ram;Kingston;KVR16LS11/4;19.98;Non-ECC CL11 SODIMM;Y;201-04-28;2017-04-15;4096;DDR3;1600;"+
				"Cpu;Intel;BX80662I76700K;347.3;Box Core I7-6700K;Y;2015-04-28;2016-01-01;4;3.5;Y;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testLoadFailForDate2Format() throws IOException, BadFileFormatException {
		String toRead = "Ram;Kingston;KVR16LS11/4;19.98;Non-ECC CL11 SODIMM;Y;2016-04-28;217-04-15;4096;DDR3;1600;"+
				"Cpu;Intel;BX80662I76700K;347.3;Box Core I7-6700K;Y;2015-04-28;2016-01-01;4;3.5;Y;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testLessTokenRam() throws IOException, BadFileFormatException {
		String toRead = "Ram;Kingston;KVR16LS11/4;19.98;Non-ECC CL11 SODIMM;Y;2016-04-28;217-04-15;4096;DDR3;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testLessTokenPowerSupply() throws IOException, BadFileFormatException {
		String toRead = "PowerSupply;Thermaltake;Smart SE;54.9;Alimentatore Modulare;Y;2016-03-04;2016-04-04;530;n.a;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testLessTokenCpu() throws IOException, BadFileFormatException {
		String toRead = "Cpu;Intel;BX80662I76700K;347.3;Box Core I7-6700K;Y;2015-04-28;2016-01-01;4;3.5;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testLessTokenMonitor() throws IOException, BadFileFormatException {
		String toRead = "Monitor;Benq;GW2270H;104;Display da 21,5'' Full-HD;Y;2015-02-02;-;1920x1080;16:9;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testNumberOfCoreCpuFail() throws IOException, BadFileFormatException {
		String toRead = "Cpu;Intel;BX80662I76700K;347.3;Box Core I7-6700K;Y;2015-04-28;2016-01-01;4sa;3.5;Y;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testFrequencyCpuFail() throws IOException, BadFileFormatException {
		String toRead = "Cpu;Intel;BX80662I76700K;347.3;Box Core I7-6700K;Y;2015-04-28;2016-01-01;4;3.5a;Y;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testIntGpuCpuFail() throws IOException, BadFileFormatException {
		String toRead = "Cpu;Intel;BX80662I76700K;347.3;Box Core I7-6700K;Y;2015-04-28;2016-01-01;4;3.5;dsa;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testCapacityRamFail() throws IOException, BadFileFormatException {
		String toRead = "Ram;Kingston;KVR16LS11/4;19.98;Non-ECC CL11 SODIMM;Y;2016-04-28;217-04-15;40ds96;DDR3;100;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testFrequencyRamFail() throws IOException, BadFileFormatException {
		String toRead = "Ram;Kingston;KVR16LS11/4;19.98;Non-ECC CL11 SODIMM;Y;2016-04-28;217-04-15;4096;DDR3;1600aa;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testPowerPowerSupplyFail() throws IOException, BadFileFormatException {
		String toRead = "PowerSupply;Thermaltake;Smart SE;54.9;Alimentatore Modulare;Y;2016-03-04;2016-04-04;53as0;n.a.;";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
	
	@Test(expected=BadFileFormatException.class)
	public void testResponceTimeMonitor() throws IOException, BadFileFormatException {
		String toRead = "Monitor;Benq;GW2270H;104;Display da 21,5'' Full-HD;Y;2015-02-02;-;1920x1080;16:9;2sad5";
		StringReader reader = new StringReader(toRead);
		MyPcComponentPersister persister = new MyPcComponentPersister();
		persister.load(reader);
	}
}
