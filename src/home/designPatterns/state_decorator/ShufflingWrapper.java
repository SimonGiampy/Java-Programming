package home.designPatterns.state_decorator;

abstract class ShufflingWrapper extends State {
	
	protected State wrapper;
	
	protected ShufflingWrapper(Context context, State state) {
		super(context);
		wrapper = state;
	}
	
}
