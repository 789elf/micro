package quiz.studentList;

public class StudentData {
	private int kor, eng, mat;
	private String stu_no;

	
	public StudentData() {
		
	}
	
	public StudentData(int kor, int eng, int mat, String stu_no) {
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.stu_no = stu_no;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMat() {
		return mat;
	}

	public int getTotal() {
		return kor + eng + mat;
	}
	public float getAvg() {
		return (float)(kor + eng + mat) / 3.0f;
	}
	public String getStu_no() {
		return stu_no;
	}

}
