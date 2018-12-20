package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Game;
import main.Handler;
import main.entities.creatures.Player;

class MouvementTest {
	
	Player player;
	Handler handler;
	Game game;
	
	@BeforeEach
	public void setUp() {
		this.game = new Game("Jeu",100,100);
		
		this.handler = new Handler(game);
		this.player = new Player(handler, 0, 0);
	}
	
	@After
	public void tearDown(){
		this.game = null;
		this.handler = null;
		this.player = null;
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
