package main.world.dungeon;

import java.awt.Graphics;
import java.util.ArrayList;

import main.Handler;
import main.entities.Entity;
import main.world.World;

public class DungeonManager {
	
	private Handler handler;
	private Corridor corridor;
	private Room room;
	private ArrayList<Room> rooms;
	
	public DungeonManager(Handler handler, Room room) {
		this.handler = handler;
		this.room = room;
		rooms = new ArrayList<Room>();
		addDungeon(room);
	}

	
	public void addDungeon(Room r) {
		rooms.add(r);
	}



	
	public void create(Room room) {
		for(Room r : rooms) {
			r.createRoom();
		}
	}
	
	public void render(Graphics g,Room room){
		for(Room r : rooms) {
			r.render(g);
		}
	}
	
	
	//Getters & Setters
	public ArrayList<Room> getDungeons() {
		return rooms;
	}


	public void setDungeons(ArrayList<Room> room) {
		this.rooms = room;
	}

}
