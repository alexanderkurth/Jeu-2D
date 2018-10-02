package main.world.room;


public abstract class Room {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Room(int x, int y, int height,int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		
	}
	

	public abstract void tick() ;
	
	public abstract void render();
	
	//Getters & Setters
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	
}
