package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Classe Labirinto - Classe che rappresenta un labirinto fisico, luogo di gioco.
 * Contiene all'interno di se una serie di stanze. Gestisce la topologia delle varie stanze.
 * Un labirinto ha 2 variabili di tipo Stanza che corrispondono alla stanza iniziale e a quella
 * vincente del labirinto.
 * @author giovi
 *
 */

public class Labirinto {
	
	Stanza stanzaVincente;
	Stanza stanzaIniziale;
	
	public Labirinto(){
		creaStanze();
//		this.finita = false;
//		this.cfu = CFU_INIZIALI;
	}
	
	// Per motivi di testing
	public Labirinto (Stanza stanzaIniziale, Stanza stanzaVincente) {
		this.stanzaVincente=stanzaVincente;
		this.stanzaIniziale=stanzaIniziale;
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
    private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",2);
		Attrezzo osso = new Attrezzo("osso",1);
    	Attrezzo chiave = new Attrezzo("chiave",1);
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new StanzaBuia("Aula N10","lanterna");
		
		Stanza aulaCampus1= new StanzaMagica("Aula Campus 1");
		
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		Stanza DS1Bloccata = new StanzaBloccata("Aula DS1","nord","chiave");
		Stanza bagnoDS1 = new Stanza("Bagno DS1");
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("nord", DS1Bloccata);
		
		DS1Bloccata.impostaStanzaAdiacente("sud", aulaN11);
		DS1Bloccata.impostaStanzaAdiacente("nord", bagnoDS1);
		
		bagnoDS1.impostaStanzaAdiacente("sud", DS1Bloccata);
		
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN10.impostaStanzaAdiacente("sud", aulaCampus1);
		
		aulaCampus1.impostaStanzaAdiacente("nord", aulaN10);
		
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(chiave);
		// il gioco comincia nell'atrio
        stanzaIniziale = atrio;  
		stanzaVincente = biblioteca;
    }
/*
 * Metodo che ritorna il riferimento alla stanza vincente
 * (può essere usata per controllare se la stanza nella quale
 * sta il giocatore è la stessa stanza che lo farebbe vincere)
 */
    public void setStanzaVincente(Stanza stanzaVincente) {
    	this.stanzaVincente=stanzaVincente;
    }
    
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}
	
	/* Funzione che ritorna la stanza dove il giocatore si trova quando
	 * comincia la partita
	 */
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
}
