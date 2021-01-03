package home.tests;

import java.util.Random;

class Main2 {
	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
			Main2.fill();
		}).start();
		
		
		new Thread(Main2::waitForPositiveAverage).start();
	}
	
		private static double data[] = new double[100];
		private static Random r = new Random();
		public static void fill() {
			synchronized(data) {
				for(int i=0; i<data.length; i++) data[i]=r.nextDouble()*20-10;
				data.notifyAll();
			}
		}
		public static void waitForPositiveAverage()  {
			synchronized(data) {
				
				while(average()<0) {
					System.out.println("goind to wait");
					try {
						data.wait() ;
					} catch (InterruptedException exception) {
						exception.printStackTrace();
					}
				}
			}
		}
		private static double average() {
			double tot=0;
			for(int i=0; i<data.length; i++) tot += data[i];
			System.out.printf("average = %f\n", tot/ data.length);
			return tot/data.length;
		}
	
}
