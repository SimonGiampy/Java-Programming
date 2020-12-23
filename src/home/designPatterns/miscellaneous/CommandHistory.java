package home.designPatterns.miscellaneous;

import java.util.ArrayList;

/**
 * stores a copy of the command objects in a single arraylist. This class communicates with Decider for the implementation of the Prototype pattern.
 */
class CommandHistory {
	
	private ArrayList<Command> history;
	
	//list initialization
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
