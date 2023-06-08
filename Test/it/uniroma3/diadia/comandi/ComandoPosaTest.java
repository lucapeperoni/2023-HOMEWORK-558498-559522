package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.fixture.*;

public class ComandoPosaTest {
	
	private Partita partita;
	private Labirinto labirinto;
	private IO console;
	static final int PESO = 2;
	static final Attrezzo attrezzo1 = new Attrezzo("attrezzoDiTest1",PESO);
	static final Attrezzo attrezzo2 = new Attrezzo("attrezzoDiTest2",PESO);
	static final FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
	static final Comando posa = factory.costruisciComando("posa");

	@Before
	public void setUp() {
		console = new IOConsole();
		labirinto = new Labirinto();
		labirinto = labirinto.creaStanze();
		this.partita = new Partita(labirinto, console);
		
	 }
	
	@Test
	public void testPartitaConComandoPosa() throws FileNotFoundException, FormatoFileNonValidoException{
		String[] comandiDaEseguire = {"vai sud","prendi attrezzoDiTest1", "posa attrezzoDiTest1" , "fine"};
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(comandiDaEseguire);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("AulaN10",io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Hai aggiunto 'attrezzoDiTest1'",io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Hai lasciato 'attrezzoDiTest1'",io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE,io.nextMessaggio());
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertFalse(interaRiga.contains(expected));
	}

	
	
	@Test
	public void testComandoPosaConOggettoPresente() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo1);
		posa.esegui(partita);
		posa.setParametro("attrezzoDiTest1");
		posa.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(attrezzo1.getNome()));
	}
	
	
	@Test 
	public void testComandoPosaConOggettoNonPresente() {
		posa.esegui(partita);
		posa.setParametro("attrezzoDiTest1");
		posa.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(attrezzo1.getNome()));
	}
	
	
	@Test
	public void testComandoPosaConAttrezziDifferenti() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo1);
		posa.esegui(partita);
		posa.setParametro("attrezzoDiTest1");
		posa.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(attrezzo2.getNome()));
	}
	
	
	@Test
	public void testComandoPosaConPiuAttrezzi() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo1);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo2);
		
		posa.esegui(partita);
		posa.setParametro("attrezzoDiTest1");
		posa.esegui(partita);
		
		posa.setParametro("attrezzoDiTest2");
		posa.esegui(partita);
		
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(attrezzo1.getNome()));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(attrezzo2.getNome()));
		
	}

}
