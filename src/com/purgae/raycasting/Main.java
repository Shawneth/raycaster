package com.purgae.raycasting;

import com.purgae.raycasting.misc.LogLevel;
import com.purgae.raycasting.misc.Tools;

public class Main {
	public static void main(String[] args) {
		//Tools.log("Testing!");
		//Map map = new Map();
		//Tools.log(map);
		
		GameMap newMap = new GameMap(32,32,"Dark Halls");
				
		Tools.log(LogLevel.Info, newMap.getName());
		newMap.printMapToConsole();
		
	}
}
