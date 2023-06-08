package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaneTest {
	private Cane cane;
	private Partita partita;
	private Attrezzo regalo;
	private Attrezzo ciboPreferito;
	private IO io;

	@Before
	public void setUp() throws Exception {
		Labirinto labirinto = new Labirinto();
		labirinto = labirinto.creaStanze();
		this.io = new IOConsole();
		this.partita = new Partita(labirinto,io);
		this.regalo = new Attrezzo("osso", 1);
		this.ciboPreferito = new Attrezzo("croccantini", 2);
		this.cane = new Cane("Cane", "Presentazione!");
	}

	@Test
	public void testAgisci() {
		this.partita.getGiocatore().setCfu(10);
		this.cane.agisci(this.partita);
		assertEquals(9, this.partita.getGiocatore().getCfu());
	}

	@Test
	public void testRiceviRegalo_CiboCorretto() {
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
		this.cane.riceviRegalo(this.ciboPreferito, this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
	}
	
	@Test
	public void testRiceviRegalo_Sbagliato() {
		Attrezzo ciboSbagliato = new Attrezzo("CiboSbagliato", 2);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(ciboSbagliato.getNome()));
		this.cane.riceviRegalo(ciboSbagliato, this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(ciboSbagliato.getNome()));
	}
	
	@Test
	public void testRiceviRegalo_DueVolte() {
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
		this.cane.riceviRegalo(this.ciboPreferito, this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
		this.partita.getStanzaCorrente().removeAttrezzo(this.regalo.getNome());
		this.cane.riceviRegalo(this.ciboPreferito, this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
	}
}
