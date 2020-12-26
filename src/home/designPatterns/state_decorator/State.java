package home.designPatterns.state_decorator;

abstract class State {
	
	protected Context context;
	
	protected State(Context context) {
		this.context = context;
	}
	
	abstract protected void clickPause();
	abstract protected void clickPlay();
	abstract protected void clickShuffle();
	abstract protected void clickNext();
	abstract protected void clickPrevious();
	
}
