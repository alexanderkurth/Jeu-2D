package main.states;

import java.awt.Graphics;

import main.Handler;
import main.graphics.Assets;

public class GameState extends State {

	//Handler
	private Handler handler;

	public GameState(Handler handler){
		this.handler = handler;
		
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
		g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
		g.drawImage(Assets.grass, 10, 10, null);
	}

}
