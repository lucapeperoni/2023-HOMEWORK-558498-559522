package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;


public class ComandoGuarda implements Comando {
	private IO io;
	public void esegui(Partita partita) {
		this.io = partita.getIo();
		io.mostraMessaggio("Stanza corrente: "+partita.getStanzaCorrente().getNome());
		io.mostraMessaggio("Descrizione stanza: "+partita.getStanzaCorrente().getDescrizione().toString());
		io.mostraMessaggio("Borsa attuale: "+partita.getGiocatore().getBorsa().toString());
		io.mostraMessaggio("CFU attuali: "+partita.getGiocatore().getCfu());
	}

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public void getParametro() {
		
	}

	@Override
	public void getNome() {
		
	}
}
