package main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right, inventory;
	public boolean aUp, aDown, aLeft, aRight;
	
	public KeyManager(){
		keys = new boolean[256];
		justPressed = new boolean[ keys.length];
		cantPress = new boolean[ keys.length];
	}
	
	public void tick(){
		for(int i = 0; i <  keys.length; i++) {
			if(cantPress[i] && !keys[i]) {
				cantPress[i] =false;
			}else if(justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}
		/*
		if(keyJustPressed(KeyEvent.VK_E)) {
			System.out.println("e pressed");
		}
		*/
		up = keys[KeyEvent.VK_Z];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_Q];
		right = keys[KeyEvent.VK_D];
		inventory = keys[KeyEvent.VK_I];
		
		aUp = keys[KeyEvent.VK_UP];
		aDown = keys[KeyEvent.VK_DOWN];
		aLeft = keys[KeyEvent.VK_LEFT];
		aRight = keys[KeyEvent.VK_RIGHT];
		
	}
	
	public boolean keyJustPressed(int keyCode){
		if(keyCode == 0 || keyCode == keys.length)
			return false;
		return justPressed[keyCode];
		}
	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() > keys.length)
			return ;
		
		keys[e.getKeyCode()] = true;
		//System.out.println("pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public boolean isIPressed() {
		return inventory;
	}

}