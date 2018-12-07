package com.purgae.raycasting.drawing;

import java.awt.EventQueue;
import java.awt.Graphics2D;

public class World extends Renderer{
	
	String ctnString = "Counter: ";
	
	float stateTime = 0;
	int timer = 0;

	@Override
	public void update(float updateTime) {
		stateTime += updateTime;
		if(stateTime >= 1f) {
			stateTime = 0f;
			timer++;
		}
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawString(ctnString + timer, 10, 50);
	}
	
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	new World();
            }
        });
        
    }

}
