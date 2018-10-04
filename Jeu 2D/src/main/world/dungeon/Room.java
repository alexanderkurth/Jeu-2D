package main.world.dungeon;

import java.util.Random;

import main.world.World;

public class Room extends Dungeon{
	
	Corridor c = new Corridor(3,3,5,3);
	
	private int xDoor;
	private int yDoor;

	public Room(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void createRoom() {
		c.corridoVertical();
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

		Random rand = new Random();
		int nombreAleatoire = rand.nextInt(4 - 1 + 1) + 1;

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


				//Mur droite bas
				if(i ==widthBottomRight-1 ) 
					World.getTiles()[i][j] = 2;

				//Mur bas droite
				if(j == heightBottomRight-1)
					World.getTiles()[i][j] = 2;
				

				if(i == xMiddle && j == heightBottomRight-1) {
					World.getTiles()[i][j] = 1;
				}
					
			}
		}

		
	}

	
	//Getters & Setters
	public int getxDoor() {
		return xDoor;
	}

	public void setxDoor(int xDoor) {
		this.xDoor = xDoor;
	}

	public int getyDoor() {
		return yDoor;
	}

	public void setyDoor(int yDoor) {
		this.yDoor = yDoor;
	}
	
	


}