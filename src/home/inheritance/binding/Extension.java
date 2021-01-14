package home.inheritance.binding;

class Extension implements General {
	/*
	public void calc(double k) {
		System.out.println("interface calc " + k * 2);
	}
	*/
	
	@Override
	public void calc(int k) {
		System.out.println("interface calc " + k * 3);
	}
	
	
}
