package myobj.c07School_my;

public class NetworkClass extends Student{

	
	public NetworkClass(String school_class, String[] subject) {
		super(school_class, subject);
	}

	public static void main(String[] args) {

		String school_class = "��Ʈ��ũ";
		String[] subject = new String[]{"����", "����", "������", "CCNA"};
		
		new Student(school_class,subject).info();
	}

}
