package home.concurrency.pizzeria;

/**
 * this class generates randomly new clients who make orders
 */
public class GennaroTheClientManager {
	
	private final String[] clientNames = {"Fricca 'o ncapac",  "nonno Prullo", "Peppe 'o Murator", "Roccu u zimbaru",
			"Sara a menza scupetta", "Loredana sacciututtu", "Peppe u tenent", "Daniele Banana Joe", "Maria 'a bambula",
			"Biagino u pulmanista", "Daniele 'u dalton", "Rocco da pantahiena", "Gino a cuccuvella", "Carmelo u riggitanu",
			"Maria a colla", "Gino u crunchiu", "Gino u lungu", "u sceriffu", "Tony Barretta", "Pinuzzu u culacchio",
			"Andrea menzapizza", "Wario Audiolio", "zio Nano in persona", "Robertinu u fioraiu", "Gino, di Gino e Marco",
			"Marco, di Gino e Marco", "zia Vanna", "Angelina 'a zitella", "FFFisico", "Ettoruzzu u sambiasinu"};

	//client spawning
	protected GennaroTheClientManager(Pizzeria pizzeria, int spawnDelay) {
		//starts spawning clients
		Client client;
		
		for (int i = 0; i < 3; i++) {
			client = new Client(getRandomName(), i);
			client.setOrderCreationListener(pizzeria);
			client.run();
			try {
				Thread.sleep(spawnDelay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getRandomName() {
		double pos = Math.random() * clientNames.length;
		return clientNames[(int) pos];
	}
	

}
