package myobj.c07School_ver2;

public class MachineLearningStudent extends Student{

	final static String[] subject_name = {"����", "����", "����", "�����", "PL"};
	
	int sno;
	int math;
	int statistics;
	int pl;
	
	
	public MachineLearningStudent(int sno) {
		super(sno);
		this.sno = sno;
		
		math = getRandomScore();
		statistics = getRandomScore();
		pl = getRandomScore();
		name = getRandomName();
	}
	
	@Override
	public void printGradeCard() {
		
		System.out.println(eng);
		
		System.out.printf("�й�\t���̸�\t��%s\t��%s\t��%s\t��%s\t��%s\t������\t�����\n",subject_name[0],subject_name[1],subject_name[2],subject_name[3],subject_name[4]);
		
		System.out.printf("%X\t��%s\t��%d\t��%d\t��%d\t��%d\t��%d\t��%d\t��%.2f\n",
				sno,
				name,
				kor, 
				eng,
				math,
				statistics,
				pl,
				kor + eng + math + pl + statistics,
				(kor + eng + math + pl + statistics) / 5.0);
		
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
	}
}
