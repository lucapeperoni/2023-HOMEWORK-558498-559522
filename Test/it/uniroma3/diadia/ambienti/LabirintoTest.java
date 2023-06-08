package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {

	private Labirinto labirinto;
	private static final String STANZA_VINCENTE = "biblioteca";
	private static final String STANZA_INIZIALE = "atrio";
	
	@Before
	public void setUp(){
		this.labirinto = new Labirinto();
		labirinto = labirinto.creaStanze();
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals(STANZA_VINCENTE, this.labirinto.getStanzaVincente().getNome());
	}

	@Test
	public void testGetStanzaIniziale() {
		assertEquals(STANZA_INIZIALE, this.labirinto.getStanzaIniziale().getNome());
	}

}
