package main.states;

import java.awt.Graphics;

import main.Game;
import main.Handler;
import main.entities.creatures.Player;
import main.tile.Tile;
import main.world.World;

public class GameState extends State {
	
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/world/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
