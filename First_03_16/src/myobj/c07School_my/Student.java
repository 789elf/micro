package myobj.c07School_my;

import java.util.Random;

public class Student {

	Random ran = new Random();

	String school_class;
	String[] subject;
	char[] last_name = {
			'��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', 'Ȳ', '��',
	};
	char[] first_name = {
			'��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��',
	        '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��',
	        '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��',
	        '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��',
	        '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��',
	        '��', '��', '��', '��', 'â', 'ä', 'õ', 'ö', '��', '��', '��', 'ġ', 'Ž', '��', '��', '��', '��', '��', '��', '��', '��', '��',
	        '��', 'ȣ', 'ȫ', 'ȭ', 'ȯ', 'ȸ', 'ȿ', '��', '��', '��', '��', '��', '��', '��', '��', '��', 'ȥ', 'Ȳ', '��', '��', '��', '��',
	        '��', '��', '��', 'Ź', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��',
	        '��', '��', '��', '��', '��', '��', 'Ÿ', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��',
	        '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��'
	};
	int[][] score;
	
	
	public Student(String school_class, String[] subject) {
		
		this.school_class = school_class;
		this.subject = new String[subject.length];
		
		// ����� ����
		for(int i=0; i<subject.length; i++) {
			this.subject[i] = subject[i];
		}
		this.score = new int[30][subject.length];

		// ���� ����
		for(int i=0; i<30; i++) {
			for(int j=0; j<subject.length; j++) {
				this.score[i][j] = ran.nextInt(101);
			}
		}
	}
	
	public void info() {
		int temp;
		StringBuilder temp_name = new StringBuilder();
		System.out.println("###" + school_class + "�� ###" );
		

		System.out.printf("�й�\t�̸�\t%s\t%s\t%s\t%s\t����\t���\n",subject[0],subject[1],subject[2],subject[3]);
		
		for(int i=0; i<3; i++) {
			
			temp = 0;

			temp_name.delete(0, temp_name.length());
			
			for(int k=0; k<3; k++) {
				if(k==0) {
					temp_name.append(last_name[ran.nextInt(last_name.length+1)]);
				}else {
					temp_name.append(first_name[ran.nextInt(first_name.length+1)]);
				}
			}		
			System.out.print((i+1) + "\t"+ temp_name + "\t");
			
			
			for(int j=0; j<subject.length; j++) {
				if(j!=3) {
					System.out.print(score[i][j]+"\t");
				}else {
					System.out.print(score[i][j]+"\t\t");
				}
					
				temp += score[i][j];
			}
			System.out.print(temp+"\t"+temp / subject.length);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
