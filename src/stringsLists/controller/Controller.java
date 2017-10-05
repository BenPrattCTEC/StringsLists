package stringsLists.controller;
import stringsLists.model.*;
import stringsLists.view.*;

import java.util.ArrayList;

public class Controller {
	
	GuiController gui = new GuiController();
	
	public void start(){
		
		ArrayList<Kahoot> kahoots = new ArrayList<Kahoot>();
		
		//Kahoot(String topic, String creator, int questionCount)
		kahoots.add(new Kahoot("Math","Ben", 10));
		
		showKahoots(kahoots);
		
	}
	
	private void showKahoots(ArrayList<Kahoot> list){
		String buffer = "";
		for(Kahoot i: list){
			buffer+=i.toString() + "\n";
		}
		gui.displayText(buffer);
	}
}
