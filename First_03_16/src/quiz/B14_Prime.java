package quiz;

import java.util.Scanner;

public class B14_Prime {

	/*
	 * 	����ڷκ��� ���ڸ� �Է¹�����
	 *  1���� �Է��� ���� ���̿� �����ϴ� �Ҽ��� ��� ����� ������.
	 */
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.println("�� �Է� > ");
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
