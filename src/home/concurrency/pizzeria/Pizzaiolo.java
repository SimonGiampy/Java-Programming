package home.concurrency.pizzeria;

class Pizzaiolo implements Runnable {
	
	private String name;
	private int idPizzaiolo;
	
	private Order currentOrder;
	
	protected Pizzaiolo(String name, int idNumber) {
		this.name = name;
		this.idPizzaiolo = idNumber;
		this.currentOrder = null;
	}
	
	/**
	 * When an object implementing interface {@code Runnable} is used to create a thread, starting the thread causes the
	 * object's {@code run} method to be called in that separately executing thread.
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		if (currentOrder == null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("wait gets interrupted");
			}
		}
	}
	
	
}
