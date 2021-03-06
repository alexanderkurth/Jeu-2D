package main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Handler;

public abstract class Entity {

	public static final int DEFAULT_HEALTH = 3;
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	
	protected Rectangle armBounds; 

	protected int health;
	protected boolean 	active =true;
	
	public Entity(Handler handler, float x, float y, int width, int height){
		health = DEFAULT_HEALTH;
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
		armBounds = new Rectangle(0,0,16,4);
	}
	
	public abstract void tick();
	
	public abstract void die();

	public abstract void render(Graphics g);
	
	public void hurt(int damage) {
		health -= damage;
		if(health <= 0) {
			active = false;
			die();
		}
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public boolean checkEntityAttack(float xOffset, float yOffset){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getAttackBounds(0f, 0f).intersects(getAttackBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	public Rectangle getAttackBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + armBounds.x + xOffset), (int) (y + armBounds.y + yOffset), armBounds.width, armBounds.height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}

