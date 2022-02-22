
public class TryWithResource {

	public static void main(String[] args) {
		
		try (CloseableResource cr = new CloseableResource()) {					//try ���ǹ��� �� ���ҽ��� �����ϴٰ� exception�� �߻��ϴ��� �ڵ� �����Ѵ�. (AutoCloseable�� implements�� Ŭ���� ��ü�� ����)
			cr.exceptionWork(false);
		} catch (WorkException we) {
			we.printStackTrace();
		} catch (CloseException ce) {
			ce.printStackTrace();
		}
		
		System.out.println();
		
		try (CloseableResource cr = new CloseableResource()) {
			cr.exceptionWork(true);
		} catch (WorkException we) {
			we.printStackTrace();
		} catch (CloseException ce) {
			ce.printStackTrace();
		}
				
	}

}
	
class CloseableResource implements AutoCloseable {
		
	public void exceptionWork (boolean exception) throws WorkException {
		System.out.println("exceptionWork(" + exception + ")�� ȣ���");
		
		if (exception) {
			throw new WorkException("WorkException �߻�!!!");
		}
	}
		
	@Override
	public void close() throws CloseException {
		System.out.println("close()�� ȣ���");
		throw new CloseException("CloseException �߻�!!!");
	}

}
	
class WorkException extends Exception {
	WorkException(String msg) { 
		super(msg); 
	}
	
}
	
class CloseException extends Exception {
	CloseException(String msg) { 
		super(msg); 
	}
	
}

