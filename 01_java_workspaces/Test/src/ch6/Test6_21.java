package ch6;

class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	void turnOnOff() {
		// (1) isPowerOn �� ���� �ٲ۴�
		isPowerOn = !isPowerOn;
	}

	void volumeUp() {
		// (2) volume�� ���� MAX_VOLUME���� ���� ���� ���� 1 ������Ų��.
		if ( volume < MAX_VOLUME ) {
			volume++;
		}
		else {
			System.out.println("�ִ� �����Դϴ�.");
		}
		
	}

	void volumeDown() {
		// (3) volume MIN_VOLUME 1 . �� ���� ���� Ŭ ���� ���� ���ҽ�Ų��
		if ( volume > MIN_VOLUME ) {
			volume--;
		}
		else {
			System.out.println("�ּ� �����Դϴ�.");
		}
	}
	
	void channelUp() {
		// (4) channel 1 . �� ���� ������Ų��
		// ���� channel�� MAX_CHANNEL�̸� �� channel���� MIN_CHANNEL�� �ٲ۴�
		
		if ( channel > MAX_CHANNEL) {
			channel = MIN_CHANNEL;
		}
		else { 		
			channel++;
			}
	}

	void channelDown() {
		// (5) channel 1 . �� ���� ���ҽ�Ų��
		// channel MIN_CHANNEL , channel MAX_CHANNEL . ���� �� �̸� �� ���� �� �ٲ۴�
		if ( channel < MIN_CHANNEL) {
			channel = MAX_CHANNEL;
		}
		else { 		
			channel--;
			}
	}
} // class MyTv

	class Test6_21 {
		public static void main(String args[]) {
			MyTv t = new MyTv();
			t.channel = 100;
			t.volume = 0;
			System.out.println("CH:"+t.channel+", VOL:"+ t.volume);
			t.channelDown();
			t.volumeDown();
			System.out.println("CH:"+t.channel+", VOL:"+ t.volume);
			t.volume = 100;
			t.channelUp();
			t.volumeUp();
			System.out.println("CH:"+t.channel+", VOL:"+ t.volume);
		}
}
