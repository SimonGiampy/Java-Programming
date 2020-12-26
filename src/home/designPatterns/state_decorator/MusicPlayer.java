package home.designPatterns.state_decorator;

import java.util.Scanner;

class MusicPlayer {
	
	protected static final int numberOfTracks = 10;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("choose music track (between 0 and 10): ");
		int track = scanner.nextInt();
		System.out.println("choose equalization type: 0 normal, 1 - 2 - 3");
		int type = scanner.nextInt();
		
		Context context = new Context(track);
		
		System.out.println("commands available: \tq = quit;\tp = play;\tw = pause;\ts = shuffle;\t< = previous;\t> = next ");
		
		char input;
		do {
			input = scanner.next().charAt(0);
			switch (input) {
				case 'q': break;
				case 'p': context.getCurrentState().clickPlay(); break;
				case 'w': context.getCurrentState().clickPause(); break;
				case 's': context.getCurrentState().clickShuffle(); break;
				case '<': context.getCurrentState().clickPrevious(); break;
				case '>': context.getCurrentState().clickNext(); break;
				default:
					System.out.println("command invalid, try again ");
			}
		} while (input != 'q');
		
	}
}
