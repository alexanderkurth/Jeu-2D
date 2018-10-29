package main.world.dungeon;

import main.world.World;

public class Corridor{
	
	private int x;
	private int y;
	private int width;
	private int length;

	public Corridor(int x, int y, int width, int length) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
	}
	
	public void creerCouloirHorizontal() {
		
		int corridorLength = x + length;
		int corridorWidth = y + width;
		
		int yStart = x;
		int xStart = y;

		for(int i = xStart; i < corridorLength ; i++) {
			for( int j = yStart; j < corridorWidth ; j++) {
				
				if(j == corridorWidth-1)
					World.getTiles()[i][j] = 2;		
				else {
					World.getTiles()[i][j] = 1;
				}
				if(j == y)
					World.getTiles()[i][j] = 2;
			}
		}
		
		
	}
	
	
}
