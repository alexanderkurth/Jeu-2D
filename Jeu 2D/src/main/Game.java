package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import main.graphics.Assets;
import main.graphics.Display;
import main.graphics.GameCamera;
import main.input.KeyManager;
import main.input.MouseManager;
import main.states.GameState;
import main.states.State;

public class Game extends Display implements Runnable {
	
	//Variables boucle jeu
	private boolean running = false; 
	private Thread thread;
	
	//Variables render
	private BufferStrategy bs;
	private Graphics g;
	
	//Handler
	private Handler handler;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	private GameCamera gameCamera;
	
	//States
	private State gameState;

	public Game(String title, int width, int height) {
		super(title, width, height);
		keyManager = new KeyManager();
	}

	private void init(){
		this.getCanvas().addKeyListener(keyManager);
		
		handler = new Handler(this);
		Assets.init();
		
		gameCamera = new GameCamera(this, 0, 0);
		
		gameState = new GameState(this);
		State.setState(gameState);
	}
	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
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
		
		if(State.getState() != null)
			State.getState().render(g);
		
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
	
	//Getters & Setters
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
}
