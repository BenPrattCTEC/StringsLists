package tools.controller;

import tools.model.*;
import tools.view.*;

import java.lang.IndexOutOfBoundsException;

import java.util.ArrayList;

public class Controller {
	
	PopupDisplay gui = new PopupDisplay();
	private ArrayList<Kahoot> kahoots;
	
	public void start() {
		
		kahoots = new ArrayList<Kahoot>();
		
		// Kahoot(String topic, int questionCount, String creator)
		kahoots.add(new Kahoot("Math", 10, "Ben"));
		kahoots.add(new Kahoot("History", 10, "Chris"));
		kahoots.add(new Kahoot("English", 34, "Tom"));
		kahoots.add(new Kahoot("English", 34, "Tom"));
		
		// create new kahoot
		interactiveCreateKahoot();
		
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
		kahoots.add(new Kahoot(topic == null ? "" : topic, numOfQuestions, creator == null ? "" : creator));
	}
	
	private int findIndexByID(int ID) {
		for (int i = 0; i <= kahoots.size(); i++) {
			if (kahoots.get(i).getID() == ID) {
				return i;
			}
		}
		return -1;
	}
	
	public PopupDisplay getPopup() {
		return gui;
	}
	
	public ArrayList<Kahoot> getMyKahoots() {
		return (kahoots);
	}
	
}
