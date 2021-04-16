package myobj.c07School_my;

public class MachineLearningClass extends Student{

	public MachineLearningClass(String school_class, String[] subject) {
		super(school_class, subject);
	}

	public static void main(String[] args) {

		String school_class = "머신러닝";
		String[] subject = new String[]{"국어", "영어", "통계학", "프로그래밍 언어"};
		
		new Student(school_class,subject).info();
	}

}
