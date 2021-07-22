package algorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
  	해쉬코드로 변경
 */
public class Hashing {

	// 문자열을 byte로 변경	
	public static String sha256(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());

		return bytesToHex(md.digest());
	}
	// 바이트를 16진수로 변경해서  	
	public static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
	
	// 위의 두개를 하나의 메소드로
	public static String hash(String msg) {
		try {
			// sha-1, sha-256등으로 변경해주는 클래스
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256"); // sha256으로 변경할 인스턴스 생성
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
