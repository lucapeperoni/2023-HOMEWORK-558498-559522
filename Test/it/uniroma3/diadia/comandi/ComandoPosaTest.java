package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPosaTest {
	private Stanza stanza;
	private Partita partita;
	private Attrezzo palo;
	private Borsa borsa;
	private Comando comando;
	private IO io;
	
	@BeforeEach
	public void setUp(){
		this.io = new IOConsole();
		this.partita = new Partita(io);
		this.stanza = new Stanza("Test");
		this.comando = new ComandoPosa("palo");
		
		
	}
	
	@Test
	void posaOsso() {
		palo = new Attrezzo("palo", 2);
		this.partita.getGiocatore().getBorsa().addAttrezzo(palo);
		Attrezzo attrezzoPosatoAtteso = this.partita.getGiocatore().getBorsa().getAttrezzo("palo");
		ComandoPosa cmd = new ComandoPosa("palo");
		cmd.esegui(this.partita);
		Attrezzo attrezzoPosatoReale = this.partita.getStanzaCorrente().getAttrezzo("palo");
		assertTrue(attrezzoPosatoAtteso.equals(attrezzoPosatoReale), "mi aspettavo di trovare nella stanza "+attrezzoPosatoAtteso+" ma ho "+this.stanza.getAttrezzo("osso"));
		
	}
}
