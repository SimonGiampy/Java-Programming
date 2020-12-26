package home.designPatterns.state_decorator;

class PausedState extends State {
	
	protected PausedState(Context context) {
		super(context);
		System.out.println("now in pause");
	}
	
	@Override
	protected void clickPause() {
		//nothing
	}
	
	@Override
	protected void clickPlay() {
		context.changeState(new PlayingState(context));
	}
	
	@Override
	protected void clickShuffle() {
	
			System.out.println("now shuffling");
			context.shuffleActive = true;
			//context.changeState(new Shuffling(context, context.getCurrentState()));
			context.changeState(new PausedState(context));
			
	}
	
	@Override
	protected void clickNext() {
		context.nextSong();
	}
	
	@Override
	protected void clickPrevious() {
		context.previousSong();
	}
}
