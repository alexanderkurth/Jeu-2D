package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Game;
import main.Handler;
import main.entities.creatures.Player;
import main.entities.statics.Tree;
import main.world.World;

public class CollisionTest {
	
	Player player;
	Handler handler;
	Game game;
	World world;
	
	@BeforeEach
	public void setUp() {
		this.game = new Game("Jeu",100,100);
		
		this.handler = new Handler(game);
		this.player = new Player(handler, 0, 0);
		this.world = new World(handler, "test");
	}
	
	@After
	public void tearDown(){
		this.game = null;
		this.handler = null;
		this.player = null;
		this.world = null;
		
		
	}
	
	@Test
	void testCollisionArbreParLaDroite() {
		world.getEntityManager().addEntity(new Tree(handler, 3, 3));
		
		player.setX(2);
		player.setY(3);

		player.setxMove(1);
		
		assertEquals(2.0, player.getX());
	}
	
	@Test
	void testCollisionArbreParLaGauche() {
		world.getEntityManager().addEntity(new Tree(handler, 3, 3));
		
		player.setX(4);
		player.setY(3);
		
		player.setxMove(-1);
		
		assertEquals(4.0,player.getX());
	}

}
