package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPrendiTest {
	
	private Partita partita;
	private Stanza stanza;
	private Borsa borsa;
	private Comando comando;
	private IO io;
	
	@BeforeEach
	public void setUp() {
		this.io  = new IOConsole();
		this.partita=new Partita(io);
		this.stanza = new Stanza("Test");
		this.borsa = this.partita.getGiocatore().getBorsa();
		this.partita.setStanzaCorrente(this.stanza);
		this.comando = new ComandoPrendi("palo");
		
	}
	
	@Test
	void testPrendiPalo() {
		Attrezzo palo = new Attrezzo("palo", 2);
		this.stanza.addAttrezzo(palo);
		String oggettoPresoAtteso = this.stanza.getAttrezzo("palo").toString();
		comando.esegui(this.partita); 
		String attrezzoPresoReale = this.partita.getGiocatore().getBorsa().getAttrezzo("palo").toString();
		assertTrue(attrezzoPresoReale.equals(oggettoPresoAtteso), "mi aspettavo di avere nella borsa "+oggettoPresoAtteso+" ma ho in "+this.partita.getGiocatore().getBorsa().getAttrezzo("palo").toString());
	}

}