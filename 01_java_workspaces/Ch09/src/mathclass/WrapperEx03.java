package mathclass;

public class WrapperEx03 {

	public static void main(String[] args) {
		int 		i = 10;
															// ����ȯ�� ��������
		Integer  intg = (Integer)i;							// Integer intg = Integer.valueOf(i);
		Object 	  obj = (Object)i;							// Integer intg = (Object)Integer.valueOf(i);
		
		Long 	  lng = 100L;
		
		int 	   i2 = intg + 10;							// Integer�� ������ intg�� �⺻�� ���� ���� (auto-Unboxing)
		long   	    l = intg + lng;								
		
		Integer intg2 = new Integer(20);					// �������� �⺻������ ����ȯ�� ���� (����ȯ ��������)
		int 	   i3 = (int)intg2;
		
		Integer intg3 = intg2 + i3;
		
		System.out.println("i          = " + i);
		System.out.println("intg 	   = " + intg);
		System.out.println("obj 	   = " + obj);
		System.out.println("lng 	   = " + lng);
		System.out.println("intg + 10  = " + i2);
		System.out.println("intg + lng = " + l);
		System.out.println("intg2 	   = " + intg2);
		System.out.println("i3         = " + i3);
		System.out.println("intg2 + i3 = " + intg3);
		
	}

}
