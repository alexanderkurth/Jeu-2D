package main.states;

import java.awt.Graphics;

import main.Handler;

public class InventoryState extends State{

	public InventoryState(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {		
		if(handler.getKeyManager().isIPressed()) {
			
		}
	}

	@Override
	public void render(Graphics g) {
		
	}

}
