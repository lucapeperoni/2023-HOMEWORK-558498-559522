package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandoFisarmonicaTest {
	
	private String nomeConParam;
	private Comando comandoTest;
	private FabbricaDiComandi fabbrica;
	
	@Before
	public void setUp() throws Exception {
		fabbrica = new FabbricaDiComandoFisarmonica();
	}

	@Test
	public void testCostruisciNonValido() {
		nomeConParam = "";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals("non valido",comandoTest.getNome());
	}
	
	@Test
	public void testCostruisciNonValidoPressioneEnter() {
		nomeConParam = "\n";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals("non valido",comandoTest.getNome());
	}
	@Test
	public void testCostruisciSconosciuto() {
		nomeConParam = "qwerty";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals("sconosciuto",comandoTest.getNome());
	}
	@Test
	public void testCostruisciAiuto() {
		nomeConParam = "aiuto";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals(nomeConParam,comandoTest.getNome());
	}
	@Test
	public void testCostruisciBorsa() {
		nomeConParam = "borsa";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals(nomeConParam,comandoTest.getNome());
	}
	@Test
	public void testCostruisciFine() {
		nomeConParam = "fine";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals(nomeConParam,comandoTest.getNome());
	}
	@Test
	public void testCostruisciGuarda() {
		nomeConParam = "guarda";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals(nomeConParam,comandoTest.getNome());
	}
	@Test
	public void testCostruisciPosaParametroNullo() {
		nomeConParam = "posa";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals("posa",comandoTest.getNome());
		assertNull(comandoTest.getParametro());
	}
	@Test
	public void testCostruisciPosaConParametro() {
		nomeConParam = "posa attrezzo";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals("posa",comandoTest.getNome());
		assertEquals("attrezzo",comandoTest.getParametro());
	}
	@Test
	public void testCostruisciPrendiParametroNullo() {
		nomeConParam = "prendi";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals("prendi",comandoTest.getNome());
		assertNull(comandoTest.getParametro());
	}
	@Test
	public void testCostruisciPrendiConParametro() {
		nomeConParam = "prendi attrezzo";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals("prendi",comandoTest.getNome());
		assertEquals("attrezzo",comandoTest.getParametro());
	}
	
	@Test
	public void testCostruisciVaiParametroNullo() {
		nomeConParam = "vai";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals("vai",comandoTest.getNome());
		assertNull(comandoTest.getParametro());
	}
	
	@Test
	public void testCostruisciVaiConParametro() {
		nomeConParam = "vai nord";
		comandoTest = fabbrica.costruisci(nomeConParam);
		assertEquals("vai",comandoTest.getNome());
		assertEquals("nord",comandoTest.getParametro());
	}
}
