package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.*;


public class PartitaTest {
	
	private static final String STANZA = "stanzaDiTest";
	private static final int CFU_FINITI = 0;
	
	private Partita partita;
	private IO io;
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.io = new IOConsole();
		this.labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("iniziale")
				.addStanzaVincente("vincente")
				.getLabirinto();
//		this.labirinto = new Labirinto();
//		this.labirinto = labirinto.creaStanze();
		this.partita = new Partita(labirinto, io);
	}
	
	
	@Test
	public void testSetStanzaCorrente() {
		this.partita.setStanzaCorrente(new Stanza(STANZA));
		assertEquals(STANZA,this.partita.getStanzaCorrente().getNome());
	}
	
	
	@Test
	public void testGetStanzaCorrente() {
		this.partita.setStanzaCorrente(new Stanza(STANZA));
		assertEquals(STANZA,this.partita.getStanzaCorrente().getNome());
	}
	
	
	@Test
	public void testGetStanzaCorrenteInizio() {
		Partita partita = new Partita(this.labirinto, this.io);
		assertEquals(partita.getLabirinto().getStanzaIniziale(),partita.getStanzaCorrente());
	}

	
	@Test
	/*se sono nella stanza vincente mi aspetto di aver vinto la partita*/
	public void testVintaInStanzaVincente() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	
	@Test
	/*se mi trovo in una stanza diversa dalla vincente mi aspetto di NON aver vinto la partita*/
	public void testNonVintaStanzaNonVincente() {
		this.partita.setStanzaCorrente(new Stanza(STANZA));
		assertFalse(this.partita.vinta());

	}

	@Test
	/*se ho appena iniziato la partita mi aspetto di NON aver vinto la partita*/
	public void testNonVintaInizioPartita() {
		assertFalse(this.partita.vinta());

	}

	
	@Test
	/*se finisco la partita perchè sono nella stanza vincente*/
	public void testFinitaSeVinta() {
		this.partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());

	}

	@Test
	/*se finisco la partita perchè non ho più cfu*/
	public void testFinitaSeFinitiCfu() {
		this.partita.getGiocatore().setCfu(CFU_FINITI);
		assertFalse(this.partita.giocatoreIsVivo());

	}

	@Test
	/*se finisco la partita perchè uso il comando fine*/
	public void testFinitaSeUsoComandoFine() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	/*se ho appena iniziato la partita la partita non piò essere persa*/
	public void testNonFinitaSeIniziata() {
		assertFalse(this.partita.isFinita());
	}
	
	

	
	
}
