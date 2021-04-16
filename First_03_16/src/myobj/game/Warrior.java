package myobj.game;

import myinterface.GameCharacter;

public class Warrior implements GameCharacter {

	String job;
	String specificity;
	
	public Warrior(String job, String specificity) {
		this.job = job;
		this.specificity = specificity;
	}
	
	@Override
	public String job() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] skill() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String specificity() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
