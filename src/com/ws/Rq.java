package com.ws;

import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq {
	private String actionCode; // actioncode를 rq클래스에 저장하기 위해
	private Map<String, String> params; // hashmap에 들어있는 정보를  rq에 저장하기 위해  

	public Rq(String cmd) { // 입력받은 cmd를 분리해서 그 분리값을 다른 클래스에서 사용하기 위함 
		String[] cmdBits = cmd.split("\\?", 2); // cmd를 ?기준 2단어로 나누기 위함

		actionCode = cmdBits[0]; // 위에서 분리된 2단어 중 첫단어를 actioncode 변수에 넣은 후 actioncode값과 입력값이 일치할 경우 해당 조건을 실행할 수 있게 연결해주기 위한 첫번째 단계 

		params = new HashMap<>(); // rq 메서드를 통해 최종적으로 나눠진 번호와 내용을 묶어서 저장하기 위함 

		if (cmdBits.length == 1) { // 입력값을 2개로 못나눌때는 이 조건문 패스 
			return;
		}

		String[] paramBits = cmdBits[1].split("&"); // cmdBits 1번 칸에 들어있는 내용을 & 기준 2개로 나눠서 배열에 저장 

		for (String paramStr : paramBits) { // 2개로 나눠진 paramBits를 또 나눠주기 위함 
			String[] paramStrBits = paramStr.split("=", 2); // = 기준 2개로 나눔 

			if (paramStrBits.length == 1) { // 위에서ㅓ 2개로 나눠질게 없는 경우 continue
				continue; 
			}

			String key = paramStrBits[0]; // 위에서 나눠진 2개 단어중 첫번째 단어를 paramStrBits0번에 저장해서 key변수에 줌
			String value = paramStrBits[1]; // 위에서 나눠진 2개 단어중 첫번째 단어를 paramStrBits1번에 저장해서 value변수에 줌
			params.put(key, value); // params라는 hashmap에 위에서 받은 key,value 묶어줌
		}

	}

	public String getActionCode() { // 이 클래스 rq메서드 실행을 통해 받은 actioncode 다른 클래스로 넘겨사용할 수 있도록 getter 사용
		return actionCode; // 다른 클래스에서 getActioncode 실행하면 actioncode를 사용할 수 있도록 넘겨줌
	}

	public String getParam(String name) { // param에서 받은 값의 숫자 리턴용 
		return params.get(name);
	}

	public int getIntParam(String name, int defaultValue) { // 
		try {
			return Integer.parseInt(getParam(name));
		} catch (NumberFormatException e) {

		}
		return defaultValue;
	}

}