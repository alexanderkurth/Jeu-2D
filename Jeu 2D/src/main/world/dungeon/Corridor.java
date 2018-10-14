package main.world.dungeon;

import java.awt.Graphics;

import main.Handler;
import main.world.World;

public class Corridor extends Dungeon{

	public Corridor(Handler handler,int x, int y, int width, int height) {
		super(handler,x, y, width, height);
	}

	public void corridorHorizontal() {
		 int heightCorridor = y + height;
		 int widthCorridor = x + width;
		 
		 int xMiddle = (x + widthCorridor)/2;
		 int yMiddle = (y + heightCorridor)/2;
		 
		 for(int i=xMiddle; i < widthCorridor ; i++) {
			 for(int j=yMiddle-1; j < heightCorridor ; j++) {
				 if(j == (heightCorridor-1)) 
					 World.getTiles()[i][j] = 2;
				 
				 if(j == y && x != (widthCorridor-1)) 
					 World.getTiles()[i][j] = 2;
				 
				 if( i == xMiddle && j ==yMiddle)
					 World.getTiles()[i][j] = 1;
			 }
		 }
	}
	
	public void corridoVertical() {
		 int heightCorridor = y + height;
		 int widthCorridor = x + width;
		 
		 int xMiddle = (x + widthCorridor)/2;
		 int yMiddle = (y + heightCorridor)/2;
		 
		 for(int i=xMiddle; i < widthCorridor ; i++) {
			 for(int j=yMiddle-1; j < heightCorridor ; j++) {
				 if(j == (heightCorridor-1)) 
					 World.getTiles()[j][i] = 2;
				 
				 if(j == y && x != (widthCorridor-1)) 
					 World.getTiles()[j][i] = 2;
				 
				 if( i == xMiddle && j ==yMiddle)
					 World.getTiles()[j][i] = 1;
			 }
		 }
	}

		
}
