package main.world.dungeon;

import main.world.World;

public class Corridor{
	
	private int x;
	private int y;
	private int width;
	private int height;

	public Corridor(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void create() {
		if(width > height) {
			corridorHorizontal();
		}else {
			corridorVertical();
		}
	}
	
	public void corridorHorizontal() {
		 int heightCorridor = y + height;
		 int widthCorridor = x + width;
		 
		 for(int i=x; i < widthCorridor ; i++) {
			 for(int j=y-1; j < heightCorridor -1; j++) {
				 
				 if(j == y) {
					 World.getTiles()[i][j] = 1	;
				 }
				 
				 if(j == y-1) {
					 World.getTiles()[i][j] = 2	;
				 }
				 
				 if(j == y+1) {
					 World.getTiles()[i][j] = 2	;
				 }
				 
			 }
		 }
	}
	
	public void corridorVertical() {
		int heightCorridor = y + height;
		 int widthCorridor = x + width;
		 
		 for(int i=x-1; i < widthCorridor -1; i++) {
			 for(int j=y; j < heightCorridor ; j++) {
				 if(i == x-1) {
					 World.getTiles()[i][j] = 2	;
				 }
				 if(i == x) {
					 World.getTiles()[i][j] = 1	;
				 }
				 if(i == x+1)
					 World.getTiles()[i][j] = 2	;
				 
			 }
		 }
	}
	
	
}
