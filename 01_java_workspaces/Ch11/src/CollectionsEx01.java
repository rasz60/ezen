import java.util.*;
import static java.util.Collections.*;

public class CollectionsEx01 {

	public static void main(String[] args) {
		List list = new ArrayList();
		System.out.println(list);
		
		addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		rotate(list, 2);											// 오른쪽으로 두칸 이동
		System.out.println(list);
		
		swap(list, 0, 2);
		System.out.println(list);
		
		shuffle(list);
		System.out.println(list);
		
		sort(list, reverseOrder());
		System.out.println(list);
		
		sort(list);
		System.out.println(list);
		
		int idx = binarySearch(list, 3);
		System.out.println("index of 3 = " + idx);
		
		System.out.println("max = " + max(list));
		System.out.println("min = " + min(list));
		System.out.println("min = " + max(list, reverseOrder()));
		
		fill(list, 9);												// length 혹은 size만큼 두번째 변수로 채움
		System.out.println("list = " + list);
		
		List newList = nCopies(list.size(), 2);						// list.size()만큼 복사해서 2로 fill 한다.
		System.out.println("newList = " + newList);
		
		System.out.println(disjoint(list, newList));				// 공통요소가 없으면 true반환
		
		copy(list, newList);
		System.out.println("newList = " + newList);
		System.out.println("list = " + list);
		
		replaceAll(list, 2, 1);										// list에 있는 모든 2를 1로 바꾼다.
		System.out.println("list = "+ list);
		
		Enumeration e = enumeration(list);							// 이건 뭐지.. 왜 이렇게 넣지..
		ArrayList list2 = list(e);
		
		System.out.println("list2 = " + list2);
	}

}
