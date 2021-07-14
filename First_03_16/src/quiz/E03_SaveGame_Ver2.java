package quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class E03_SaveGame_Ver2 {

	/*
	 *  프로그램 내용 기록
	 */
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int win = 0;
		int lose = 0;
		
		System.out.println("이름 > ");
		String name = sc.nextLine();
		
		File save = new File("./note/"+name+".hz");
		
		if(save.exists()) {
			System.out.println("불러올 파일이 있음.");
			
			try {
				FileInputStream fin = new FileInputStream(save);
				
				win = fin.read();
				lose = fin.read();
				
				fin.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {}
		}else {
			System.out.println("불러올 파일이 없음.");
		}
		while(true) {
			int answer = (int)(Math.random() * 2);
			
			System.out.println("0,1  > ");
			int user = sc.nextInt();
			if(user != -1 && user != 0 && user != 1) {
				System.out.println("다시");
				continue;
			}
			if(user == -1) {
				System.out.println("종료");
				break;
			}
			if(user != answer) {
				System.out.println("졌음");
				lose++;
			}else {
				System.out.println("이김");
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
