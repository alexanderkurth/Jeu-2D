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

		Random rand = new Random();
		int nombreAleatoire = rand.nextInt(4 - 1 + 1) + 1;
		System.out.println(nombreAleatoire);

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
	}
}