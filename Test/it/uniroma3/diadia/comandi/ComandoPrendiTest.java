package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.fixture.*;

public class ComandoPrendiTest {
	
	private Partita partita;
	private IO console;
	private Labirinto labirinto;
	private Borsa borsa;
	static final int PESO = 5;
	static final Attrezzo attrezzo1 = new Attrezzo("attrezzoDiTest1",PESO);
	static final Attrezzo attrezzo2 = new Attrezzo("attrezzoDiTest2",PESO);
	static final FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
	static final Comando prendi = factory.costruisciComando("prendi");
	
	@Before
	public void setUp() {
		console = new IOConsole();
		labirinto = new Labirinto();
		labirinto = labirinto.creaStanze();
		partita = new Partita(labirinto, console);
		borsa = partita.getGiocatore().getBorsa();
	}
	
	
	@Test
	public void testPartitaConComandoPrendi() throws FileNotFoundException, FormatoFileNonValidoException{
		String[] comandiDaEseguire = {"vai sud","prendi attrezzoDiTest1","fine"};
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(comandiDaEseguire);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("AulaN10",io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Hai aggiunto 'attrezzoDiTest1'",io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE,io.nextMessaggio());
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertFalse(interaRiga.contains(expected));
	}
	
	@Test
	public void testConAttrezzoPresente() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo1);
		prendi.esegui(partita);
		prendi.setParametro("attrezzoDiTest1");
		prendi.esegui(partita);
		
		assertTrue(borsa.hasAttrezzo(attrezzo1.getNome()));
	}
	
	
	@Test
	public void testConAttrezzoSbagliato() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo1);
		prendi.esegui(partita);
		prendi.setParametro("attrezzoDiTest1");
		prendi.esegui(partita);
		assertFalse(borsa.hasAttrezzo(attrezzo2.getNome()));
	}
	
	
	@Test
	public void testConAttrezzoNonPresente() {
		prendi.esegui(partita);
		prendi.setParametro("attrezzoDiTest1");
		prendi.esegui(partita);
		assertFalse(borsa.hasAttrezzo(attrezzo1.getNome()));
	}
	
	
	@Test
	public void testConAttrezziMultipli() {
		
		partita.getStanzaCorrente().addAttrezzo(attrezzo1);
		partita.getStanzaCorrente().addAttrezzo(attrezzo2);
		
		prendi.esegui(partita);
		prendi.setParametro("attrezzoDiTest1");
		prendi.esegui(partita);
		
		prendi.setParametro(null);
		prendi.esegui(partita);
		prendi.setParametro("attrezzoDiTest2");
		prendi.esegui(partita);
		
		assertTrue(borsa.hasAttrezzo(attrezzo1.getNome()));
		assertTrue(borsa.hasAttrezzo(attrezzo2.getNome()));
		
	}
	
}