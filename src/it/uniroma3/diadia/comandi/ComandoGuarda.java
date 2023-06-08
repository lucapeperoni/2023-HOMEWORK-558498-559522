package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando implements Comando {

	public ComandoGuarda() {}

	@Override
	public void esegui(Partita partita) {
		IO io = partita.getConsole();
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Contenuto borsa: "+ partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome().toString());

	}


}
