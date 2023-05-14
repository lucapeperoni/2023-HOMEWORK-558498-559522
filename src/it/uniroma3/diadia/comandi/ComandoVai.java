package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	
	private String direzione;
	
	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}
	
	@Override
	public void setParametro(String param) {
		this.direzione=param;
	}
	
	@Override
	public void esegui(Partita partita) {
		IO io = partita.getIO();
		Stanza corrente= partita.getGiocatore().getStanzaCorrente();
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare?");
			io.mostraMessaggio("Possibili direzioni: ");
			io.mostraMessaggio(corrente.stampaDirezioni());
		}else {
			Stanza prossimaStanza = null;
			prossimaStanza = corrente.getStanzaAdiacente(direzione);
			if (prossimaStanza == null) {
				io.mostraMessaggio("Direzione inesistente");
				io.mostraMessaggio("Possibili direzioni: ");
				io.mostraMessaggio(corrente.stampaDirezioni());
			}else {
				partita.getGiocatore().setStanzaCorrente(prossimaStanza);
				int cfu = partita.getGiocatore().getCfu();
				partita.getGiocatore().setCfu(--cfu);
				//io.mostraMessaggio(cfu); Debugging purposes
				io.mostraMessaggio(partita.getGiocatore().getStanzaCorrente().getDescrizione());
			}
		}
	}
	
	@Override
	public String getNome() {
		return "vai";
	}

	@Override
	public String getParametro() {
		return direzione;
	}
}

