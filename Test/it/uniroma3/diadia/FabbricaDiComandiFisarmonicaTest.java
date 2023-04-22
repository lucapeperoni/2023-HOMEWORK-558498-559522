package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class FabbricaDiComandiFisarmonicaTest {
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","guarda", "posa", "prendi"};
	static final private String[] elencoDirezioni = {"nord", "sud", "ovest", "est"};
	private Comando comandoDaEseguire;
	private FabbricaDiComandiFisarmonica factory;
	
	@BeforeEach
	public void setUp() {
		this.factory = new FabbricaDiComandiFisarmonica();
	}
	
	@Test
	void costruisciComandoAiuto() {
		this.comandoDaEseguire = this.factory.costruisciComando(elencoComandi[1]);
		assertEquals(elencoComandi[1], this.factory.getNome());
	}
	
	@Test
	void costruisciComandoGuarda() {
		this.comandoDaEseguire = this.factory.costruisciComando(elencoComandi[3]);
		assertEquals(elencoComandi[3], this.factory.getNome());
	}
	
	@Test
	public void testCostruisciComandoVai() {
		for (String direzione : elencoDirezioni) {
			this.comandoDaEseguire = this.factory.costruisciComando(elencoComandi[0] + " " + direzione);
			assertEquals(elencoComandi[0], this.factory.getNome());
			assertEquals(direzione, this.factory.getParametro());
		}
	}

	@Test
	public void testCostruisciComandoGuarda() {
		this.comandoDaEseguire = this.factory.costruisciComando(elencoComandi[3]);
		assertEquals(elencoComandi[3], this.factory.getNome());
	}

	@Test
	public void testCostruisciComandoPosa() {
		this.comandoDaEseguire = this.factory.costruisciComando(elencoComandi[4] + " osso");
		assertEquals(elencoComandi[4], this.factory.getNome());
		assertEquals("osso", this.factory.getParametro());
	}

	@Test
	public void testCostruisciComandoPrendi() {
		this.comandoDaEseguire = this.factory.costruisciComando(elencoComandi[5] + " osso");
		assertEquals(elencoComandi[5], this.factory.getNome());
		assertEquals("osso", this.factory.getParametro());
	}

}
