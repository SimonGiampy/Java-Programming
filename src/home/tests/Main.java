package home.tests;

class Main {
	
	public static void main(String[] args) throws InterruptedException {
		LongSequence sequence = new LongSequence(10);
		new Thread(() -> {
			try {
				long l = sequence.get(1);
				System.out.println("waii");
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}).start();
		
		new Thread(() -> {
			try {
				//Thread.sleep(1000);
				System.out.println("tst");
				sequence.set(1, 10);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}).start();
	}
}


