package home.concurrency.pizzeria;

class Pizzaiolo implements Runnable {
	
	private final String name;
	private final int idPizzaiolo;
	
	private Order currentOrder;
	private Pizzeria pizzeria;
	
	private final CiroTheOrderManager ciro;
	
	protected Pizzaiolo(String name, int idNumber, CiroTheOrderManager manager) {
		this.name = name;
		this.idPizzaiolo = idNumber;
		this.currentOrder = null;
		this.ciro = manager;
	}
	
	/**
	 * If this thread was constructed using a separate {@code Runnable} run object, then that {@code Runnable} object's {@code run} method is called;
	 * otherwise, this method does nothing and returns.
	 */
	@Override
	public void run() {
		while (!ciro.isShopClosed() || !ciro.isQueueEmpty()) {
			try {
				this.currentOrder = ciro.takeOrder();
				long waitingTime = (long) (Math.random() * 7000) + 1000;
				System.out.println("pizzaiolo " + getIdPizzaiolo() + " received order #" + currentOrder.getIdOrder() + ", waiting " + waitingTime);
				Thread.sleep(waitingTime); //different percentages of priorities); //processing time
			} catch (InterruptedException ignored) {
			
			}
			
		}
		
	}
	
	public int getIdPizzaiolo() {
		return idPizzaiolo;
	}
}
