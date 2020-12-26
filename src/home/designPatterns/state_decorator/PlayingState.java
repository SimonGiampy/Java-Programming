package home.designPatterns.state_decorator;

class PlayingState extends State {
	
	protected PlayingState(Context context) {
		super(context);
		System.out.println("now playing");
	}
	
	@Override
	protected void clickPause() {
		context.changeState(new PausedState(context));
	}
	
	@Override
	protected void clickPlay() {
		//nothing
	}
	
	@Override
	protected void clickShuffle() {
		
			System.out.println("now shuffling");
			context.shuffleActive = true;
			//context.changeState(new Shuffling(context, context.getCurrentState()));
			context.changeState(new PlayingState(context));
		
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
