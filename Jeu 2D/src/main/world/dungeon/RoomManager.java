package main.world.dungeon;

import java.util.ArrayList;

import main.Handler;
import main.world.dungeon.rooms.Room;

public class RoomManager {
	
	private Handler handler;
	private Corridor corridor;
	private Room room;
	private ArrayList<Room> rooms;
	private ArrayList<Corridor> corridors;
	
//Constructeur
	public RoomManager(Handler handler) {
		this.handler = handler;
		rooms = new ArrayList<Room>();
		corridors = new ArrayList<Corridor>();
	}
	
//Ajout room
	public void addRoom(Room r) {
		rooms.add(r);
	}

//Creation de toutes les rooms
	public void createRoom(ArrayList<Room> rooms) {
		for(Room r : rooms) {
			r.createRoom();
		}
	}
	
	//Ajout corridor
	public void addCorridor(Corridor c) {
		corridors.add(c);
	}
	
	//Creation de toutes les corridors
		public void createCorridor(ArrayList<Corridor> corridors) {
			for(Corridor c : corridors) {
				c.create();
			}
		}
	
	
	//Getters & Setters
	public void setRoom(ArrayList<Room> room) {
		this.rooms = room;
	}
	
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public ArrayList<Corridor> getCorridors() {
		return corridors;
	}

	public void setCorridors(ArrayList<Corridor> corridors) {
		this.corridors = corridors;
	}

	public void setCorridor(Corridor corridor) {
		this.corridor = corridor;
	}

}
