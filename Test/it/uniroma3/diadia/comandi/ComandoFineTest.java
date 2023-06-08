package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import it.uniroma3.diadia.ambienti.*;
import org.junit.Test;
import it.uniroma3.diadia.fixture.*;
import it.uniroma3.diadia.*;


public class ComandoFineTest {

	@Test
	public void testPartitaComandoFine() throws FileNotFoundException, FormatoFileNonValidoException {
		String[] righeDaLeggere = {"fine"};
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}

}
