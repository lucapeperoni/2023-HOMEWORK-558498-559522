package it.uniroma3.diadia.fixture;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

public class Fixture {

	public static IOSimulator creaSimulazionePartitaEGioca(String[] righeDaLeggere) throws FileNotFoundException, FormatoFileNonValidoException {
		IOSimulator io = new IOSimulator(righeDaLeggere);
		//Labirinto labirinto = new Labirinto("labirinto");
		Labirinto labirinto = new Labirinto();
		labirinto = labirinto.creaStanze();
		new DiaDia(labirinto, io).gioca();
		return io;
	}
	
	public static Attrezzo creaAttrezzoEAggiungiAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo,int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}


}
