package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaTest {
	private static final String ATTREZZO = "attrezzoDiTest";
	private static final String STANZA = "stanzaDiTest";
	private static final String STANZA_ADIACENTE = "stanzaAdiacente";
	//private static final String NORD = "nord";
	private static final Direzione NORD = Direzione.NORD;
	private Stanza stanza;

	
	@Before
	public void setUp() {
		this.stanza = new Stanza(STANZA);
		
	}
	
	@Test
	public void TestImpostaStanzaAdiacenteSingola() {
		Stanza adiacente = creaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertEquals(adiacente, this.stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testCambiaStanzaAdiacente() {
		creaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		Stanza nuova = creaEImpostaAdiacente(this.stanza, "nuovaAdiacente", NORD);
		assertEquals(nuova, this.stanza.getStanzaAdiacente(NORD));
	}
	
	
	
	@Test
	public void testGetStanzaAdiacenteNonEsistente() {
		assertNull(this.stanza.getStanzaAdiacente(NORD));
	}
	
	
	@Test
	public void testGetStanzaAdiacenteEsistente() {
		creaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertNotNull(this.stanza.getStanzaAdiacente(NORD));
	}
	


	@Test
	public void testAddAttrezzoSingolo() {
		Attrezzo attrezzoSemplice = new Attrezzo(ATTREZZO, 1);
		this.stanza.addAttrezzo(attrezzoSemplice);
		assertEquals(attrezzoSemplice, this.stanza.getAttrezzo(ATTREZZO));
	}
	
	
	
	
	@Test
	public void testHasAttrezzoSingolo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 1);
		this.stanza.addAttrezzo(attrezzo);
		assertTrue(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	
	@Test
	public void testHasAttrezzoInesistente() {
		assertFalse(this.stanza.hasAttrezzo("inesistente"));
	}
	
	
	private Stanza creaEImpostaAdiacente(Stanza stanzaIniziale, String nomeStanzaAdiacente, Direzione direzione) {
		Stanza stanzaAdiacente = new Stanza (nomeStanzaAdiacente);
		stanzaIniziale.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return stanzaAdiacente;
	}
}
	
	
