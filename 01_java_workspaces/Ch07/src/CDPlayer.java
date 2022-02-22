
public class CDPlayer extends Player{

	int currentTrack = 1;
	
	@Override //annotation
	void play(int pos) {
		this.currentTrack = pos;
		System.out.printf("¢º Track #%d%n", currentTrack);
	}

	@Override
	void stop() {
		System.out.printf("¡á Track #%d%n", currentTrack);		
	}

	void nextTrack() {
		currentTrack++;
		System.out.printf("¢º¢º Track #%d%n", currentTrack);
	}
	
	void preTrack() {
		if ( currentTrack > 1 ) {
		currentTrack--;
		System.out.printf("¢¸¢¸ Track #%d%n", currentTrack);
		}
		else {
			System.out.println("!~!~!~!~!~ FIRST TRACK, BRO ~!~!~!~!~!");
			return;
		}

	}

}
