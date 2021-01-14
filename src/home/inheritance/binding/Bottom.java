package home.inheritance.binding;

class Bottom extends Lower {
	
	String name = "bottom";
	
	@Override
	protected void talk(AbstractUpper other) {
		//super.talk(other);
		System.out.print(this.name + " speaks with ");
		other.exec();
	}
	
	@Override
	protected void exec() {
		System.out.println(this.name);
	}
	
	
	
}
