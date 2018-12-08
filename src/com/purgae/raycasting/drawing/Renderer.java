package com.purgae.raycasting.drawing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.Timer;

public abstract class Renderer extends Canvas {
	
	protected JFrame frame = new JFrame();
	private BufferStrategy bs;
	
	public Renderer() {	
		//Create actual screen
		initUI();
		
		Timer gameUpdate = new Timer(1000/35, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Renderer.this.update(1/35f);
			}
		});
		
		Timer renderUpdate = new Timer(1000/60, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Renderer.this.render();
			}
		});
		
		gameUpdate.start();
		renderUpdate.start();
	}
	
    private void initUI() {
    	frame.setTitle("Raycasting Engine");
    	frame.setSize(640, 480);
    	frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	frame.add(this);
    	this.setSize(640, 480);
    	setIgnoreRepaint(true);
        
        createBufferStrategy(2);
        bs = getBufferStrategy();
    }
	
	public abstract void update(float updateTime);
	public abstract void draw(Graphics2D graphics);
	
	public void render() {
		Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		draw(g2d);
		if(!bs.contentsLost())
			bs.show();
	}
}