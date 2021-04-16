package quiz;

public class B15_Count369_Ver2 {

	public static void main(String[] args) {
		
		int input = 300;
		
		//System.out.println(i % 10); 		//4
		//System.out.println(i / 10 % 10);	//3
		//System.out.println(i / 10 / 10 % 10); //2
		//System.out.println(i / 10 / 10 / 10 % 10); //1

		for (int i=1; i<=input; i++) {
			
			int testValue = i;
			int clap = 0;
			
			System.out.print(i + ": ");
			
			while(testValue > 0) {
				
				int digit = testValue % 10;
				
				if(digit != 0 && digit % 3 == 0) {
					clap++;
					System.out.print("¦");
				}
				testValue /= 10;
			}
			System.out.println();
		}
	}

}
