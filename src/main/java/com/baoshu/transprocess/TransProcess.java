package com.baoshu.transprocess;

public class TransProcess {

	public static void main(String[] args) {
		try {
			TransProcessServer server = new TransProcessServer();
			server.init();
			server.run();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
