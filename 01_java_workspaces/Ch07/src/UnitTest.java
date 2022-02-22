
public class UnitTest {

	public static void main(String[] args) {

		Unit[] group = { new Marine(), new Tank(), new Dropship() };

		for ( int i = 0; i < group.length; i++ ) {
			group[i].move(100, 200);
			group[i].stop();
		}

		
	}

}
