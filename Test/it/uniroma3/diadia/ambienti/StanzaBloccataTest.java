package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class StanzaBloccataTest {
	

	private Stanza stanzaTest;
	private Stanza stanzaAdiacente;
	private Partita partita;
	private Labirinto builder;
	private IO io;
	private static final String STANZA_TEST = "stanzaDiTest";
	private static final String CHIAVE = "chiave";
	private static final Direzione DIREZIONE_BLOCCATA = Direzione.EST;
	private static final Direzione DIREZIONE_GENERICA = Direzione.NORD;
	private static final int PESO = 1;
	static final FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
	static final Comando vai = factory.costruisciComando("vai");
	
	
	
	
	@Before
	public void setUp(){
		this.io = new IOConsole();
		this.stanzaTest = new StanzaBloccata(STANZA_TEST, CHIAVE, DIREZIONE_BLOCCATA);
		this.stanzaAdiacente = new Stanza("stanzaAdiacente");
	}

	@Test
	public void testStanzaConChiave() {
		this.builder = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale("inizio")
				.addStanzaBloccata(STANZA_TEST, CHIAVE, DIREZIONE_BLOCCATA)
				.addAttrezzo(STANZA_TEST, CHIAVE, PESO)
				.addStanza(stanzaAdiacente.getNome())
				.addAdiacenza("inizio", STANZA_TEST, DIREZIONE_GENERICA)
				.addAdiacenza(STANZA_TEST, stanzaAdiacente.getNome(), DIREZIONE_BLOCCATA)
				.getLabirinto();
		
		this.partita = new Partita(builder, io);
		

		vai.esegui(partita);
		vai.setParametro(DIREZIONE_GENERICA.getNome());
		vai.esegui(partita);
		vai.esegui(partita);
		vai.setParametro(DIREZIONE_BLOCCATA.getNome());
		vai.esegui(partita);
		assertNotEquals(stanzaTest.getNome(), partita.getStanzaCorrente().getNome());
		
	}
	
	@Test
	public void testStanzaSenzaChiave() {
		this.builder = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale("inizio")
				.addStanzaBloccata(STANZA_TEST, CHIAVE, DIREZIONE_BLOCCATA)
				.addStanza(stanzaAdiacente.getNome())
				.addAdiacenza("inizio", STANZA_TEST, DIREZIONE_GENERICA)
				.addAdiacenza(STANZA_TEST, stanzaAdiacente.getNome(), DIREZIONE_BLOCCATA)
				.getLabirinto();
		
		this.partita = new Partita(builder, io);
		
		
		vai.esegui(partita);
		vai.setParametro(DIREZIONE_GENERICA.getNome());
		vai.esegui(partita);
		vai.esegui(partita);
		vai.setParametro(DIREZIONE_BLOCCATA.getNome());
		vai.esegui(partita);
		assertEquals(stanzaTest.getNome(), partita.getStanzaCorrente().getNome());
		
		
	}
	

}
