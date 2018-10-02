package main.world;

import java.awt.Graphics;
import java.util.Random;

import main.Handler;
import main.entities.EntityManager;
import main.entities.creatures.Player;
import main.tile.Tile;
import main.utils.Utils;

public class World {

	//handler
	private Handler handler;
	//Longueur et largeur
	private int width, height;
	//Coordonnees joueur
	private int spawnX, spawnY;
	//Tuiles niveau
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		// Temporary entity code!
		//entityManager.addEntity(new Tree(handler, 100, 250));
		
		//loadWorld(path);
		createWorld();
		
		entityManager.getPlayer().setX(200);
		entityManager.getPlayer().setY(200);
	}
	
	public void tick(){
		entityManager.tick();
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
/*
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	*/	
	public void createWorld() {
		width = 100;
		height = 100;
		tiles = new int[height][width];
		
		room(0,0,11,11);
		corridor(11,4,3,5);
	}
	
	private void room(int x, int y, int height, int width) {
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
					 tiles[i][j] = 2;
				 
				 
				 if(i != x && j == (heightRoom-1)) 
					 tiles[i][j] = 2;
				 
				 
				 if(j == y && x != (widthRoom-1)) 
					 tiles[i][j] = 2;
				 
				 
				 if(i == widthRoom-1) 
					 tiles[i][j] = 2;
				 
				 
				 if( i == xMiddle && j ==yMiddle)
					 tiles[i][j] = 1;
				 
				 if( i == widthRoom-1 && j ==yMiddle)
					 tiles[i][j] = 1;

			 }
		 }
	}
	
	private void corridor(int x, int y, int height, int width) {
		 int heightCorridor = y + height;
		 int widthCorridor = x + width;
		 
		 int xMiddle = (x + widthCorridor)/2;
		 int yMiddle = (y +heightCorridor)/2;
		 
		 for(int i=x; i < widthCorridor; i++) {
			 for(int j=y; j < heightCorridor; j++) {
				 
				 if(j == (heightCorridor-1)) 
					 tiles[i][j] = 2;
				 
				 
				 if(j == y && x != (widthCorridor-1)) 
					 tiles[i][j] = 2;
				 
				 
				 if( i == xMiddle && j ==yMiddle)
					 tiles[i][j] = 1;

			 }
		 }
	}

	
	//Getters & Setters
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}

