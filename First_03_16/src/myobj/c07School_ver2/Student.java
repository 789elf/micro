package myobj.c07School_ver2;

import java.util.Random;

/*
 *  ����� ver
 *  
 *  1. �� ���� ������ 30���̴�.
 *  
 *  2-1. ���α׷��� ��  �л��� ������ ����, ����, ����, ���α׷��� ��� ������ �ִ�.
 *  
 *  2-2. ��Ʈ��ũ �� �л��� ������ ����, ����, ������, CCNA ������ �ִ�.
 *  
 *  2-3. �ӽŷ��� �� �л��� ������ ��, ��, ��, �����, ���α׷��� ��� ������ �ִ�.
 *  
 *  3. ��� �л��� ���� ������ �������� �����Ѵ�
 *     �й��� �ߺ����� ���������� �����ȴ�. ( �Ǵ� �ߺ����� ���� )
 *  
 *  4. ����ǥ �޼��带 ���� �� �л��� ������ �̸�/����/��������� �� �� �ִ�
 *  
 *  5. 
 *  
 *  * ������ myobj.c07School ���� 
 */

public abstract class Student {
	
	Random ran = new Random();
	final static String[] lastNameList = {"��","��", "��", "��", "��", "��", "��", "��", "��", "����", "����", "��", "��", "��", "����", "��", "��", "��", "��"};
	final static String[] firstNameList = {"��ȯ", "����", "�¿�", "����", "�¿�", "��ȣ", "����", "����", "�缱","����","����","����", "����", "����", "�¹�", "����", "���", "�¿�"};
							
	int sno;
	String name;
	int kor;
	int eng;
	
	public Student(int sno) {
		this.sno = sno;
		kor = getRandomScore();
		eng = getRandomScore();
		name = getRandomName();
	}
	
	public abstract void printGradeCard();
	
	int getRandomScore() {
		return (int)(Math.random() * 101);
	}
	
	String getRandomName() {
		
		return lastNameList[ran.nextInt(lastNameList.length)]
		       + firstNameList[ran.nextInt(firstNameList.length)];
		
	}


}
