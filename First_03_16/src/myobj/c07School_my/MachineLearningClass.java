package myobj.c07School_my;

public class MachineLearningClass extends Student{

	public MachineLearningClass(String school_class, String[] subject) {
		super(school_class, subject);
	}

	public static void main(String[] args) {

		String school_class = "�ӽŷ���";
		String[] subject = new String[]{"����", "����", "�����", "���α׷��� ���"};
		
		new Student(school_class,subject).info();
	}

}
