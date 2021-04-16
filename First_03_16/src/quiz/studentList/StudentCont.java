package quiz.studentList;

import java.util.ArrayList;
import java.util.Random;


public class StudentCont {
	
	ArrayList<StudentData> list = new ArrayList<StudentData>();
	ArrayList<StudentData> topScore = new ArrayList<StudentData>();
//	StudentData topScore = new StudentData();
	
	Random ran = new Random();
	int stu_no = 0;
	/*
	 * format
	String name = String.format("학생%06d", stu_no);
	public String getTranscript(String name, int kor, int eng, int mat, int total, float avg) {
		return String.format("%s  %d  %d  %d %d  %.2f", name, kor, eng, mat, total, avg);
	}
	*/
	
	StudentCont(){
		setScore();
		disp(list,list.size());
		getTopScore();
	}
	//랜덤 스코어  
	public void setScore(){
		
		for(int i=0; i<5; i++) {
			list.add(new StudentData(ran.nextInt(101), ran.nextInt(101), ran.nextInt(101), "학생" + stu_no++));
		}
	}

	//최고 점수 
	public void getTopScore() {
		int max = -1;				
		int top_index = 0, top;
		
		for(int i=0; i<list.size(); i++) {
			top = list.get(i).getTotal();

			if(max < top) {
				max = top;
				top_index = i;
			}
		}
		
		topScore.add(new StudentData(list.get(top_index).getKor(), list.get(top_index).getEng(), list.get(top_index).getMat(), list.get(top_index).getStu_no()));
		disp(topScore, 1);
	}
	
	//출력
	public void disp(ArrayList<StudentData> stu_list, int cnt){
		if(cnt == 1) {
			System.out.println("\n- - - - - - - - T O P S C O R E - - - - - - - -\n");
		}
		
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균");
		System.out.println("────────────────────────────────────────────────");
		for(int i=0; i<cnt; i++) {
			System.out.printf("%3s │\t%3d  │\t%3d │\t%3d │\t%3d │\t%.2f\n", 
					stu_list.get(i).getStu_no(), 
					stu_list.get(i).getKor(),
					stu_list.get(i).getEng(),
					stu_list.get(i).getMat(),
					stu_list.get(i).getTotal(),
					stu_list.get(i).getAvg());
			System.out.println("------------------------------------------------");
		}
	}
}
