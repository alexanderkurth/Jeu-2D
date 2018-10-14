package main.world.dungeon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import main.Handler;
import main.world.World;

public class Room extends Dungeon{
	
	Corridor c = new Corridor(handler, 3,4,5,3);
	
	private Rectangle bounds;
	
	private int xDoor;
	private int yDoor;

	public Room(Handler handler,int x, int y, int width, int height) {
		super(handler, x, y, width, height);
		bounds = new Rectangle(x,y,width,height);
	}

	public void createRoom() {
		//c.corridorHorizontal();
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
				
				//Porte Milieu
				if(i == xMiddle && j == heightTopLeft+1)
					World.getTiles()[i][j] = 1;
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
				
				//PorteMilieu
				if(i== widthBottomLeft+1 && j == yMiddle)
					World.getTiles()[i][j] = 1;
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
				
				//Porte Milieu
				if(i == xMiddle && j == heightBottomRight-1) {
					World.getTiles()[i][j] = 1;
				}
				
				if( i == widthBottomRight-1 && j == yMiddle) {
					World.getTiles()[i][j] = 1;
				}
					
			}
		}

		
	}
	
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.drawRect(bounds.x,bounds.y,bounds.width,bounds.height);
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