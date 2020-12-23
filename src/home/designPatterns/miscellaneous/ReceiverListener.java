package home.designPatterns.miscellaneous;

/**
 * Observer Design Pattern
 */
interface ReceiverListener {
	
	/**
	 * this method is called when the sender class generates a Command and passes it to the recipient (Decider). This pattern serves for avoiding
	 * to wait for an indefinite amount of time, and instead, elaborates the object only when received.
	 * @param command the object sent and to be received
	 */
	void onCommandReceived(Command command);
}
