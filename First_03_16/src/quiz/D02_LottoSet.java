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
	
	// 1�� 
	// 1���� 45������ �ߺ����� �������� 7���� �̷���� HashSet�� �����Ͽ�
	// ��ȯ�ϴ� �޼ҵ带 �ۼ� �� �׽�Ʈ
	public HashSet getLottoNumbers() {
		HashSet<Integer> lotto_set = new HashSet();
		
		while(lotto_set.size() < 7) {
			lotto_set.add(ran.nextInt(45)+1);
		}
		return lotto_set;
	}
	
	// 2��
	// 1���� 45������ �ߺ����� �������� 7���� �̷���� ArrayList�� �����Ͽ�
	// ��ȯ�ϴ� �޼��带 �ۼ� �� �׽�Ʈ
	// (�� ���峭�̾��� �׳� HashSet ���� ����°ſ���.)
	
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
	
	// 3��
	// 1���� 45������ �ߺ����� �������� 7���� �̷���� Integer[]�� �����Ͽ�
	// ��ȯ�ϴ� �޼��带 �ۼ� �� �׽�Ʈ
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
