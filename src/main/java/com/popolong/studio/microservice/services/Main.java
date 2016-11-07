package com.popolong.studio.microservice.services;

import com.popolong.studio.microservice.services.smartserivices.SmartServicesServer;
import com.popolong.studio.microservice.services.registration.RegistrationServer;
import com.popolong.studio.microservice.services.web.WebServer;


public class Main {

	public static void main(String[] args) {

		String serverName = "NO-VALUE";

		switch (args.length) {
		case 2:
			System.setProperty("server.port", args[1]);
		case 1:
			serverName = args[0].toLowerCase();
			break;

		default:
			usage();
			return;
		}

		if ( serverName.equals("reg")) {
			RegistrationServer.main(args);
		} else if (serverName.equals("smart")) {
			SmartServicesServer.main(args);
		} else if (serverName.equals("web")) {
			WebServer.main(args);
		} else {
			System.out.println("Unknown server type: " + serverName);
			usage();
		}
	}

	protected static void usage() {
		System.out.println("Usage: java -jar ... <server-name> [server-port]");
		System.out.println(
				"     where server-name is 'reg', " + "'topup' or 'web' and server-port > 1024");
	}
}
