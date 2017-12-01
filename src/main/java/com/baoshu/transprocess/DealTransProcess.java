package com.baoshu.transprocess;

import org.zeromq.ZMQ;

public class DealTransProcess {

	private static ZMQ.Socket requester;
	
	public static ZMQ.Socket getRequester() {
		return requester;
	}

	public DealTransProcess() {
		ZMQ.Context context = ZMQ.context(1);
		requester = context.socket(ZMQ.REQ);
		requester.connect("tcp://192.168.0.136:5555");
		
		String request1 = "1 connect tcp://180.167.17.121:20910 \0";
		byte[] sendByte1 = request1.getBytes();
		requester.send(sendByte1);
		byte[]  reply1 = requester.recv(0);
		System.out.println("Received " + new String(reply1));
		
		
		String request = "2 login 58200001 111111 \0";
		byte[] sendByte = request.getBytes();
		requester.send(sendByte);
		byte[]  reply = requester.recv(0);
		System.out.println("Received " + new String(reply));
	}
}
