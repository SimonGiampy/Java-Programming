package home.inheritance.binding;

class Lower extends Middle {
	String name = "lower";
	
	@Override
	void talk(AbstractUpper other) {
		//super.another(other);
		System.out.print(this.name + " speaks with ");
		other.exec();
	}
	
	@Override
	protected void exec() {
		System.out.println(name);
	}
	
	@Override
	void talk(Lower l) {
		System.out.print(this.name + " extra talk with ");
		l.exec();
	}
}
