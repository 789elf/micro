package myinterface;

import myobj.remote.AirConditionRemocon;
import myobj.remote.TelevisionRemocon;

/*
 *  리모컨이랑 비슷한 구도의 인터페이스를 틀잡아놓을것
 *  
 */
// 인터페이스를 통해 결합도가 낮은 코드를 작성할 수 있다.
public class TestRemocon {

	public static void main(String[] args) {
		test(new AirConditionRemocon());
		test(new TelevisionRemocon());
	}
	
	public static void test(Remocon remocon) {
		remocon.power();
		remocon.up(1);
		remocon.down(1);
		remocon.change();
	}

}
