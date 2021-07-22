package algorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
  	�ؽ��ڵ�� ����
 */
public class Hashing {

	// ���ڿ��� byte�� ����	
	public static String sha256(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());

		return bytesToHex(md.digest());
	}
	// ����Ʈ�� 16������ �����ؼ�  	
	public static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
	
	// ���� �ΰ��� �ϳ��� �޼ҵ��
	public static String hash(String msg) {
		try {
			// sha-1, sha-256������ �������ִ� Ŭ����
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256"); // sha256���� ������ �ν��Ͻ� ����
			StringBuilder hashValue = new StringBuilder();
			
			for(byte b : sha256.digest(msg.getBytes())) {
				hashValue.append(String.format("%02x", b));
			}
			System.out.println(hashValue);
			return hashValue.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}  
	}
	public static void main(String[] args) {
		Hashing.hash("1234");
	}
}
