package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;


/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {



	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private Stanza stanzaCorrente;
	private IO console;
	private boolean HaDonato;
	
	
	
	public Partita(Labirinto labirinto, IO io){
		this.labirinto = labirinto;
		this.finita = false;
		this.giocatore = new Giocatore();
		this.stanzaCorrente =this.labirinto.getStanzaIniziale();
		this.console = io;
		
		}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
   
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public IO getConsole(){
		return this.console;
	}
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		//return labirinto.getStanzaCorrente()== labirinto.getStanzaVincente();
		return getStanzaCorrente()== labirinto.getStanzaVincente();	} 

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	public boolean giocatoreIsVivo() {
		if(this.giocatore.getCfu()==0) {
			return false;
		}
		return true;
	}
	
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public boolean CaneHaDonato(){
		return this.HaDonato;
	}
	
	public void SetCaneHaDonato(){
		this.HaDonato = true;
	}

	
}
