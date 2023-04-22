package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	private IO io;
	/**
	 * Comando "Fine".
	 */

	@Override
	public void esegui(Partita partita) {
		this.io = partita.getIo();
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		
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
