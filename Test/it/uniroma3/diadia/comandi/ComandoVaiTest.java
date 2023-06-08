package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.fixture.*;
import it.uniroma3.diadia.ambienti.*;

public class ComandoVaiTest {
	
	private static final Direzione SUD = Direzione.SUD;
	private static final Direzione EST = Direzione.EST;
	
	@Test
	public void testPartitaConComandoVai() throws FileNotFoundException, FormatoFileNonValidoException{
		String[] comandiDaEseguire = {"vai sud", ComandoFine.FINE};
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(comandiDaEseguire);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertTrue(io.hasNextMessaggio());
		io.nextMessaggio();
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertTrue(interaRiga.contains(expected));
	}
	
	@Test 
	public void testPartitaComandoVaiConBilocale() {
		String[] comandiDaEseguire = {"vai sud", ComandoFine.FINE};
		IOSimulator io = new IOSimulator(comandiDaEseguire);
		Labirinto labirinto = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale("ingresso")
				.addStanza("sala")
				.addAdiacenza("ingresso", "sala", SUD)
				.getLabirinto();
		new DiaDia(labirinto, io).gioca();
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("sala",io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
	
	@Test 
	public void testPartitaComandoVaiConBilocaleVincente() {
		String[] comandiDaEseguire = {"vai sud"};
		IOSimulator io = new IOSimulator(comandiDaEseguire);
		Labirinto labirinto = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale("ingresso")
				.addStanzaVincente("sala")
				.addAdiacenza("ingresso", "sala", SUD)
				.getLabirinto();
		new DiaDia(labirinto, io).gioca();
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		//assertContains("Hai vinto!!",io.nextMessaggio());
	}
	
	@Test
	public void testPartitaComandoVaiConTrilocale() {
		String[] comandiDaEseguire = {"vai sud", "vai est", ComandoFine.FINE};
		IOSimulator io = new IOSimulator(comandiDaEseguire);
		Labirinto labirinto = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale("ingresso")
				.addStanza("sala")
				.addAdiacenza("ingresso", "sala", SUD)
				.addStanza("cucina")
				.addAdiacenza("sala", "cucina", EST)
				.getLabirinto();
		new DiaDia(labirinto, io).gioca();
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("sala",io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("cucina",io.nextMessaggio());
		io.hasNextMessaggio();
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
	

}
