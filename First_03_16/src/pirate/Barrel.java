package pirate;

public class Barrel {

	/*
 	
 	1. 플레이어가 돌아가면서 원하는 곳에 칼을 찌른다
 	
 	2. 잘못된 곳에 칼을 넣으면 해적 아저씨가 날아가며 게임에 패배한다. 
 	
 	3. 총 구멍 갯수, 꽝 갯수는 마음대로.
   
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
		// player_or_pc가 1이면 사람으로 , 아니면 pc로 ( 메시지 안보이게 )
		if(forked[slot]) {
			System.out.println("이미 찔럿던 곳입니다. 다른곳을 골라주세요.");
			return false;
		}
			
		if(slot == fireBtn) {
			game_over = true;
		}
		
		forked[slot] = true;
		return true;
	}
}
