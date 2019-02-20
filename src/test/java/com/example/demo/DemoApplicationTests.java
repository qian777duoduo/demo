package com.example.demo;

import org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Value("${JASYPT_ENCRYPTOR_PASSWORD}")
	private String passWord;//tJJT#qfZipW0seNf

	@Test
	public void contextLoads() {

		String encryptString = "123456";
		//需要加密的内容
		String[] args = new String[3];
		args[0] =  "input=" + encryptString;
		args[1] = "password=" + passWord;
		args[2] = "algorithm=PBEWithMD5AndDES";

		JasyptPBEStringEncryptionCLI.main(args);

	}

}

