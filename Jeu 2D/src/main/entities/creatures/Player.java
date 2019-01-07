package main.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.Handler;
import main.entities.Entity;
import main.graphics.Animation;
import main.graphics.Assets;
import main.inventory.Inventory;

public class Player extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight, idle, attaqueDroite, attaqueGauche;
	// Attack timer
	private long lastAttackTimer, attackCooldown = 600, attackTimer = attackCooldown;
	
	private Inventory inventory;
	
	private boolean attackRight;
	private boolean attackLeft;
	private boolean attackActive;
		
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//Corpse
		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 17;
		bounds.height = 13;
		
		
		//arm
		armBounds.x = 22;
		armBounds.y = 40;
		armBounds.width = 16;
		armBounds.height = 4;
		
		
		//Animatons
		animDown = new Animation(175, Assets.player_down);
		animUp = new Animation(175, Assets.player_up);
		animLeft = new Animation(175, Assets.player_left);
		animRight = new Animation(175, Assets.player_right);
		
		idle = new Animation(500, Assets.player_idle);
		
		attaqueDroite = new Animation(100, Assets.player_rightAttack);
		attaqueGauche = new Animation(100,Assets.player_leftAttack);
		
		inventory = new Inventory(handler);
		
		attackRight = false;
		attackLeft = false;
		attackActive = false;
	}
	
	

	@Override
	public void tick() {
		//Animations
		idle.tick();
		attaqueDroite.tick();
		attaqueGauche.tick();
		
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		//Movement
		getInput();
		
		if(!attackActive)
			move();
		
		handler.getGameCamera().centerOnEntity(this);
		// Attack
		checkAttacks();
		
		//inventory
		inventory.tick();
	}

	private void checkAttacks(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		
		if(attackTimer < attackCooldown) {
			return;
		}

			
		Rectangle cb = getAttackBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 16;
		ar.width = arSize;
		ar.height = 4;
		
		
		//a modifier pour la position du joueur
		
		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
			
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
			
		}else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
			attackActive = true;
			attackLeft =  true;
			armBounds.x = 10;
			
		}else if(handler.getKeyManager().aRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
			attackActive = true;
			attackRight =  true;
			armBounds.x = 30;
			
		}else{
			armBounds.x = 24;
			attackActive= false;
			attackRight = false;
			attackLeft = false;
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(100);
				return;
			}
		}
		
		
	}
	
	@Override
	public void die(){
		System.out.println("You lose");
	}
	
	public void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
			g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);		
		/*
		g.setColor(Color.red);
		g.fillRect((int) (x + armBounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + armBounds.y - handler.getGameCamera().getyOffset()),
				armBounds.width, armBounds.height);
				*/
		/*
		g.setColor(Color.blue);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);
		*/
		inventory.render(g);
	}
	
	
	private BufferedImage getCurrentAnimationFrame(){
		
		if(attackRight) {			
			return attaqueDroite.getCurrentFrame();			
		}
		if(attackLeft) {
			return attaqueGauche.getCurrentFrame();
		}
		
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else if(yMove > 0){
			return animDown.getCurrentFrame();
		}else {
			return idle.getCurrentFrame();
		}

	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}