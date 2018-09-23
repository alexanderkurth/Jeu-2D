package main;

import main.input.KeyManager;
import main.world.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	//Game
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	//World
	public World getWorld() {
		return world;
	}
	
	public void setWorld (World world) {
		this.world = world;
	}
	
	//Fenetre game
	public int getHeight() {
		return game.getHeight();
	}
	
	public int getWidth() {
		return game.getWidth();
	}

	//KeyManager
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

}
