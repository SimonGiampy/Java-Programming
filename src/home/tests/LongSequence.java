package home.tests;

class LongSequence {
	
	private long[] data;
	
	public LongSequence(int size) {
		data = new long[size];
		for(int i=0; i<size; i++) data[i]=-1;
	}
	
	public synchronized long get(int pos) throws InterruptedException {
		long result;
		//synchronized(data) {
			while(data[pos]<0) wait();
			result = data[pos];
			data[pos] = -1;
			notifyAll();
		//}
		return result;
	}
	
	public synchronized void set(int pos, long val) throws InterruptedException {
		//synchronized(data) {
			while(data[pos]>=0) wait();
			data[pos] = val;
			notifyAll();
		//}
	}
	public int getSize() {
		return data.length;
	}
}
