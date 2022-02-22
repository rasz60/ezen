
import java.io.*;
import java.util.Arrays;
public class FileEx03 {
	static int totalFiles =0;
	static int totalDirs =0;
	public static void main(String[] args) {
		if(args.length !=1) {
			System.out.println("USAGE : java FileEx3 DIRECTORY");
			System.exit(0);
		}
		
		File dir = new File(args[0]);
		
		if(!dir.exists()||!dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리 입니다.");
			System.exit(0);
		}
		
		printFileList(dir);
		
		System.out.println();
		System.out.println("총 "+totalFiles+"개의 파일");
		System.out.println("총 "+totalDirs+"개의 디렉토리");
	}
	public static void printFileList(File dir) {
		
	}

}
