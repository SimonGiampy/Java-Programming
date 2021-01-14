package home.inheritance.binding;

class Middle extends AbstractUpper {
	
	String name = "middle";
	
	//@Override
	void talk(AbstractUpper other) {
		System.out.print(this.name + " talking with ");
		other.exec();
	}
	
	@Override
	void talk(Lower l) {
		System.out.print(this.name + " extra talk with ");
		l.exec();
	}
	
	@Override
	void calculate(int k) {
		System.out.println("int val = " + k);
	}
	
	void calculate(double k) {
		System.out.println("double val = " + k);
	}
	
	@Override
	protected void exec() {
		System.out.println(name);
	}
}
