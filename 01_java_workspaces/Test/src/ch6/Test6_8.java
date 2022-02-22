package ch6;

class Test6_8 {
	int kind;
	int num;
	static int width;
	static int height;

	Test6_8(int k, int n) {
		kind = k;
		num = n;
	}

	public static void main(String args[]) {
		Test6_8 card = new Test6_8(1,1);
	}
}

//클래스 변수 : width, height
//인스턴스 변수 : kind, num
//지역변수 : k, n