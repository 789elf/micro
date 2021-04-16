package pirate;

public class Barrel {

	/*
 	
 	1. �÷��̾ ���ư��鼭 ���ϴ� ���� Į�� ���
 	
 	2. �߸��� ���� Į�� ������ ���� �������� ���ư��� ���ӿ� �й��Ѵ�. 
 	
 	3. �� ���� ����, �� ������ �������.
   
 */
	
	boolean[] forked;
	int size;
	int fireBtn;
	boolean game_over;
	
	public Barrel(int size) {

		this.size = size;
		this.forked = new boolean[size];
		this.fireBtn = (int)(Math.random() * size);
		this.game_over = false;
	}
	public boolean chackGameOver() {
		return game_over;
	}
	
	public boolean fork(int slot) {
		// player_or_pc�� 1�̸� ������� , �ƴϸ� pc�� ( �޽��� �Ⱥ��̰� )
		if(forked[slot]) {
			System.out.println("�̹� �񷵴� ���Դϴ�. �ٸ����� ����ּ���.");
			return false;
		}
			
		if(slot == fireBtn) {
			game_over = true;
		}
		
		forked[slot] = true;
		return true;
	}
}
