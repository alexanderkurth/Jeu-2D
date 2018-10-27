package main.world.dungeon.rooms;

import main.world.World;

public class Room{
	
	private int x;
	private int y;
	private int height;
	private int width;
	
	private int xMiddle;
	private int yMiddle;
	
	private int i;
	private int j;
	
	public Room(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
		this.xMiddle = (this.x + this.height)/2;
		this.yMiddle = (this.y + this.width)/2;
	}

	public void createRoom() {
		int widthRight = xMiddle+width+1;
		int heightTop = yMiddle+height+1;
		//System.out.println(widthRight +","+heightTop);
		
		int widthLeft = xMiddle-width-1;
		int heightBottom = yMiddle-height-1;
		//System.out.println(widthLeft +","+heightBottom);

		
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

		creerOuverture(widthRight, heightTop, widthLeft, heightBottom);
		
	}

	private void creerOuverture(int widthRight, int heightTop, int widthLeft, int heightBottom) {
		for(i = widthLeft ; i < widthRight ; i++) {
			for(j = heightBottom ; j < heightTop ; j++) {
				
				if(i != 0 & j <World.getHeight() & i<World.getWidth() & j!= 0) {
				//Gauche
				if(i == widthLeft+1 & j== yMiddle)
					World.getTiles()[i][j] = 1;
				
				//Droite
				if(i == widthRight-1 && j == yMiddle)
					World.getTiles()[i][j] = 1;
				
				//Bas
				if(i == xMiddle & j == heightTop-1)
					World.getTiles()[i][j] = 1;
				
				//haut
				if(i == xMiddle & j == heightBottom+1)
					World.getTiles()[i][j] = 1;
			}else {
				if( i == xMiddle & j==0 ) {
					World.getTiles()[i][j] = 2;
				}
				if(i == 0 & j==xMiddle) {
					World.getTiles()[i][j] = 2;
				}
				if(j == heightTop & i != 0) {
					World.getTiles()[i][j] = 2;
				}
				if(i == widthRight & j!= 0) {
					World.getTiles()[i][j] = 2;
				}
			}
			}
		}
	}

}