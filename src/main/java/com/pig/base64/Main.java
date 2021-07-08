package com.pig.base64;

import java.util.Base64;

public class Main {

	public static void main(String[] args) {
		String text = "{\"sub\":\"1234567890\",\"name\":\"John Doe\",\"iat\":1516239022}";
		JwtUtil jw = new JwtUtil();
		String result = jw.generateToken("1234567890");
		System.out.println(result);
		String[] chunks  = result.split("\\.");
		
		Base64.Decoder decoder = Base64.getDecoder();

		String header = new String(decoder.decode(chunks[0]));
		String payload = new String(decoder.decode(chunks[1]));
		
		System.out.println("header:"+header );
		System.out.println("payload:"+payload);

	}

}
