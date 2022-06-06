package main;

import contatore.Contatore;

public class Main
{
	public static void main(String[] args) {
		
		Contatore c1 = new Contatore();
		c1.reset();
		c1.inc(1);
		c1.getValore();
		c1.toString(c1.getValore());
		c1.inc(3);
		c1.inc(1);
		c1.getValore();
		c1.toString(c1.getValore());
	}
}
