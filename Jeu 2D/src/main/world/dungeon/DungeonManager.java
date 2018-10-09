package main.world.dungeon;

import java.util.ArrayList;

import main.Handler;

public class DungeonManager {
	
	private Handler handler;
	private Corridor corridor;
	private Room room;
	private ArrayList<Room> rooms;
	
//Constructeur
	public DungeonManager(Handler handler, Room room) {
		this.handler = handler;
		this.room = room;
		rooms = new ArrayList<Room>();
		addRoom(room);
	}
	
//Ajout room
	public void addRoom(Room r) {
		rooms.add(r);
	}

//Creation de toutes les rooms
	public void create(Room room) {
		for(Room r : rooms) {
			r.createRoom();
		}
	}
	
	
	//Getters & Setters
	public void setRoom(ArrayList<Room> room) {
		this.rooms = room;
	}


	public Corridor getCorridor() {
		return corridor;
	}


	public void setCorridor(Corridor corridor) {
		this.corridor = corridor;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	public ArrayList<Room> getRooms() {
		return rooms;
	}
	

}
