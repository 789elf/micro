package pirate;

import java.util.Scanner;

public class PirateGame {

	/*
	 *  ���� ���� Main
	 */
	Scanner sc;
	Barrel barrel;
	int mode;
	
	int turn;
	int numOfPlayer;
	
	public PirateGame(int mode){
		this.barrel = new Barrel(20);
		this.mode = mode;
		this.numOfPlayer = 2;
		sc = new Scanner(System.in);
	}
	
	public PirateGame(int mode, int numOfPlayer) {
		this(mode); //���� �����ڸ� ȣ���Ѵ�. ( �Ű����� Ÿ��, ������ ���� )
		this.numOfPlayer = numOfPlayer;
	}
	
	public void start() {
		switch (this.mode) {
		case 0:
			pvp();
			break;
		case 1:
			pve();
			break;
		default:
			System.out.println("���� �������� ����");
		}
	}

	public void config(int mode) {
		this.mode = mode;
	}
	
	void pvp() {
		
		while(true) {
			
			System.out.println((turn + 1) + "�� ");
			System.out.print("Player" + (turn % numOfPlayer + 1) + "�� ���� > ");
			int slot = sc.nextInt();
			
			if(barrel.fork(slot)) {
				
				if(barrel.chackGameOver()){
					System.out.println("'Player" + (turn % numOfPlayer + 1) + "'�� �й�!");
					break;
				}
				turn++;
			}
			
		}
	}
	void pve() {

	}
	
	// PC ������ 
	int pcSlot() {

		int pc_slot = (int)(Math.random() * barrel.size);
		
		while(!barrel.fork(pc_slot)) {
			pc_slot = (int)(Math.random() * barrel.size);
		}
		return pc_slot;
	}
	

	
	public static void main(String[] args) {

		PirateGame testGame = new PirateGame(7, 3);
		
		testGame.config(1);
		testGame.start();
		
	}

}
