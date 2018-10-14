package main.world.dungeon;

import java.util.ArrayList;

import main.Handler;

public class RoomManager {
	
	private Handler handler;
	private Corridor corridor;
	private Room room;
	private ArrayList<Room> rooms;
	
//Constructeur
	public RoomManager(Handler handler) {
		this.handler = handler;
		//this.room = room;
		rooms = new ArrayList<Room>();
		//addRoom(room);
	}
	
//Ajout room
	public void addRoom(Room r) {
		rooms.add(r);
	}

//Creation de toutes les rooms
	public void create(ArrayList<Room> rooms) {
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
