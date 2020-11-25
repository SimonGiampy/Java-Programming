package home.concurrency.pizzeria;

import java.util.concurrent.*;

/**
 * this class generates randomly new clients who make orders
 */
class GennaroTheClientManager {
	
	//list of names for the clients
	private final String[] clientNames = {"Fricca 'o ncapac",  "nonno Prullo", "Peppe 'o Murator", "Roccu u zimbaru",
			"Sara a menza scupetta", "Loredana sacciututtu", "Peppe u tenent", "Daniele Banana Joe", "Maria 'a bambula",
			"Biagino u pulmanista", "Daniele 'u dalton", "Rocco da pantahiena", "Gino a cuccuvella", "Carmelo u riggitanu",
			"Maria a colla", "Gino u crunchiu", "Gino u lungu", "u sceriffu", "Tony Barretta", "Pinuzzu u culacchio",
			"Andrea menzapizza", "Wario Audiolio", "zio Nano in persona", "Robertinu u fioraiu", "Gino, di Gino e Marco",
			"Marco, di Gino e Marco", "zia Vanna", "Angelina 'a zitella", "FFFisico", "Ettoruzzu u sambiasinu"};
	
	/**
	 * spawns a client with a fixed delay specified in the input
	 * @param pizzeria the object Pizzeria to refer to
	 * @param spawnDelay the delay at which clients spawn
	 */
	protected GennaroTheClientManager(Pizzeria pizzeria, int spawnDelay) {
		//starts spawning clients, at a fixed rate, with the delay specified in input
		
		ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
		for (int i = 1; i <= 10; i++) {
			//this final variable bypasses the lambda scope restriction: a lambda expression can refer to a variable
			//  in an external scope only when the variable is not mutated outside, so it needs to be final.
			final int finalI = i;
			schedule.schedule(() -> {
				Client client = new Client(getRandomName(), finalI);
				client.setOrderMadeListener(pizzeria);
				client.run();
			}, i * spawnDelay, TimeUnit.MILLISECONDS);
			//schedules the execution with a delay proportional to the number of client to be spawned
			//the schedule for every execution is computed ad the start for every runnable thread
		}
		schedule.shutdown();
	}
	
	/**
	 * utility function to randomly choose the name of the client to be spawned
	 * @return a random name chosen from the list provided on top
	 */
	private String getRandomName() {
		double pos = Math.random() * clientNames.length;
		return clientNames[(int) pos];
	}
	

}
