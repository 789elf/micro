package myobj.c07School_ver2;

import java.util.Random;

/*
 *  강사님 ver
 *  
 *  1. 각 반의 정원은 30명이다.
 *  
 *  2-1. 프로그래밍 반  학생은 각자의 국어, 영어, 수학, 프로그래밍 언어 점수가 있다.
 *  
 *  2-2. 네트워크 반 학생은 각자의 국어, 영어, 리눅스, CCNA 점수가 있다.
 *  
 *  2-3. 머신러닝 반 학생은 각자의 국, 영, 수, 통계학, 프로그래밍 언어 점수가 있다.
 *  
 *  3. 모든 학생의 성적 점수를 랜덤으로 생성한다
 *     학번은 중복없이 순차적으로 생성된다. ( 또는 중복없이 랜덤 )
 *  
 *  4. 성적표 메서드를 통해 각 학생의 총점과 이름/총점/평균점수를 볼 수 있다
 *  
 *  5. 
 *  
 *  * 문제는 myobj.c07School 에서 
 */

public abstract class Student {
	
	Random ran = new Random();
	final static String[] lastNameList = {"강","고", "구", "권", "김", "나", "박", "최", "오", "제갈", "독고", "이", "신", "차", "남궁", "배", "서", "안", "임"};
	final static String[] firstNameList = {"태환", "태현", "태영", "태희", "태욱", "태호", "태준", "세현", "재선","현식","혜승","지혜", "우현", "예림", "승미", "광민", "충민", "승운"};
							
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
