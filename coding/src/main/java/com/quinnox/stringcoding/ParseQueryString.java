package com.quinnox.stringcoding;

public class ParseQueryString {

	public static void main(String[] args) {
		
		String queryString="variableA=89&variableB=100&variableC=150";
		String[] params=queryString.split("&");
		for(int i=0;i<params.length;i++){
			String[] params2=params[i].split("=");
			for (int j = 0; j < params2.length; j++) {
				System.out.println(params2[j]);		
			}
		}
	}
}
