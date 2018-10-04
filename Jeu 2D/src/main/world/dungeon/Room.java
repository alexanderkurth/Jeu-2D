package main.world.dungeon;

import java.util.Random;

import main.world.World;

public class Room extends Dungeon{

	public Room(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void createRoom() {
		int heightRoom = y + height;
		int widthRoom = x + width;

		int xMiddle = (x + widthRoom)/2;
		int yMiddle = (y +heightRoom)/2;
		//bas
		int widthBottomRight =  xMiddle + width;
		int heightBottomRight = yMiddle + height;
		int widthBottomLeft = xMiddle - width;
		//bas
		int widthTopLeft = xMiddle - width ;
		int heightTopLeft = yMiddle-height ;
		
		
	//	int //

		Random rand = new Random();
		int nombreAleatoire = rand.nextInt(4 - 1 + 1) + 1;
		//System.out.println(nombreAleatoire);
		/*
		for(int i=x; i < widthRoom; i++) {
			for(int j=y; j < heightRoom; j++) {

				if(i == x ) 
					World.getTiles()[i][j] = 2;


				if(i != x && j == (heightRoom-1)) 
					World.getTiles()[i][j]= 2;


				if(j == y && x != (widthRoom-1)) 
					World.getTiles()[i][j] = 2;


				if(i == widthRoom-1) 
					World.getTiles()[i][j] = 2;


				if( i == xMiddle && j ==yMiddle)
					World.getTiles()[i][j] = 1;

				if( i == widthRoom-1 && j ==yMiddle)
					World.getTiles()[i][j] = 1;

			}

		}
		*/
		//En haut à droite
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
				//World.getTiles()[i][j] = 1;
				//Mur droite haut
				if(i == widthTopLeft+1)
					World.getTiles()[i][j] = 2;
				//Mut haut droite
				if(j == heightTopLeft+1)
					World.getTiles()[i][j] = 2;
			}
		}
		
		//En bas à gauche
		for (int i = xMiddle ; i > widthBottomLeft ; i--) {
			for (int j = yMiddle ; j < heightBottomRight ; j++) {
				//World.getTiles()[i][j] = 1;
				
				//Mur gauche bas
				if(i == widthBottomLeft+1)
					World.getTiles()[i][j] = 2;
				//Mur bas gauche
				if(j == heightBottomRight-1)
					World.getTiles()[i][j] = 2;
		}
	}
		
		//En bas à droite
			for (int i = xMiddle ; i < widthBottomRight ; i++) {
				for (int j = yMiddle ; j < heightBottomRight ; j++) {
					
					if(i == xMiddle && j == yMiddle)
						World.getTiles()[i][j] = 2;
					
					//Mur droite bas
					if(i ==widthBottomRight-1 ) 
						World.getTiles()[i][j] = 2;
					
					//Mur bas droite
					if(j == heightBottomRight-1)
						World.getTiles()[i][j] = 2;
			}
		}
			
			System.out.println(widthBottomLeft);
				}
			

	}