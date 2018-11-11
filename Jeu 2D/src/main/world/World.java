package main.world;

import java.awt.Graphics;

import main.Handler;
import main.entities.EntityManager;
import main.entities.creatures.Player;
import main.entities.statics.Tree;
import main.tile.Tile;
import main.world.dungeon.Corridor;
import main.world.dungeon.RoomManager;
import main.world.dungeon.rooms.Room;
import main.world.dungeon.rooms.RoomSpawn;

public class World {		
	//coordonn�es spawn
	int xSpawn = 6;
	int ySpawn = 6;
	int SpawnWidth = 5;
	int SpawnHeight = 5;

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

		spawn = new RoomSpawn(xSpawn,ySpawn,SpawnWidth,SpawnHeight);
		//Room Manager
		roomManager = new RoomManager(handler);
		roomManager.addRoom(spawn);

		//loadWorld(path);
		createWorld();

		entityManager.getPlayer().setX(100);
		entityManager.getPlayer().setY(100);
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

	/*
	 * int x = spawn.getxMiddle();
		int y = spawn.getyMiddle();
	 */


	public void createRooms() {
		int ecart = 5;
		
		int verif2 = 1;
		int verif3 = 1;
		
		int xMin = 1;
		int yMax =2;
		
		int random = random(xMin,yMax);

		int verifDroite = 1;
		int verifBas = 1;

		System.out.println(random);

		int x = 5;
		int y = 5;
		
		Corridor c1;
		Corridor c2;
		Corridor c3;
		Corridor c4;
		Corridor c5;
		Corridor c6;

		Room room2;
		Room room3;
		Room room4;
		Room room5;
		Room room6;
		Room room7;
		Room room8;
		Room room9;
		Room room10;

		if( random%2 == 0) {
			//droite
			xSpawn += 30;
			x += 5;
			y -= 1;
			verifDroite++;

			roomManager.addRoom(room2 = new Room(xSpawn,ySpawn,SpawnWidth,SpawnHeight));
			c2 = new Corridor(x,y,5,3);

			System.out.println(x + " " + y + " " + verifDroite);

			roomManager.addCorridor(c2);

			random = random(xMin,yMax);

			if(random%2 == 0) {
				//droite
				xSpawn += 30;
				roomManager.addRoom(room3 = new Room(xSpawn,ySpawn,SpawnWidth,SpawnHeight));

				System.out.println(x*verifDroite + " " + y);

				c3 = new Corridor(x*verifDroite+ecart*verif2,y*verifBas,5,3);

				roomManager.addCorridor(c3);

				random = random(xMin,yMax);

				if(random%2 == 0) {
					verifDroite++;
					verif2++;
					//droite
					xSpawn += 30;
					roomManager.addRoom(room4 = new Room(xSpawn,ySpawn,SpawnWidth,SpawnHeight));

					c4 = new Corridor(x*verifDroite+ecart*verif2,y*verifBas,5,3);

					System.out.println(x*verifDroite+10 + " " + y);

					roomManager.addCorridor(c4);

					random = random(xMin,yMax);

					if(random%2 == 0) {
						//droite
						verifDroite++;
						verif2++;

						xSpawn += 30;
						roomManager.addRoom(room5 = new Room(xSpawn,ySpawn,SpawnWidth,SpawnHeight));

						c5 = new Corridor(x*verifDroite+ecart*verif2,y*verifBas, 5, 3);

						System.out.println(x*verifDroite+10 + " " + y);

						roomManager.addCorridor(c5);

						random = random(xMin,yMax);	
						
						if(random%2 == 0) {
							//droite
							verifDroite++;
							verif2++;

							xSpawn += 30;
							roomManager.addRoom(room5 =new Room(xSpawn,ySpawn,SpawnWidth,SpawnHeight));

							c6 = new Corridor(x*verifDroite+ecart*verif2,y*verifBas,5,3);

							System.out.println(x*verifDroite+ecart*verif2 + " " + y);

							roomManager.addCorridor(c6);

						}else {
							//bas
						}

					}else {
						//bas
					}

				}else {
					// bas
				}

			}else {
				//bas
			}
		}else {
			//bas
			ySpawn += 30;
			x -= 1;
			ecart = 5;
			y += 5;
			verifBas ++;
			
			roomManager.addRoom(room2 = new Room(xSpawn,ySpawn,SpawnWidth,SpawnHeight));
			c2 = new Corridor(x,y,3,5);

			System.out.println(x + " " + y);

			roomManager.addCorridor(c2);

			random = random(xMin,yMax);
			
			if(random%1 == 0) {
				//bas
				
				ySpawn += 30;
				
				roomManager.addRoom(room3 = new Room(xSpawn,ySpawn,SpawnWidth,SpawnHeight));
				c3 = new Corridor(x,y*verifBas+ecart*verif3,3,5);

				System.out.println(x + " " + (y*verifBas+ecart*verif3));

				roomManager.addCorridor(c3);

				random = random(xMin,yMax);
				
				if(random%1 == 0) {
					//bas
					
					ySpawn += 30;
					verifBas ++;
					verif3++;

					
					roomManager.addRoom(room4 = new Room(xSpawn,ySpawn,SpawnWidth,SpawnHeight));
					c4 = new Corridor(x,y*verifBas+ecart*verif3,3,5);

					System.out.println(x + " " + (y*verifBas+ecart*verif3));

					roomManager.addCorridor(c4);

					random = random(xMin,yMax);
					
					if(random%1 == 0) {
						//bas
						
						ySpawn += 30;
						verifBas ++;
						verif3++;

						
						roomManager.addRoom(room4 = new Room(xSpawn,ySpawn,SpawnWidth,SpawnHeight));
						c4 = new Corridor(x,y*verifBas+ecart*verif3,3,5);

						System.out.println(x + " " + (y*verifBas+ecart*verif3));

						roomManager.addCorridor(c4);

						random = random(xMin,yMax);
						
						if(random%1 == 0) {
							//bas
							
							ySpawn += 30;
							verifBas ++;
							verif3++;

							
							roomManager.addRoom(room4 = new Room(xSpawn,ySpawn,SpawnWidth,SpawnHeight));
							c4 = new Corridor(x,y*verifBas+ecart*verif3,3,5);

							System.out.println(x + " " + (y*verifBas+ecart*verif3));

							roomManager.addCorridor(c4);

							random = random(xMin,yMax);
							
						}else {
							//droite
						}
						
					}else {
						//droite
					}
					
				}else {
					//droite
				}

			}else {
				//droite
			}
		}

		/*
		int verifDroite = 0;
		int verifBas = 0;

		int test = 4;

		while(test != 0) {

			int random = random(1,2);
			if(random%2 == 0) {

				x+=30;	

				roomManager.addRoom(new Room(x,y,5,5));
				roomManager.addCorridor(new Corridor((x-(25*verifDroite)),(y-1),5,3));

				System.out.println(x +" "+y);
				System.out.println((x-(25*verifDroite))+" : "+ (y-1) + "droite");	


				verifDroite +=1;			
			}else {

				y+=30;

				roomManager.addRoom(new Room(x,y,5,5));	



				verifBas += 1;
			}


			System.out.println(verifDroite +" : "+ verifBas);
			//System.out.println(x +" : "+ y);
			test --;
		}		
		 */
		roomManager.createCorridor(roomManager.getCorridors());
		roomManager.createRoom(roomManager.getRooms());


		/*
		if( random%2 == 0) {
			roomManager.addRoom(room2 = new Room(xSpawn,6*ySpawn,SpawnWidth,SpawnHeight));

			Corridor c = new Corridor(x-1,2*y,3,5);
			roomManager.addCorridor(c);

			random = 0 + (int)(Math.random() * ((2 - 0) + 1));

			if(random%2 == 0) {
				roomManager.addRoom(room3 = new Room(6*xSpawn,6*ySpawn,SpawnWidth,SpawnHeight));

				Corridor c2 = new Corridor(2*x,(4*y)-1,5,3);
				roomManager.addCorridor(c2);

				random = 0 + (int)(Math.random() * ((2 - 0) + 1));

			}else {
				roomManager.addRoom(room2 = new Room(xSpawn,11*ySpawn,SpawnWidth,SpawnHeight));

				Corridor c2 = new Corridor(x-1,5*y,3,5);
				roomManager.addCorridor(c2);
			}

		}else {
			roomManager.addRoom(room2 = new Room(6*xSpawn,ySpawn,SpawnWidth,SpawnHeight));

			Corridor c = new Corridor(2*x,y-1,5,3);
			roomManager.addCorridor(c);

			random = 0 + (int)(Math.random() * ((2 - 0) + 1));

			if(random%2 == 0) {
				roomManager.addRoom(room3 = new Room(11*xSpawn,ySpawn,SpawnWidth,SpawnHeight));

				Corridor c2 = new Corridor(5*x,y-1,5,3);
				roomManager.addCorridor(c2);
			}else {
				roomManager.addRoom(room3 = new Room(6*xSpawn,6*ySpawn,SpawnWidth,SpawnHeight));

				Corridor c2 = new Corridor(4*x-1,2*y,3,5);
				roomManager.addCorridor(c2);
			}
		}
		 */

	}

	public int random(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1)); 
	}	

	public void createRoomAtCoordoninate(int xRoom, int yRoom) {

		roomManager.addRoom(new Room(xRoom,yRoom,SpawnWidth,SpawnHeight));

	}

	public void createCorridorVerticalAtCoordinate(int xCorridor, int yCorridor) {
		roomManager.addCorridor(new Corridor(xCorridor, yCorridor,3, 5));
	}

	public void createCorridorHorizontalAtCoordinate(int xCorridor, int yCorridor) {
		roomManager.addCorridor(new Corridor(xCorridor, yCorridor,5, 3));
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

