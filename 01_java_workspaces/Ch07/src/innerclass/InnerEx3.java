package innerclass;

public class InnerEx3 {
	private int outerIv = 0;
	static	int outerCv = 0;
	
	class InstanceInner {
		int iiv = outerIv;
		int iiv2 = outerCv;
	}
	
	static class StaticInner {
//		int siv = outerIv;			//static ���� Ŭ���������� �ܺ�Ŭ������ �ν��Ͻ����� ���� �Ұ�
		static int scv = outerCv;
	}
	
	void myMethod() {
		int lv = 0;
		final int LV = 0;

		class LocalInner {
			int liv = outerIv;
			final int liv2 = outerCv;
			// ����Ŭ���������� ����� ����� ������������ ���� �����ϴ�.
			// JDK1.8���ʹ� ����� �������� ���� ���� ������ final�� �ڵ� ��ȯ�ǹǷ�
			// �ش� ���������� ���� ���ϴ� ������ �޼��� �ȿ� ���� ������ �߻��Ѵ�.
			int liv3 = lv;		
			int liv4 = LV;
		}
	}
	
	
}
