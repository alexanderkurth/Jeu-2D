package main.world.dungeon;

public abstract class Dungeon {

	protected int x;
	protected int y;
	
	protected int width;
	protected int height;

	
	public Dungeon(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
