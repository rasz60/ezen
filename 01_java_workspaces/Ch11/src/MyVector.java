import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyVector implements List {
	
	Object[] data = null;
	int capacity = 0;
	int size = 0;
	
	public MyVector(int capacity) {
		if ( capacity < 0 ) {
			throw new IllegalArgumentException("유효하지 않은 값입니다. : " + capacity);
		}
		
		this.capacity = capacity;
		data = new Object[capacity];
	}
	
	public MyVector() {
		this(10);
	}

	public void ensureCapacity(int minCapacity) {	// 최소 용량을 지정하는 메서드
		if ( minCapacity - data.length > 0) {
			setCapacity(minCapacity);
		}
	}
	
	private void setCapacity(int capacity) {
		if ( this.capacity == capacity ) {
			return;
		} else {
			Object[] tmp = new Object[capacity];
			System.arraycopy(data, 0, tmp, 0, size);
			data = tmp;
			this.capacity = capacity;
		}
	}

	@Override
	public boolean add(Object obj) {
		ensureCapacity(size + 1);
		data[size++] = obj;
		return true;
	}
	
	@Override
	public Object get(int index) {
		if ( index < 0 || index >= size ) {
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		} 
		return data[index];
	}
	
	@Override
	public Object remove(int index) {
		Object oldObj = null;
		
		if (index < 0 || index >= size ) {
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		}
		oldObj = data[index];
		
		
		if ( index != size - 1 ) {
			System.arraycopy(data, index + 1, data, index, size - index - 1);
		}
		
		data[size - 1] = null;
		size--;		
		
		return oldObj;
	}
	
	@Override
	public boolean remove(Object obj) {
		for ( int i = 0; i < size; i++ ) {
			if ( obj.equals(data[i]) ) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void trimToSize() {
		setCapacity(size);
	}

	@Override
	public void clear() {
		for ( int i = 0; i < size; i++ ) {
			data[i] = null;
		}
		size = 0;
	}
	
	@Override
	public Object[] toArray() { 
		Object[] result = new Object[size];
		System.arraycopy(data,  0, result, 0, size);
		
		return result;
	}

	public int capacity() {
		return capacity;
		}
	
	@Override
	public int size() {
		return 0;
		}

	@Override
	public boolean isEmpty() { return false; }

	@Override
	public boolean contains(Object o) {	return false; }

	@Override
	public Iterator iterator() { return null; }

	@Override
	public Object[] toArray(Object[] a) { return null; }

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
