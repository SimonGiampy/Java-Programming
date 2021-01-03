package home.concurrency.sleepingBarber;

import java.util.Arrays;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

class BarberShop {
	
	protected static final int numChairs = 5;
	
	
	public static void main(String[] args) {
		//TODO: generate client at a random pace, by using a timer that wakes up the client spawner thread, waiting
		int numberOfClients = 1;
		long[] schedule = new long[numberOfClients];
		for (int i = 0; i < numberOfClients; i++) {
			schedule[i] = (long) (Math.random() * 1000) + 100;
		}
		schedule = Arrays.stream(schedule).sorted().toArray();
		
		Shop shop = new Shop();
		Barber barber = Barber.getInstance(shop);
		shop = shop.setBarber(barber);
		new Thread(barber).start();
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		for (int i = 0; i < numberOfClients; i++) {
			service.schedule(new Client(shop), schedule[i], TimeUnit.MILLISECONDS);
		}
		
		
		
	}
}
