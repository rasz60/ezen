package ch6;

public class Test6_3 {

	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	int getTotal() {
		return kor + eng + math;
	}
	
	float getAverage() {
		return Math.round((float)((getTotal() / 3) * 100) / 100);
	}
	
}
