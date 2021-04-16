package myinterface;

import myobj.game.Magician;
import myobj.game.Warrior;

public class TestGame {

	public static void main(String[] args) {
		test(new Warrior("전사","돌격"));
		test(new Magician());
	}
	
	public static void test(GameCharacter gameCharacter) {
		gameCharacter.job();
		gameCharacter.skill();
		gameCharacter.specificity();
	}

}
