package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.fixture.Fixture;

public class LabirintoBuilderTest {

	private Labirinto builder;
	private static final String STANZA = "stanzaDiTest";
	private static final String STANZA2 = "stanzaDiTest2";
	private static final Direzione NORD = Direzione.NORD;
	private static final String ATTREZZO = "attrezzoDiTest";
	private static final String ATTREZZO2 = "attrezzoDiTest2";
	private static final String ATTREZZO3 = "attrezzoDiTest3";
	private static final String ATTREZZO4 = "attrezzoDiTest4";
	private static final int PESO = 1;
	
	@Before
	public void setUp() {
	}

	@Test
	public void testCreaStanzaVincente() {
		this.builder = new Labirinto.LabirintoBuilder()
				.addStanzaVincente(STANZA)
				.getLabirinto();
		assertEquals(STANZA, builder.getStanzaVincente().getNome());
	}

	@Test
	public void testCreaStanzaIniziale() {
		this.builder = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale(STANZA)
				.getLabirinto();
		assertEquals(STANZA, builder.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testCreaStanzeAdiacenti() {
		this.builder = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale(STANZA)
				.addStanza(STANZA2)
				.addAdiacenza(STANZA, STANZA2, NORD)
				.getLabirinto();
		assertEquals(STANZA2, builder.getStanzaIniziale().getStanzaAdiacente(NORD).getNome());
		
	}
	
	@Test
	public void testAggiungiAttrezzi() {
		this.builder = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale(STANZA)
				.addAttrezzo(STANZA, ATTREZZO, PESO)
				.getLabirinto();
		assertTrue(builder.getStanzaIniziale().hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testAggiungiDueAttrezziConNomeUgualeInStanzeDiverse() {
		String attrezzoConNomeUguale = new String("attrezzoDiTest");
		this.builder = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale(STANZA)
				.addAttrezzo(STANZA, ATTREZZO, PESO)
				.addStanza(STANZA2)
				.addAttrezzo(STANZA2, attrezzoConNomeUguale, PESO)
				.addAdiacenza(STANZA, STANZA2, NORD)
				.getLabirinto();
		
		assertFalse(builder.getStanzaIniziale().getStanzaAdiacente(NORD).hasAttrezzo(attrezzoConNomeUguale));
		assertTrue(builder.getStanzaIniziale().hasAttrezzo(ATTREZZO));
		
	}
	
	
	@Test
	public void testAggiungiStanzaBuia() {
		this.builder = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale(STANZA)
				.addStanzaBuia(STANZA2, ATTREZZO)
				.addAdiacenza(STANZA, STANZA2, NORD)
				.getLabirinto();
		
		assertNotNull(builder.getStanzaIniziale().getStanzaAdiacente(NORD));
		assertEquals("Qui c'è un buio pesto!", builder.getStanzaIniziale().getStanzaAdiacente(NORD).getDescrizione());
	}
	
	@Test
	public void testAggiungiStanzaBloccata() {
		this.builder = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale(STANZA)
				.addStanzaBloccata(STANZA2, ATTREZZO, NORD)
				.addAdiacenza(STANZA, STANZA2, NORD)
				.getLabirinto();
		
		assertNotNull(builder.getStanzaIniziale().getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testAggiungiStanzaMagica() {
		this.builder = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale(STANZA)
				.addStanzaMagica(STANZA2)
				.addAttrezzo(STANZA2, ATTREZZO, PESO)
				.addAttrezzo(STANZA2, ATTREZZO2, PESO)
				.addAttrezzo(STANZA2, ATTREZZO3, PESO)
				.addAttrezzo(STANZA2, ATTREZZO4, PESO)
				.addAdiacenza(STANZA, STANZA2, NORD)
				.getLabirinto();
		
		assertNotNull(builder.getStanzaIniziale().getStanzaAdiacente(NORD));
		assertTrue(builder.getStanzaIniziale().getStanzaAdiacente(NORD).hasAttrezzo(ATTREZZO));
		assertTrue(builder.getStanzaIniziale().getStanzaAdiacente(NORD).hasAttrezzo(ATTREZZO2));
		assertTrue(builder.getStanzaIniziale().getStanzaAdiacente(NORD).hasAttrezzo(ATTREZZO3));
		assertFalse(builder.getStanzaIniziale().getStanzaAdiacente(NORD).hasAttrezzo(ATTREZZO4));
		
	}
	
	
}
