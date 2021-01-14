package home.inheritance.binding;

abstract class AbstractUpper {

	abstract void exec();
	
	abstract void talk(AbstractUpper other);
	
	abstract void talk(Lower l);
	
	abstract void calculate(int k);
	
}
