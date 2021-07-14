import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;

public class E07_JSON {
	/*
	 * # json : 파일에 저장하는 방식중의 가장 많이 사용되는 것
	 * 
	 * - JavaScript의 Object타입과 굉장히 유사한 형태의 데이터 표현 방식 - 문자열만으로 다양한 데이터를 간결하게 표현할 수
	 * 있어서 인기가 많다 - { "Key" : Value, "Key" : Value, ...}
	 * 
	 * # JSON의 Value에 표현 가능한 타입들
	 * 
	 * - '', "" : String - 숫자, 소수 : Number - [] : Array - {} : Object (Java의 Map)
	 * 
	 * Ex) data = { "이름" : 홍길동, "나이" : 15, "좋아하는 음식" : ["햄버거", "파스타", "불고기"], "가족관계"
	 * : { "동생" : sister, "엄마" : mom, "아빠" : dad }, }
	 * 
	 */

	// myMap에 저장된 데이터들을 json 형태의 문자열로 만들어 파일에 출력하는 메소드를 만들기
	// 메소드명 : mapToJsonFile ( 파일에 출력)
	// 메소드명 : mapToJsonStr (String으로 출력)
	// 메소드명 : jsonToMap ( 파일을 다시 map으로 )

	static HashMap<String, Object> jsonToMap() {
		HashMap<String, Object> map = new HashMap<String, Object>();

		try {
			File file = new File("./data/myData.json"); 
			if(file.exists()) { 
				BufferedReader in = new BufferedReader(new FileReader(file)); 
				String strLine = "";
				String strKey;
				String strValue = "";
				
				while( (strLine = in.readLine()) != null ) {
					if(strLine.equals("}") || strLine.equals("{")) {
						continue;
					}
					
					int key_index = (strLine.indexOf("\""))+1;
					int t_index = strLine.indexOf(":");
					int value_index = t_index +3;
					
					strKey = strLine.substring(key_index,(strLine.substring(key_index).indexOf("\"")+key_index));

					if(strLine.substring(value_index-1,(strLine.substring(value_index).indexOf("\"")+value_index)).equals("[")) {
				        int ch_cnt = 0;
				        int[] ch_index;
				        String[] strArr;
				        for (int i = 0; i < strLine.length(); i++) {
				            if (strLine.charAt(i) == ',') ch_cnt++;
				        }
				        ch_index = new int[ch_cnt];
				        strArr = new String[ch_cnt];
				        int a = 0;
				        for (int i = 0; i < strLine.length(); i++) {
				            if (strLine.charAt(i) == ',') {
				            	ch_index[a++] = i;
				            }
				        }
				        
				        for(int i=0; i<ch_cnt; i++) {
				        	
				        	if(i == 0) {
				        		strValue = strLine.substring(value_index+1,(strLine.substring(value_index).indexOf("\"")+ch_index[i]-1));
				        		strArr[i] = strValue;
				        	}else {
				        		strValue = strLine.substring(ch_index[i-1]+3,(strLine.substring(value_index).indexOf("\"")+ch_index[i]-1));
				        		strArr[i] = strValue;
				        	}
				        }
				        map.put(strKey, strArr);
					}else if(strLine.substring(value_index-1,strLine.substring(value_index).indexOf("\"")+value_index+1).equals("[")) {
						int ch_cnt = 0;
				        int[] ch_index;
				        int[] intArr;
				        for (int i = 0; i < strLine.length(); i++) {
				            if (strLine.charAt(i) == ',') ch_cnt++;
				        }
				        ch_index = new int[ch_cnt];
				        intArr = new int[ch_cnt];
				        int a = 0;
				        for (int i = 0; i < strLine.length(); i++) {
				            if (strLine.charAt(i) == ',') {
				            	ch_index[a++] = i;
				            }
				        }
				        
				        for(int i=0; i<ch_cnt; i++) {
				        	
				        	if(i == 0) {
				        		intArr[i] = Integer.parseInt(strLine.substring(value_index,(strLine.substring(value_index).indexOf(", ")+ch_index[i]-1)));
				        	}else {
				        		intArr[i] = Integer.parseInt(strLine.substring(ch_index[i-1]+2,(strLine.substring(value_index).indexOf(", ")+ch_index[i]-1)));
				        	}
				        }
				        map.put(strKey, intArr);
					}else {
						strValue = strLine.substring(value_index,(strLine.substring(value_index).indexOf("\"")+value_index));
						map.put(strKey,strValue);
					}
				}
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return map;
	}

	static void mapToJsonFile(HashMap<String, Object> myMap) {
		try {
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("./data/myData.json"),
					Charset.forName("MS949"));

			out.append("{\n");
			for (String key : myMap.keySet()) {
				Object value = myMap.get(key);

				if (value instanceof String[]) {
					String[] arr = (String[]) value;
					out.append(" \"" + key + "\" : [");
					for (int i = 0; i < arr.length; i++) {
						out.append("\"" + arr[i] + "\", ");
					}
					out.append("]\n");
				} else if (value instanceof int[]) {
					int[] arr = (int[]) value;
					out.append(" \"" + key + "\" : [");
					for (int i = 0; i < arr.length; i++) {
						out.append("" + arr[i] + ", ");
					}
					out.append("]\n");
				} else {
					out.append(" \"" + key + "\" : \"" + value + "\",");
					out.append("\n");
				}
			}
			out.append("}");
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static String mapToStr(HashMap<String, Object> myMap) {
		String str = "";
		str += "{\n";
		for (String key : myMap.keySet()) {
			Object value = myMap.get(key);

			if (value instanceof String[]) {
				String[] arr = (String[]) value;
				str += " \"" + key + "\" : [";
				for (int i = 0; i < arr.length; i++) {
					str += "\"" + arr[i] + "\", ";
				}
				str += "]\n";
			} else if (value instanceof int[]) {
				int[] arr = (int[]) value;
				str += " \"" + key + "\" : [";
				for (int i = 0; i < arr.length; i++) {
					str += arr[i] + ", ";
				}
				str += "]\n";
			} else {
				str += " \"" + key + "\" : \"" + value + "\",\n";
			}
		}
		str += "}";

		return str;
	}

	public static void main(String[] args) {
		HashMap<String, Object> myMap = new HashMap<>();

		myMap.put("name", "홍길동");
		myMap.put("age", 123);
		myMap.put("tel", "010-1234-1234");
		myMap.put("tel2", null);
		myMap.put("language", new String[] { "C", "JAVA", "Javascript", "React" });
		myMap.put("lotto", new int[] { 1, 2, 3, 4, 5, 6, 7 });

		mapToJsonFile(myMap);
		
		System.out.println("json To map");
		System.out.println(mapToStr(jsonToMap()));

//		System.out.println(str);
//		jsonToMap();

	}

}
