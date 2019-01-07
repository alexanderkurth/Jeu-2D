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

class MouvementTest {
	
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
	void testMouvementHaut() {
		player.setyMove(3);
		
		assertEquals(3.0, player.getyMove());
	}
	
	@Test
	void testMouvementBas() {
		player.setyMove(-3);
		
		assertEquals(-3.0, player.getyMove());
	}
	
	@Test
	void testMouvementDroite() {
		player.setxMove(3);
		
		assertEquals(3.0, player.getxMove());
	}
	
	@Test
	void testMouvementGauche() {
		player.setxMove(-3);
		
		assertEquals(-3.0, player.getxMove());
	}
	


}
