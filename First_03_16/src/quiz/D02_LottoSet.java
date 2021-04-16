package quiz;

import java.util.*;


public class D02_LottoSet {

	Random ran = new Random();
	

	public static void main(String[] args) {

		D02_LottoSet lotto = new D02_LottoSet(); 
//		System.out.println(lotto.getLottoNumbers());
//		System.out.println(lotto.getLottoNumbers_2());
		System.out.println(lotto.getLottoNumbers_3());
		
		
	}
	
	// 1번 
	// 1부터 45사이의 중복없는 랜덤숫자 7개로 이루어진 HashSet을 생성하여
	// 반환하는 메소드를 작성 후 테스트
	public HashSet getLottoNumbers() {
		HashSet<Integer> lotto_set = new HashSet();
		
		while(lotto_set.size() < 7) {
			lotto_set.add(ran.nextInt(45)+1);
		}
		return lotto_set;
	}
	
	// 2번
	// 1부터 45사이의 중복없는 랜덤숫자 7개로 이루어진 ArrayList를 생성하여
	// 반환하는 메서드를 작성 후 테스트
	// (는 말장난이었고 그냥 HashSet 갖다 쓰라는거였음.)
	
	public ArrayList<Integer> getLottoNumbers_2() {
//		ArrayList<Integer> lotto_list = new ArrayList<Integer>();
//		int temp;
//
//		lotto_list.add(ran.nextInt(45)+1);
//		while(lotto_list.size() < 7) {
//			temp = ran.nextInt(45)+1;
//
//			for(int i=0; i<lotto_list.size(); i++) {
//				if(lotto_list.get(i).intValue() == temp) {
//					break;
//				}else {
//					lotto_list.add(temp);
//					break;
//				}
//			}
//		}
//		return lotto_list;
		return new ArrayList<>(getLottoNumbers());
	}
	
	// 3번
	// 1부터 45사이의 중복없는 랜덤숫자 7개로 이루어진 Integer[]를 생성하여
	// 반환하는 메서드를 작성 후 테스트
	public Integer[] getLottoNumbers_3() {
		return getLottoNumbers_2().toArray(new Integer[7]);
	}
	
	public int[] getLottoNumbers_4() {
		Integer[] lotto = getLottoNumbers_3();
		int[] result = new int[7];
			
		for(int i=0; i<7; i++) {
			result[i] = lotto[i];
		}
		return result;
	}
}
