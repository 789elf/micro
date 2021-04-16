package quiz;

import java.util.Scanner;

public class B14_Prime {

	/*
	 * 	사용자로부터 숫자를 입력받으면
	 *  1부터 입력한 숫자 사이에 존재하는 소수를 모두 출력해 보세요.
	 */
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.println("수 입력 > ");
		num = sc.nextInt();
        boolean flag;   
        
        
        for(int i=2; i<=num; i++) {
        	
        	flag = true;
        	
        	for(int j=2; j<i; j++) {
        		
        		if(i % j == 0) {
        			
        			flag = false;
        			break;
        		}
        	}
        	if(flag) {
        		
        		System.out.println(i);
        	}
        }
	}
}
