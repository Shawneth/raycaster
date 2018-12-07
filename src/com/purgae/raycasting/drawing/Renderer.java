package com.purgae.raycasting.drawing;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.Timer;

public abstract class Renderer extends Canvas{

	private static final long serialVersionUID = 1L;
	
	private JFrame frame = new JFrame();
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
    	
    	setIgnoreRepaint(true);
        
        createBufferStrategy(2);
        bs = getBufferStrategy();
        
    }
	
	public abstract void update(float updateTime);
	public abstract void draw(Graphics2D graphics);
	
	public void render() {
		Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
		super.paint(g2d);
		draw(g2d);
		if(!bs.contentsLost())
			bs.show();
	}
}