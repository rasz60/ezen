
import java.io.*;
import java.util.Arrays;
public class DataOutputStreamEx02 {

	public static void main(String[] args) {
		ByteArrayOutputStream bis = null;
		DataOutputStream dis = null;
		
		byte[] result = null;
		
		try {
			bis = new ByteArrayOutputStream();
			dis = new DataOutputStream(bis);
			dis.writeInt(10);
			dis.writeFloat(20.0f);
			dis.writeBoolean(true);
			
			result = bis.toByteArray();
			
			String[] hex = new String[result.length];
					
					for(int i=0;i<result.length;i++) {
						if(result[i]<0) {
							hex[i] = String.format("%02x",result[i]+256);
						}else {
							hex[i] = String.format("%02x",result[i]);
						}
					}
					
					System.out.println("10����  :"+Arrays.toString(result));
					System.out.println("16����  :"+Arrays.toString(hex));
					
					dis.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}