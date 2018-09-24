package main.states;

import java.awt.Graphics;

import main.Handler;
import main.entities.creatures.Player;

public class GameState extends State {

	//Handler
	private Handler handler;
	
	private Player player;

	public GameState(Handler handler){
		this.handler = handler;
		player = new Player(10, 10);
		
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
		player.render(g);
	}

}
