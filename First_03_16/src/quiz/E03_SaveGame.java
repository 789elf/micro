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
	 *  1. ��ǻ�Ϳ� �����ϴ� ������ ���������� ������ ���� ��
	 *     ó�� �����ϸ� �̸��� �Է���
	 *     ���α׷� ���� �� �÷��̾��� ������ ���Ͽ� ������ ������
	 *     ������ �� ���ϸ��� �̸�.txt
	 *     
	 *  
	 *  2. ���α׷� ���� �� �Ʊ� �����س��� ������ �ҷ��� �� ����ǵ��� ����� ������.
	 */
	
	String[] shape = {"����", "����", "��"};
	static ArrayList<String> log_list = new ArrayList<String>();
	int win, lose, draw;
	int game_cnt = 0;
	//���� ���
	public void result(int player,int com) {
		String player_shape = shape[player];
		String com_shape = shape[com];
		
		if(player == 0) {
			if(com == 0) log_list.add("��");
			else if(com == 1) log_list.add("��");
			else if(com == 2) log_list.add("��");
		}else if(player == 1) {
			if(com == 0) log_list.add("��");
			else if(com == 1) log_list.add("��");
			else if(com == 2) log_list.add("��");
		}else if(player == 2) {
			if(com == 0) log_list.add("��");
			else if(com == 1) log_list.add("��");
			else if(com == 2) log_list.add("��");
		}

		System.out.println(game_cnt + " game");
		System.out.println("player > " + player_shape);
		System.out.println("com    > " + com_shape);
	}
	// inputStream
	public void inputStream(String name) {
		File game_file = new File("./note/"+name+".txt");
		// ������ �������� �ʴ´ٸ� outputStream���� ����
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
			//true�� �θ� �̾ ���� , false�� ���� ���� ��
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
		win = Collections.frequency(log_list, "��");
		lose = Collections.frequency(log_list, "��");
		draw = Collections.frequency(log_list, "��");
		game_cnt = log_list.size();
		float wp =  (float)((float)win/(float)game_cnt) * 100;
		
		System.out.printf("\n%d�� %d�� %d�� %d�� (%.2f%%)",game_cnt, win, lose, draw, wp);
	}
	public static void main(String[] args) {
		E03_SaveGame game = new E03_SaveGame();
		Scanner sc = new Scanner(System.in);
		
		String name;
		int player; // �÷��̾� ���� ��ȣ
		int com; // ��ǻ�� ���� �ε��� ��ȣ
		
		System.out.println("�̸� > " );
		name = sc.next();
		
		game.inputStream(name);  
		game.getTotal();
		
		while(true) {
			System.out.println("\n1.����  2.����  3.��  0.����");
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
