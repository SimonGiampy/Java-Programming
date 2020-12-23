package home.designPatterns.miscellaneous;

import java.util.ArrayList;

/**
 * TODO: implement a class that copies the object to be memorized (Commands) and stores them in a backup array. Tip: use the Prototype Pattern
 */
class CommandHistory {
	
	private ArrayList<Command> history;
	
	protected CommandHistory() {
		history = new ArrayList<>();
	}
	
	
	protected void push(Command command) {
		history.add(command);
	}
	
	protected void pop() {
		if (!history.isEmpty()) history.remove(0);
	}



}
