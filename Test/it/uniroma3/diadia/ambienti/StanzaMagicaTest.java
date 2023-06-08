package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.*;

public class StanzaMagicaTest {

	private Stanza stanzaTest;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Attrezzo attrezzo4;
	private static final String STANZA_TEST = "stanzaDiTest";
	private static final String attrezzo = "attrezzoDiTest";
	private static final String attrezzodue = "attrezzo";
	private static final String attrezzotre = "attrezzoTest";
	private static final String attrezzoquattro = "test";
	
	private static final int peso = 1;
	
	@Before
	public void setUp() {
		this.stanzaTest = new StanzaMagica(STANZA_TEST);
		this.attrezzo1 = new Attrezzo(attrezzo, peso);
		this.attrezzo2 = new Attrezzo(attrezzodue, peso);
		this.attrezzo3 = new Attrezzo(attrezzotre, peso);
		this.attrezzo4 = new Attrezzo(attrezzoquattro, peso);
	}

	@Test
	public void testAggiungoUnAttrezzo() {
		this.stanzaTest.addAttrezzo(attrezzo1);
		assertEquals(attrezzo1.getNome(), stanzaTest.getAttrezzo(attrezzo).getNome());
		assertNotEquals(attrezzo1.getNome(),invertiAttrezzo(attrezzo1).getNome());
		assertNotEquals(peso*2, stanzaTest.getAttrezzo(attrezzo).getPeso());
	}

	
	@Test
	public void testAggiungoDueAttrezzi() {
		this.stanzaTest.addAttrezzo(attrezzo1);
		this.stanzaTest.addAttrezzo(attrezzo2);
		assertEquals(attrezzo1.getNome(), stanzaTest.getAttrezzo(attrezzo).getNome());
		assertEquals(attrezzo2.getNome(), stanzaTest.getAttrezzo(attrezzodue).getNome());
		assertNotEquals(attrezzo2.getNome(),invertiAttrezzo(attrezzo2).getNome());
		assertNotEquals(peso*2, stanzaTest.getAttrezzo(attrezzodue).getPeso());
	}
	
	@Test
	public void testRaggiungoLaSoglia() {
		this.stanzaTest.addAttrezzo(attrezzo1);
		this.stanzaTest.addAttrezzo(attrezzo2);
		this.stanzaTest.addAttrezzo(attrezzo3);
		
		assertEquals(attrezzo1.getNome(), stanzaTest.getAttrezzo(attrezzo).getNome());
		assertEquals(attrezzo2.getNome(), stanzaTest.getAttrezzo(attrezzodue).getNome());
		assertEquals(attrezzo3.getNome(), stanzaTest.getAttrezzo(attrezzotre).getNome());
		assertNotEquals(attrezzo3.getNome(),invertiAttrezzo(attrezzo3).getNome());
		assertNotEquals(peso*2, stanzaTest.getAttrezzo(attrezzotre).getPeso());
	}
	
	@Test
	public void testSuperoLaSoglia() {
		this.stanzaTest.addAttrezzo(attrezzo1);
		this.stanzaTest.addAttrezzo(attrezzo2);
		this.stanzaTest.addAttrezzo(attrezzo3);
		this.stanzaTest.addAttrezzo(attrezzo4);

		assertFalse(stanzaTest.hasAttrezzo(attrezzoquattro));
		assertTrue(stanzaTest.hasAttrezzo(invertiAttrezzo(attrezzo4).getNome()));
		assertEquals(peso*2, stanzaTest.getAttrezzo(invertiAttrezzo(attrezzo4).getNome()).getPeso());
	}
	
	
	private Attrezzo invertiAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		
		return attrezzo;
	}
}
