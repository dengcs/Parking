package com.parking.main;

public class Main {

	public static void main(String[] args) throws Exception {
		Server server = new Server(9983);
		server.run();
	}

}
