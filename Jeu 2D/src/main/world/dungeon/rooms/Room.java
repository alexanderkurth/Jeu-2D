package main.world.dungeon.rooms;

import main.world.World;

public class Room{
	
	private int x;
	private int y;
	private int height;
	private int width;
	
	private int xMiddle;
	private int yMiddle;
	
	public Room(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
		this.xMiddle = (this.x + this.height)/2;
		this.yMiddle = (this.y + this.width)/2;
	}

	public void createRoom() {
		
		int i= xMiddle;
		int j=yMiddle;
		
		World.getTiles()[i][j] = 1;
		
		int widthRight = xMiddle+width+1;
		int heightTop = yMiddle+height+1;
		System.out.println(widthRight +","+heightTop);
		
		int widthLeft = xMiddle-width-1;
		int heightBottom = yMiddle-height-1;
		System.out.println(widthLeft +","+heightBottom);

		
		//coin supérieur droit
		for(i = xMiddle+1; i < widthRight ; i++) {
			for(j = yMiddle-1; j > heightBottom ; j--) {
				
				//Mur vertical
				if(i == widthRight-1)
					World.getTiles()[i][j] = 2;
				//Mur horizontal
				if(j == heightBottom+1)
					World.getTiles()[i][j] = 2;
			}
		}
		
		//coin inferieur droit
		for(i = xMiddle+1; i < widthRight ; i++) {
			for(j = yMiddle+1; j < heightTop ; j++) {
				
				//Mur vertical
				if(i == widthRight-1)
					World.getTiles()[i][j] = 2;
				//Mur horizontal
				if(j == heightTop-1)
					World.getTiles()[i][j] = 2;
			}
		}
		
		//coin superieur gauche
		for(i=xMiddle-1; i > widthLeft ; i--) {
			for(j=yMiddle-1; j > heightBottom ; j--) {
				//Mur vertical
				if(i == widthLeft+1)
					World.getTiles()[i][j] = 2;
				//Mur horizontal
				if(j == heightBottom+1)
					World.getTiles()[i][j] = 2;
			}
		}
		
		//coin inferieur gauche
		for(i = xMiddle - 1 ; i > widthLeft ; i--) {
			for (j = yMiddle + 1 ; j < heightTop ; j++) {
				
				//Mur vertical
				if(i == widthLeft+1)
					World.getTiles()[i][j] = 2;
				//Mur vertical
				if(j == heightTop-1)
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