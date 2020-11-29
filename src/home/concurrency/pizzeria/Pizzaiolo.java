package home.concurrency.pizzeria;

class Pizzaiolo implements Runnable {
	
	private final String name;
	private final int idPizzaiolo;
	
	private Order currentOrder;
	private Pizzeria pizzeria;
	
	private final OrderManager manager;
	
	protected Pizzaiolo(String name, int idNumber, OrderManager manager) {
		this.name = name;
		this.idPizzaiolo = idNumber;
		this.currentOrder = null;
		this.manager = manager;
	}
	
	
	
	/**
	 * If this thread was constructed using a separate {@code Runnable} run object, then that {@code Runnable} object's {@code run} method is called;
	 * otherwise, this method does nothing and returns.
	 */
	@Override
	public void run() {
		while (!manager.isShopClosed() || !manager.isQueueEmpty()) {
			try {
				this.currentOrder = manager.takeOrder();
				System.out.println("pizzaiolo received order ");
				Thread.sleep(3000); //processing time
			} catch (InterruptedException ignored) {
			
			}
			
		}
		
	}
}
