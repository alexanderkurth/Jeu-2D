package main.world.dungeon.rooms;

import main.world.World;

public class Room{
	
	private int x;
	private int y;
	private int height;
	private int width;
	
	public Room(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}

	public void createRoom() {
		int xMiddle = (x + height)/2;
		int yMiddle = (y + width)/2;
		
		int i= xMiddle;
		int j=yMiddle;
		
		World.getTiles()[i][j] = 1;

		//
		for(i = xMiddle+1; i < (xMiddle+width)+1 ; i++) {
			for(j = yMiddle+1;j<(yMiddle+height)+1;j++) {
				
				if(i == xMiddle+width)
					World.getTiles()[i][j] = 2;
				if(j == yMiddle+width)
					World.getTiles()[i][j] = 2;
			}
		}
		
		/*
		
		//En haut � droite
		for (int i = xMiddle ; i < widthBottomRight ; i++) {
			for (int j = yMiddle ; j > heightTopLeft ; j--) {

				//Mur droite haut
				if(i == widthBottomRight-1)
					World.getTiles()[i][j] = 2;
				//Mur haut droite
				if(j == heightTopLeft+1)
					World.getTiles()[i][j] = 2;
			}
		}
		
		//En haut en gauche
		for (int i = xMiddle ; i > widthTopLeft ; i--) {
			for (int j = yMiddle ; j > heightTopLeft ; j--) {

				//Mur droite haut
				if(i == widthTopLeft+1)
					World.getTiles()[i][j] = 2;
				//Mut haut droite
				if(j == heightTopLeft+1)
					World.getTiles()[i][j] = 2;
				
				//Porte Milieu
				if(i == xMiddle && j == heightTopLeft+1)
					World.getTiles()[i][j] = 1;
			}
		}

		//En bas � gauche
		for (int i = xMiddle ; i > widthBottomLeft ; i--) {
			for (int j = yMiddle ; j < heightBottomRight ; j++) {

				//Mur gauche bas
				if(i == widthBottomLeft+1)
					World.getTiles()[i][j] = 2;
				//Mur bas gauche
				if(j == heightBottomRight-1)
					World.getTiles()[i][j] = 2;
				
				//PorteMilieu
				if(i== widthBottomLeft+1 && j == yMiddle)
					World.getTiles()[i][j] = 1;
			}
		}

		//En bas � droite
		for (int i = xMiddle ; i < widthBottomRight ; i++) {
			for (int j = yMiddle ; j < heightBottomRight ; j++) {


				//Mur droite bas
				if(i ==widthBottomRight-1 ) 
					World.getTiles()[i][j] = 2;

				//Mur bas droite
				if(j == heightBottomRight-1)
					World.getTiles()[i][j] = 2;
				
				//Porte Milieu
				if(i == xMiddle && j == heightBottomRight-1) {
					World.getTiles()[i][j] = 1;
				}
				
				if( i == widthBottomRight-1 && j == yMiddle) {
					World.getTiles()[i][j] = 1;
				}
					
			}
		}

		*/
	}

}