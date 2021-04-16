package myobj.c07School_ver2;

import myobj.c07School_my.MachineLearningClass;

public class School {

	int sno;
	
	public School() {
		sno = 100000;
		
		Student[] program = new Student[3];
		Student[] network = new Student[3];
		Student[] machine_learning = new Student[3];
		
		
		for (int i=0; i<program.length; i++) {
			program[i] = new ProgrammingStudent(sno++);
			program[i].printGradeCard();
		}
		
		for (int i=0; i<network.length; i++) {
			network[i] = new NetworkStudent(sno++);
			network[i].printGradeCard();
		}
		
		for (int i=0; i<machine_learning.length; i++) {
			machine_learning[i] = new MachineLearningStudent(sno++);
			machine_learning[i].printGradeCard();
		}		
		
	}
	
	public static void main(String[] args) {

//		Student[] program = new Student[30];
//		
//		for(int i=0; i<program.length; i++) {
//			program[i] = new ProgrammingStudent();
//			program[i].printGradeCard();
//		}
		new School();
		
	}

}
