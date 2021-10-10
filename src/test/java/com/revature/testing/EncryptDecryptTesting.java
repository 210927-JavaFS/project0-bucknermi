package com.revature.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.service.login.DecryptionService;
import com.revature.service.login.EncryptionService;

public class EncryptDecryptTesting {
	
	private static Logger log = LoggerFactory.getLogger(EncryptDecryptTesting.class);
	String result;
	EncryptionService es = new EncryptionService();
	DecryptionService ds = new DecryptionService();
	
	@Test
	public void encryptorTest() {
		log.info("Encrypt decrypt test has begun");
		result = es.encryptor("abcd");
		assertEquals(result, "fghi");
	}
	
	@Test
	public void decryptorTest() {
		result = ds.decryptor("fghi");
		assertEquals(result, "abcd");
		log.info("Encrypt decrypt test has finished");
	}

}
