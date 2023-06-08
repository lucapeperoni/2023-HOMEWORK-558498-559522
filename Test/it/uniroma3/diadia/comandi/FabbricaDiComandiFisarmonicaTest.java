package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica factory;
	private Comando comando;
	final static String VAI = "vai ParametroTest";
	final static String FINE = "fine";
	final static String GUARDA = "guarda";
	final static String PRENDI = "prendi ParametroTest";
	final static String NON_VALIDO = "comandoNonValido";
	final static String POSA = "posa ParametroTest";
	final static String AIUTO = "aiuto";
	final static String PARAMETRO_TEST = "ParametroTest";
	
	
	@Before
	public void setUp() {
		factory = new FabbricaDiComandiFisarmonica();
	}


	
	@Test
	public void testComandoVai() {
		comando = factory.costruisciComando(VAI);
		assertEquals(comando.getClass().getSimpleName(),comando.getNome());
		assertEquals(PARAMETRO_TEST, comando.getParametro());
	}
	
	
	@Test
	public void testComandoPrendi() {
		comando = factory.costruisciComando(PRENDI);
		assertEquals(comando.getClass().getSimpleName(),comando.getNome());
		assertEquals(PARAMETRO_TEST, comando.getParametro());
	}
	
	
	@Test
	public void testComandoPosa() {
		comando = factory.costruisciComando(POSA);
		assertEquals(comando.getClass().getSimpleName(), comando.getNome());
		assertEquals(PARAMETRO_TEST,comando.getParametro());
	}
	
	
	@Test
	public void testComandoFine() {
		comando = factory.costruisciComando(FINE);
		assertEquals(comando.getClass().getSimpleName(),comando.getNome());
		assertNull(comando.getParametro());
	}
	
	
	@Test
	public void testComandoGuarda() {
		comando = factory.costruisciComando(GUARDA);
		assertEquals(comando.getClass().getSimpleName(), comando.getNome());
		assertNull(comando.getParametro());
	}

	
	@Test
	public void testComandoAiuto() {
		comando = factory.costruisciComando(AIUTO);
		assertEquals(comando.getClass().getSimpleName(),comando.getNome());
		assertNull(comando.getParametro());
	}
	
	
	@Test
	public void testComandoNonValido() {
		comando = factory.costruisciComando(NON_VALIDO);
		assertEquals(comando.getClass().getSimpleName(), comando.getNome());
		assertNull(comando.getParametro());
	}
	
}
