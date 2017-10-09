package stringsLists.controller;

import stringsLists.model.*;
import stringsLists.view.*;
import java.lang.IndexOutOfBoundsException;

import java.util.ArrayList;

public class Controller {
	
	Popup gui = new Popup();
	
	ArrayList<Kahoot> kahoots;
	
	public void start() {
		
		kahoots = new ArrayList<Kahoot>();
		
		// Kahoot(String topic, String creator, int questionCount)
		kahoots.add(new Kahoot("Math", "Ben", 10));
		kahoots.add(new Kahoot("History", "Chris", 10));
		kahoots.add(new Kahoot("English", "Tom", 34));
		
		// create new kahoot
		// interactiveCreateKahoot();
		
		// remove a kahoot by ID
		try {
			String questionBuffer = gui.displayQuestion(kahootListToString() + "\nEnter the ID of the kahoot to remove");
			if (!removeKahoot(Integer.parseInt(questionBuffer == null ? "-1" : questionBuffer)))
				gui.displayText("Nothing was removed");
		}
		catch (Exception e) {
			e.printStackTrace();
			gui.displayText("Nothing was removed");
		}
		
		// display kahoots
		gui.displayText(kahootListToString());
		
	}
	
	// **-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-**
	
	
	private String kahootListToString() {
		String buffer = "";
		for (Kahoot i : kahoots) {
			buffer += i.toString() + "\n\n";
		}
		return buffer;
	}
	
	private boolean removeKahoot(int ID) {
		try {
			kahoots.remove(findIndexByID(ID));
			return true;
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private void interactiveCreateKahoot() {
		String topic = gui.displayQuestion("Enter Topic: ");
		String creator = gui.displayQuestion("Enter Author: ");
		int numOfQuestions = 0;
		while (numOfQuestions <= 0) {
			try {
				numOfQuestions = Integer.parseInt(gui.displayQuestion("Enter Number of Questions: "));
			}
			catch (Exception e) {
				e.printStackTrace();
				gui.displayText("Invalid number");
			}
		}
		kahoots.add(new Kahoot(topic == null ? "" : topic, creator == null ? "" : creator, numOfQuestions));
	}
	
	private int findIndexByID(int ID) {
		for (int i = 0; i <= kahoots.size(); i++) {
			if (kahoots.get(i).getID() == ID) {
				return i;
			}
		}
		return -1;
	}
	
	public Popup getPopup() {
		return gui;
	}
	
	public ArrayList<Kahoot> getMyKahoots() {
		return (ArrayList<Kahoot>) kahoots;
	}
	
}
