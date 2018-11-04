package main.world.dungeon;

import main.world.World;

public class Corridor{
	
	private int x;
	private int y;
	private int width;
	private int height;

	public Corridor(int x, int y, int width, int length) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = length;
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
		 
		 int xMiddle = (widthCorridor)/2;
		 int yMiddle = (heightCorridor)/2;
		 
		 for(int i=x; i < widthCorridor ; i++) {
			 for(int j=y; j < heightCorridor ; j++) {
				 
				 if(j == heightCorridor -1) {
					 World.getTiles()[i][j] = 2	;
				 }
				 if(j == y) {
					 World.getTiles()[i][j] = 2	;
				 }
				 if(j < heightCorridor-1 & j > y){
					 World.getTiles()[i][j] = 1	;
				 }
				 
			 }
		 }
	}
	
	public void corridorVertical() {
		int heightCorridor = y + height;
		 int widthCorridor = x + width;
		 
		 int xMiddle = (widthCorridor)/2;
		 int yMiddle = (heightCorridor)/2;
		 
		 for(int i=x; i < widthCorridor ; i++) {
			 for(int j=y; j < heightCorridor ; j++) {
				 if(i == widthCorridor-1) {
					 World.getTiles()[i][j] = 2	;
				 }
				 if(i == x) {
					 World.getTiles()[i][j] = 2	;
				 }
				 if(i < widthCorridor-1 & i > x)
					 World.getTiles()[i][j] = 1	;
				 
			 }
		 }
	}
	
	
}
