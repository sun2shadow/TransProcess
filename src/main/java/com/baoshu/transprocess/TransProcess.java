package com.baoshu.transprocess;

public class TransProcess {

	public static void main(String[] args) {
		try {
			new TransProcessServer().run();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
