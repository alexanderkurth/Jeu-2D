package test;

import org.junit.After;
import org.junit.Before;

import main.input.KeyManager;

public class InputTest {
	
	KeyManager keyManager;
	
	@Before
	public void setUp() {
		this.keyManager = new KeyManager();
	}
	
	@After
	public void tearDown() {
		this.keyManager = null;
	}
	
	public void testInput() {
		
	}

}
