
public class TryWithResource {

	public static void main(String[] args) {
		
		try (CloseableResource cr = new CloseableResource()) {					//try 조건문에 들어간 리소스를 수행하다가 exception이 발생하더라도 자동 종료한다. (AutoCloseable을 implements한 클래스 객체만 가능)
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
		System.out.println("exceptionWork(" + exception + ")가 호출됨");
		
		if (exception) {
			throw new WorkException("WorkException 발생!!!");
		}
	}
		
	@Override
	public void close() throws CloseException {
		System.out.println("close()가 호출됨");
		throw new CloseException("CloseException 발생!!!");
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

