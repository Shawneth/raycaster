package com.purgae.raycasting;

public class Tools {
	public static void log(LogLevel level, String msg) {
		System.out.println(level.name() + ": " + msg);
	}
	public static void log(String msg) {
		log(LogLevel.Normal, msg);
	}
}
