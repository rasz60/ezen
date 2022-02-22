import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111")
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"))
public class AnnotationEx05 {

	public static void main(String[] args) {
		Class<AnnotationEx05> cls = AnnotationEx05.class;
		
		TestInfo anno = (TestInfo)cls.getAnnotation(TestInfo.class);
		System.out.println("anno.testedBy() = " + anno.testedBy());
		System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
		System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmmss());
		
		for ( String str : anno.testTools() ) {
			System.out.println("testTools = " + str);	
		}
		System.out.println();
		
		Annotation[] annoArr = cls.getAnnotations();
		
		for ( Annotation a : annoArr ) {
			System.out.println(a);
		}
	}

}

// @interface로 USER_ANNOTATION 정의
@Retention(RetentionPolicy.RUNTIME)  // 실행시 사용하도록 지정 (RUNTIME)
@interface TestInfo {
	int count() default 1;
	String testedBy();
	String[] testTools() default "JUnit";
	TestType testType() default TestType.FIRST;
	DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
	String yymmdd();
	String hhmmss();
}

enum TestType { FIRST, FINAL }
