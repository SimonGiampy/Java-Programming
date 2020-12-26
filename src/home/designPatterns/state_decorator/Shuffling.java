package home.designPatterns.state_decorator;

class Shuffling extends ShufflingWrapper {
	
	protected Shuffling(Context context, State state) {
		super(context, state);
	}
	
	@Override
	protected void clickPause() {
		wrapper.clickPause();
	}
	
	@Override
	protected void clickPlay() {
		wrapper.clickPlay();
	}
	
	@Override
	protected void clickShuffle() {
		System.out.println("not shuffling anymore");
		context.shuffleActive = false;
		context.changeState(new PlayingState(context));
	}
	
	@Override
	protected void clickNext() {
		wrapper.context.setCurrentTrack((int) (Math.random() * 10));
		wrapper.context.showPlayingSong();
	}
	
	@Override
	protected void clickPrevious() {
		wrapper.context.setCurrentTrack((int) (Math.random() * 10));
		wrapper.context.showPlayingSong();
	}
}
