package com.purgae.raycasting.drawing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;

import com.purgae.raycasting.Eye;
import com.purgae.raycasting.Map;
import com.purgae.raycasting.misc.LogLevel;
import com.purgae.raycasting.misc.Tools;

public class World extends Renderer{
	
	public World() {
		super();
		Tools.log(LogLevel.Important, "Renderer Width: " + getWidth());
		Tools.log(LogLevel.Important, "Renderer Height: " + getHeight());
	}
	
	private boolean r_debug = true;
	
	String posxString = "X: ";
	String posyString = "Y: ";
	String angleString = "Angle: ";
	
	Eye eye = new Eye();
	Map map = new Map();
	
	float stateTime = 0;
	float r_stateTime = 0;
	int frameCount = 0;
	int timer = 0;

	@Override
	public void update(float updateTime) {
		//Timer for whatever.
		stateTime += updateTime;
		if(stateTime >= 1f) {
			stateTime = 0f;
			timer++;
			frame.setTitle("Raycasting Demo - FPS: " + frameCount);
			frameCount = 0;
		}
		//
	}

	@Override
	public void draw(Graphics2D graphics) {
		/*
		 * Lets begin ray casting!
		 */
		drawRays(graphics);
		
		//Debug Info
		if(r_debug) {
			graphics.setColor(Color.RED);
			graphics.drawString(posxString + eye.position.getX(), 10, 20);
			graphics.drawString(posyString + eye.position.getY(), 10, 35);
			graphics.drawString(angleString + eye.angle, 10, 50);
		}
		
		//Let's increment our frame-count.
		frameCount++;
	}
	
	private void drawRays(Graphics2D graphics) {
		graphics.setColor(Color.BLACK);
		int width = getWidth();
		for(int i = 0; i < width; i++) {
			graphics.drawLine(1, 0, i, getHeight());
		}
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
