package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {

	private Giocatore giocatore;
	private static final int CFU = 5;
	private static final int CFU_INIZIALI = 25;
	
	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
	}

	@Test
	public void testSetCfu() {
		this.giocatore.setCfu(CFU);
		assertEquals(CFU,this.giocatore.getCfu());
	}
	
	
	@Test
	public void testCfuIniziali() {
		assertEquals(CFU_INIZIALI,this.giocatore.getCfu());
	}
	


}
