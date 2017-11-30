package com.baoshu.transprocess;

import java.util.Objects;

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
