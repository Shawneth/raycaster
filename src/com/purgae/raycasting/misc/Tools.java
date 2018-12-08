package com.purgae.raycasting.misc;

import com.purgae.raycasting.Map;

public class Tools {
	public static void log(LogLevel level, String msg) {
		System.out.println(level.name() + ": " + msg);
	}
	public static void log(String msg) {
		log(LogLevel.Normal, msg);
	}
	public static void log(Map map) {
		int[][] mapDef = map.getMap();
		log(LogLevel.Info, "Map\n___\n");
		for(int i = 0; i < mapDef.length; i++) {
			for(int j = 0; j < mapDef[i].length; j++) {
				System.out.print(mapDef[i][j]);
			}
			System.out.println();
		}
	}
}
