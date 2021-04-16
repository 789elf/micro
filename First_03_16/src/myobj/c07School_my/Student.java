package myobj.c07School_my;

import java.util.Random;

public class Student {

	Random ran = new Random();

	String school_class;
	String[] subject;
	char[] last_name = {
			'김', '이', '박', '최', '정', '강', '조', '윤', '장', '임', '한', '오', '서', '신', '권', '황', '안',
	};
	char[] first_name = {
			'가', '강', '건', '경', '고', '관', '광', '구', '규', '근', '기', '길', '나', '남', '노', '누', '다',
	        '단', '달', '담', '대', '덕', '도', '동', '두', '라', '래', '로', '루', '리', '마', '만', '명', '무', '문', '미', '민', '바', '박',
	        '백', '범', '별', '병', '보', '빛', '사', '산', '상', '새', '서', '석', '선', '설', '섭', '성', '세', '소', '솔', '수', '숙', '순',
	        '숭', '슬', '승', '시', '신', '아', '안', '애', '엄', '여', '연', '영', '예', '오', '옥', '완', '요', '용', '우', '원', '월', '위',
	        '유', '윤', '율', '으', '은', '의', '이', '익', '인', '일', '잎', '자', '잔', '장', '재', '전', '정', '제', '조', '종', '주', '준',
	        '중', '지', '진', '찬', '창', '채', '천', '철', '초', '춘', '충', '치', '탐', '태', '택', '판', '하', '한', '해', '혁', '현', '형',
	        '혜', '호', '홍', '화', '환', '회', '효', '훈', '휘', '희', '운', '모', '배', '부', '림', '봉', '혼', '황', '량', '린', '을', '비',
	        '솜', '공', '면', '탁', '온', '디', '항', '후', '려', '균', '묵', '송', '욱', '휴', '언', '령', '섬', '들', '견', '추', '걸', '삼',
	        '열', '웅', '분', '변', '양', '출', '타', '흥', '겸', '곤', '번', '식', '란', '더', '손', '술', '훔', '반', '빈', '실', '직', '흠',
	        '흔', '악', '람', '뜸', '권', '복', '심', '헌', '엽', '학', '개', '롱', '평', '늘', '늬', '랑', '얀', '향', '울', '련'
	};
	int[][] score;
	
	
	public Student(String school_class, String[] subject) {
		
		this.school_class = school_class;
		this.subject = new String[subject.length];
		
		// 과목명 삽입
		for(int i=0; i<subject.length; i++) {
			this.subject[i] = subject[i];
		}
		this.score = new int[30][subject.length];

		// 점수 삽입
		for(int i=0; i<30; i++) {
			for(int j=0; j<subject.length; j++) {
				this.score[i][j] = ran.nextInt(101);
			}
		}
	}
	
	public void info() {
		int temp;
		StringBuilder temp_name = new StringBuilder();
		System.out.println("###" + school_class + "반 ###" );
		

		System.out.printf("학번\t이름\t%s\t%s\t%s\t%s\t총점\t평균\n",subject[0],subject[1],subject[2],subject[3]);
		
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
