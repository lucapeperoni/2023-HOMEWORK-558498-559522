package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.*;

import java.util.Map;

import it.uniroma3.diadia.*;

public class ComandoVai extends AbstractComando implements Comando {
	
	public ComandoVai() {}
	
	
	@Override
	public void esegui(Partita partita) {
		IO io = partita.getConsole();
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza =null;
		if(this.getParametro()==null) {
			io.mostraMessaggio("Dove vuoi andare? \nDevi specificare una direzione");
			return;
		}
		Map<String, Direzione> possibili = partita.getLabirinto().getPossibiliDirezioni();
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(possibili.get(this.getParametro()));
		if(prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	
}
