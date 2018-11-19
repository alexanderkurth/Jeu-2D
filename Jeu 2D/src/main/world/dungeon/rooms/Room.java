package main.world.dungeon.rooms;

import main.world.World;

public class Room {

	protected int x;
	protected int y;
	protected int height;
	protected int width;

	protected int xMiddle;
	protected int yMiddle;

	protected int i;
	protected int j;

	public Room(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		this.xMiddle = (this.x + this.height) / 2;
		this.yMiddle = (this.y + this.width) / 2;
	}

	public void createRoom() {
		int widthRight = xMiddle + width + 1;
		int heightTop = yMiddle + height + 1;

		int widthLeft = xMiddle - width - 1;
		int heightBottom = yMiddle - height - 1;

		// coin supérieur droit
		for (i = xMiddle + 1; i < widthRight; i++) {
			for (j = yMiddle - 1; j > heightBottom; j--) {

				// Mur vertical
				if (i == widthRight - 1)
					World.getTiles()[i][j] = 2;
				// Mur horizontal
				if (j == heightBottom + 1)
					World.getTiles()[i][j] = 2;
			}
		}

		// coin inferieur droit
		for (i = xMiddle + 1; i < widthRight; i++) {
			for (j = yMiddle + 1; j < heightTop; j++) {

				// Mur vertical
				if (i == widthRight - 1)
					World.getTiles()[i][j] = 2;
				// Mur horizontal
				if (j == heightTop - 1)
					World.getTiles()[i][j] = 2;
			}
		}

		// coin superieur gauche
		for (i = xMiddle - 1; i > widthLeft; i--) {
			for (j = yMiddle - 1; j > heightBottom; j--) {
				// Mur vertical
				if (i == widthLeft + 1)
					World.getTiles()[i][j] = 2;
				// Mur horizontal
				if (j == heightBottom + 1)
					World.getTiles()[i][j] = 2;
			}
		}

		// coin inferieur gauche
		for (i = xMiddle - 1; i > widthLeft; i--) {
			for (j = yMiddle + 1; j < heightTop; j++) {

				// Mur vertical
				if (i == widthLeft + 1)
					World.getTiles()[i][j] = 2;
				// Mur vertical
				if (j == heightTop - 1)
					World.getTiles()[i][j] = 2;
			}
		}

		creerOuverture(widthRight, heightTop, widthLeft, heightBottom);

	}

	private void creerOuverture(int widthRight, int heightTop, int widthLeft, int heightBottom) {
		for (i = widthLeft; i < widthRight; i++) {
			for (j = heightBottom; j < heightTop; j++) {

				if (i > width) {
					// Gauche
					if (i == widthLeft + 1 & j == yMiddle) {
						World.getTiles()[i][j] = 2;
					}
				} else if (i == widthLeft + 1 & j == yMiddle) {
					World.getTiles()[i][j] = 2;
				}

				if (i < World.getWidth() - width) {
					// Droite
					if (i == widthRight - 1 && j == yMiddle) {
						World.getTiles()[i][j] = 2;
					}
				}else if (i == widthRight - 1 && j == yMiddle) {
					World.getTiles()[i][j] = 2;
				}

				if (j < World.getHeight() - height) {
					// Bas
					if (i == xMiddle & j == heightTop - 1) {
						World.getTiles()[i][j] = 2;
					}
				}else if (i == xMiddle & j == heightTop - 1) {
					World.getTiles()[i][j] = 2;
				}
				
				if (j > height) {
					// haut
					if (i == xMiddle & j == heightBottom + 1) {
						World.getTiles()[i][j] = 2;
					}
				}else if (i == xMiddle & j == heightBottom + 1) {
					World.getTiles()[i][j] = 2;
				}


			}
		}

	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getxMiddle() {
		return xMiddle;
	}

	public void setxMiddle(int xMiddle) {
		this.xMiddle = xMiddle;
	}

	public int getyMiddle() {
		return yMiddle;
	}

	public void setyMiddle(int yMiddle) {
		this.yMiddle = yMiddle;
	}
}