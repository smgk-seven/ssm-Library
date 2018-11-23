package com.smgk.library.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;



public class utils {

	public int randomNum(){
		int result = 0;
		for(int j = 0; j< 100; j++){
		 result=((int)((Math.random()*9+1)*100000));
		}
		System.out.println(result);
		return result;
	}
public static String md5(String message){
		
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			byte md5[]=md.digest(message.getBytes());
			BASE64Encoder encoder=new BASE64Encoder();
			return encoder.encode(md5).toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
	}
}
