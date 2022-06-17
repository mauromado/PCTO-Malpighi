package ioutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdInput {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public String readString() {
		String line = null;
		try {
			line = reader.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	public int readInt(int err) {
		int opzione = err;
		try {
			String line = readString();
			if(line!=null) {
				opzione = Integer.parseInt(line);
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		
		return opzione;
	}
}
