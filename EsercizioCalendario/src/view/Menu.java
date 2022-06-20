package view;

import ioutils.StdInput;

public class Menu {
	private String[] menuItems;
	private String titolo;
	private StdInput stdInput = new StdInput();
	
	public Menu(String[] menuItems, String titolo) {
		this.menuItems = menuItems;
		this.titolo = titolo;
	}
	
	private void show() {
		System.out.println("**** "+titolo+" ****");
		System.out.println();
		for(int i = 0; i < menuItems.length; i++) {
			System.out.print(i+1);
			System.out.println(" - "+menuItems[i]);
		}
		System.out.println("0 - Termina");
		System.out.println("Scegli ...");
	}
	
	private int getOption() {
		int option;
		do {
			option = stdInput.readInt(-1);
			if(option<0||option>menuItems.length) {
				System.out.println("Scelta non valida.");
			}
		}while(option<0||option>menuItems.length);
		
		return option;
	}
	
	public int showAndGetOption() {
		show();
		return getOption();
	}
}
