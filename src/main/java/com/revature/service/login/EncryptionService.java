package com.revature.service.login;

public class EncryptionService {
	
	public String encryptor(String password) {
		
		char[] ch = password.toCharArray();
		char[] ch1 = new char[ch.length];
		for(int i=0; i < ch.length; i++) {
			ch1[i] = (char) (ch[i] + 5);
			
		}
	  return String.valueOf(ch1);	
	
	}

}
