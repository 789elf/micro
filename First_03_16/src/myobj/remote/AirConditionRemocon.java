package myobj.remote;

import myinterface.Remocon;

public class AirConditionRemocon implements Remocon{

	@Override
	public String power() {
		System.out.println("에어컨 리모콘 전원");
		return null;
	}

	@Override
	public String up(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String down(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String change() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
