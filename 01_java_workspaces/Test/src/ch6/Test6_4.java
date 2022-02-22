package ch6;

class Test6_4 {
	public static void main(String args[]) {
		Test6_3 s = new Test6_3();
		s.name = "È«±æµ¿";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("ÀÌ¸§ :"+s.name);
		System.out.println("ÃÑÁ¡ :"+s.getTotal());
		System.out.println("Æò±Õ :"+s.getAverage());
	}
}