package myobj.c07School_ver2;

public class ProgrammingStudent extends Student{

	final static String[] subject_name = {"국어", "영어", "수학", "PL"};
	
	int sno;
	int math;
	int pl;
	

	public ProgrammingStudent(int sno) {
		
		super(sno);
		this.sno = sno; 
		math = getRandomScore();
		pl = getRandomScore();
		name = getRandomName();
		
	}
	@Override
	public void printGradeCard() {
	
		System.out.printf("학번\t│이름\t│%s\t│%s\t│%s\t│%s\t│총점\t│평균\n",subject_name[0],subject_name[1],subject_name[2],subject_name[3]);
		
		System.out.printf("%X\t│%s\t│%d\t│%d\t│%d\t│%d\t│%d\t│%.2f\n",
				sno,
				name,
				kor, 
				eng,
				math,
				pl, kor + eng + math + pl,
				(kor + eng + math + pl) / 4.0);
		
		System.out.println("──────────────────────────────────────────────────────────────────");
	}
}
