package myobj.c07School_my;

public class NetworkClass extends Student{

	
	public NetworkClass(String school_class, String[] subject) {
		super(school_class, subject);
	}

	public static void main(String[] args) {

		String school_class = "네트워크";
		String[] subject = new String[]{"국어", "영어", "리눅스", "CCNA"};
		
		new Student(school_class,subject).info();
	}

}
