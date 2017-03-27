package com.bithealth.dataConversionServer.util;

import java.util.Random;

public class RandomUtil {

	public static int getRandomPwd(int a){
		  Random rd = new Random();
		  int b=0;
		  int n=0;
		  for(int i=0;i<a;i++){
			  b= Math.abs(rd.nextInt(10));
			  n+=b*(Math.pow(10, i));
		  }
		  return n;
		 }
}
