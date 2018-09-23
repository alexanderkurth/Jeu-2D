package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import main.graphics.Display;

public class Game extends Display implements Runnable {
	
	//Variables boucle jeu
	private boolean running = false; 
	private Thread thread;
	
	//Variables render
	private BufferStrategy bs;
	private Graphics g;
	
	//Handler
	private Handler handler;

	public Game(String title, int width, int height) {
		super(title, width, height);
	}

	private void init(){
		handler = new Handler(this);
	}
	

	private void tick(){
	
	}
	
	private void render(){
		
		bs = this.getCanvas().getBufferStrategy();
		if(bs == null){
			this.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//Clear Screen
		
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		//Draw Here!
		
		g.fillRect(0, 0, 150, 150);
		
		//End Drawing!
		
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
