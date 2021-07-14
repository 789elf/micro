package quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class E03_SaveGame_Ver2 {

	/*
	 *  ���α׷� ���� ���
	 */
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int win = 0;
		int lose = 0;
		
		System.out.println("�̸� > ");
		String name = sc.nextLine();
		
		File save = new File("./note/"+name+".hz");
		
		if(save.exists()) {
			System.out.println("�ҷ��� ������ ����.");
			
			try {
				FileInputStream fin = new FileInputStream(save);
				
				win = fin.read();
				lose = fin.read();
				
				fin.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {}
		}else {
			System.out.println("�ҷ��� ������ ����.");
		}
		while(true) {
			int answer = (int)(Math.random() * 2);
			
			System.out.println("0,1  > ");
			int user = sc.nextInt();
			if(user != -1 && user != 0 && user != 1) {
				System.out.println("�ٽ�");
				continue;
			}
			if(user == -1) {
				System.out.println("����");
				break;
			}
			if(user != answer) {
				System.out.println("����");
				lose++;
			}else {
				System.out.println("�̱�");
				win++;
			}
		}
		
		try {
			FileOutputStream fout = new FileOutputStream(save);
			
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {}

	}

}
