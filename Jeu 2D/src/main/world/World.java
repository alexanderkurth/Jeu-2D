package main.world;

import java.awt.Graphics;

import main.Handler;
import main.entities.EntityManager;
import main.entities.creatures.Player;
import main.tile.Tile;
import main.world.dungeon.Corridor;
import main.world.dungeon.RoomManager;
import main.world.dungeon.rooms.Room;
import main.world.dungeon.rooms.RoomSpawn;

public class World {
	
	//scale
	private int scale = 64;

	//handler
	private Handler handler;
	//Longueur et largeur
	private static int width, height;
	//Coordonnees joueur
	private int spawnX = 55;
	private int spawnY = 55;
	//Tuiles niveau
	private static int[][] tiles;
	//Entities
	private EntityManager entityManager;
	
	private RoomManager roomManager;
	
	private RoomSpawn spawn;
	
	public World(Handler handler, String path){
		this.handler = handler;
		//Entity Manager
		entityManager = new EntityManager(handler, new Player(handler, spawnX, spawnY));
		
		// Temporary entity code!
		//entityManager.addEntity(new Tree(handler, 100, 250));
		
		spawn = new RoomSpawn(6,6,5,5);
		//Room Manager
		roomManager = new RoomManager(handler);
		roomManager.addRoom(spawn);
		//dungeonManager.addRoom(new Room(handler, 12,12,9,9));
		roomManager.addRoom(new Room( 32,48,9,9));
		roomManager.addRoom(new Room( 19,26,5,5));
		//loadWorld(path);
		createWorld();
		Corridor c = new Corridor(3,3,3,5);
		//c.corridorVertical();		
		
		entityManager.getPlayer().setX(3);
		entityManager.getPlayer().setY(3);
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
		
		Tile t = Tile.tiles[getTiles()[x][y]];
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
		setTiles(new int[height][width]);
		
		createRooms();
		


	}
	
	public void createRooms() {
		roomManager.create(roomManager.getRooms());
		
	}

	//Getters & Setters
	
	public static int getWidth(){
		return width;
	}
	
	public static int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public static int[][] getTiles() {
		return tiles;
	}

	public static void setTiles(int[][] tiles) {
		World.tiles = tiles;
	}
}

