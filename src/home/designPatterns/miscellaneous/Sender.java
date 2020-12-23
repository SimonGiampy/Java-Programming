package home.designPatterns.miscellaneous;

import java.util.concurrent.*;

/**
 * generates commands at a certain predefined pace, and sends them to the Decider class, which elaborates it
 */
class Sender {
	
	public static void main(String[] args) {
		
		int numberOfCommands = 4;
		
		//schedules the execution of a new runnable every 500ms
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		Decider decider = new Decider();
		Generator generator = new Generator(decider);
		
		for (int i = 1; i <= numberOfCommands; i++) {
			scheduledExecutorService.schedule(generator, 500L * i, TimeUnit.MILLISECONDS);
		}
		
		//apply this line of code if you want to send unlimited requests for the Decider class (will be stopped only during debugging)
		//scheduledExecutorService.scheduleAtFixedRate(generator, 500L, 1000L, TimeUnit.MILLISECONDS);
		
		scheduledExecutorService.shutdown(); //shuts down only when it finishes the runnable scheduling
	}
	
	
	
}
