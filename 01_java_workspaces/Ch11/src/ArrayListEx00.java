import java.util.ArrayList;

public class ArrayListEx00 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("222");
		list.add(333);
		System.out.println(list);
		
		list.add(0, "000");
		System.out.println(list);
		
		System.out.println("index = " + list.indexOf("333"));
		
		list.remove("333");
		System.out.println(list);
		
		System.out.println(list.remove("333"));
		System.out.println(list);
		System.out.println("index = " + list.indexOf("333"));
		
		for ( int i = 0; i < list.size(); i++ ) {
			list.set(i,  i+"");
		}
		
		System.out.print("{");
		for ( int i = 0; i < list.size(); i++ ) {
			if (i == list.size() - 1 ) {
				System.out.print(list.get(i));
			} else {
				System.out.print(list.get(i) + ", ");
			}
		}
		System.out.println("}");
		// 인덱스 i번째를 지우면 다음 인덱스 값이 당겨져 정렬되기 때문에, list[0]을 지우고 list[0]으로 당겨진 1은 지워지지 않음, 같은 이유로 3도 지워지지 않음.
		for ( int i = list.size() - 1 ; i >= 0; i-- ) {
			list.remove(i);
		}
		System.out.println(list);
	}

}
