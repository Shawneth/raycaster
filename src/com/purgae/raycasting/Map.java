package com.purgae.raycasting;

import com.purgae.raycasting.misc.Tools;

public class Map {
	private final int[][] mapDef;
	public Map() {
		mapDef = new int[12][12];
		populateWithBorder();
	}
	private void populateWithBorder() {
		for(int i = 0; i < mapDef.length; i++) {
			for(int j = 0; j < mapDef[i].length; j++) {
				if(i == mapDef.length - 1 || i == 0) {
					mapDef[i][j] = 1;
					continue;
				}
				else if(j == mapDef.length - 1 || j == 0) {
					mapDef[i][j] = 1;
					continue;
				}
				mapDef[i][j] = 0;
			}
		}
	}
	public int[][] getMap(){
		return this.mapDef;
	}
}
