package com.purgae.raycasting.drawing;

import java.awt.EventQueue;
import java.awt.Graphics2D;

public class RandomScreen extends Renderer{

	
	
	@Override
	public void update(float updateTime) {
		
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		
		
	}
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new RandomScreen();
			}
		});
	}

}
