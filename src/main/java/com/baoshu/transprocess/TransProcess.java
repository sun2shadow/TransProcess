package com.baoshu.transprocess;

public class TransProcess {

	public static void main(String[] args) {
		try {
			TransInterfaceProcess process = new TransInterfaceProcess();
			
			process.dealTrans();
			process.init();
			TransProcessServer server = new TransProcessServer();
			server.run();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
