package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.*;


public class StanzaBuiaTest {
	
	private Stanza stanzaTest;
	private Attrezzo attrezzoLuce;
	private Attrezzo attrezzoNonLuce;
	private static final String STANZA_TEST = "stanzaDiTest";
	private static final String LANTERNA = "lanterna";
	private static final int PESO = 1;

	@Before
	public void setUp() {
		this.attrezzoLuce = new Attrezzo (LANTERNA, PESO);
		this.attrezzoNonLuce = new Attrezzo ("test", PESO);
		this.stanzaTest = new StanzaBuia (STANZA_TEST, LANTERNA);
	}

	@Test
	public void testPosaAttrezzoDiversoDaLanterna() {
		assertFalse(stanzaTest.addAttrezzo(attrezzoNonLuce));
		
	}
	
	@Test
	public void testPosaAttrezzoLanterna() {
		assertTrue(stanzaTest.addAttrezzo(attrezzoLuce));
		
	}
	
	@Test
	public void testPosaPiuAttrezziDopoLanterna() {
		stanzaTest.addAttrezzo(attrezzoLuce);
		assertTrue(stanzaTest.addAttrezzo(attrezzoNonLuce));
		
	}

}
