package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class E03_SaveGame {

	/*
	 * 
	 *  1. 컴퓨터와 진행하는 간단한 가위바위보 게임을 만든 후
	 *     처음 시작하면 이름을 입력함
	 *     프로그램 종료 시 플레이어의 전적을 파일에 저장해 보세요
	 *     저장할 때 파일명은 이름.txt
	 *     
	 *  
	 *  2. 프로그램 실행 시 아까 저장해놨던 전적을 불러온 후 진행되도록 만들어 보세요.
	 */
	
	String[] shape = {"가위", "바위", "보"};
	static ArrayList<String> log_list = new ArrayList<String>();
	int win, lose, draw;
	int game_cnt = 0;
	//승패 결과
	public void result(int player,int com) {
		String player_shape = shape[player];
		String com_shape = shape[com];
		
		if(player == 0) {
			if(com == 0) log_list.add("무");
			else if(com == 1) log_list.add("패");
			else if(com == 2) log_list.add("승");
		}else if(player == 1) {
			if(com == 0) log_list.add("승");
			else if(com == 1) log_list.add("무");
			else if(com == 2) log_list.add("패");
		}else if(player == 2) {
			if(com == 0) log_list.add("패");
			else if(com == 1) log_list.add("승");
			else if(com == 2) log_list.add("무");
		}

		System.out.println(game_cnt + " game");
		System.out.println("player > " + player_shape);
		System.out.println("com    > " + com_shape);
	}
	// inputStream
	public void inputStream(String name) {
		File game_file = new File("./note/"+name+".txt");
		// 파일이 존재하지 않는다면 outputStream먼저 생성
		if(!game_file.exists()) {
			outputStream(name);
		}
        
		try {
			FileInputStream fin = new FileInputStream(game_file);
			InputStreamReader reader = new InputStreamReader(fin,"euc-kr");
	        BufferedReader in = new BufferedReader(reader);

			int _byte;
			
			while((_byte = in.read()) != -1) {
				log_list.add(Character.toString((char)_byte));
				System.out.print(Character.toString((char)_byte));
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<log_list.size()-1; i++) {
			log_list.remove(" ");
		}
	}
	public void outputStream(String name) {
		File newFile = new File("./note/"+name+".txt");
		try {
			//true로 두면 이어서 쓰고 , false로 쓰면 새로 씀
			FileOutputStream fout = new FileOutputStream(newFile,false);
//			OutputStreamWriter writer = new OutputStreamWriter(fout,"euc-kr");
//	        BufferedWriter out = new BufferedWriter(writer);
	        int cnt = 0;
			for(String i : log_list) {
				fout.write(String.format("%s ", i).getBytes());
				if(cnt++ == 20) {
					fout.write("\n".getBytes());
				}
			}
			
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getTotal() {
		win = Collections.frequency(log_list, "승");
		lose = Collections.frequency(log_list, "패");
		draw = Collections.frequency(log_list, "무");
		game_cnt = log_list.size();
		float wp =  (float)((float)win/(float)game_cnt) * 100;
		
		System.out.printf("\n%d전 %d승 %d패 %d무 (%.2f%%)",game_cnt, win, lose, draw, wp);
	}
	public static void main(String[] args) {
		E03_SaveGame game = new E03_SaveGame();
		Scanner sc = new Scanner(System.in);
		
		String name;
		int player; // 플레이어 선택 번호
		int com; // 컴퓨터 랜덤 인덱스 번호
		
		System.out.println("이름 > " );
		name = sc.next();
		
		game.inputStream(name);  
		game.getTotal();
		
		while(true) {
			System.out.println("\n1.가위  2.바위  3.보  0.종료");
			player = sc.nextInt();
	
			if(player == 0) {
				break;
			}
			com = (int)(Math.random() * 3);
				
			game.result(player-1,com);
		}
		game.outputStream(name);
		
	}

}
