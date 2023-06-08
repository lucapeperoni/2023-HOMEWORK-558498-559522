package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.*;

public class ComandoSaluta extends AbstractComando implements Comando {

	private static final String MESSAGGIO_CHI =
			"Chi dovrei salutare? Qui non c'è nessuno...";
	
	
	public ComandoSaluta() {}

	@Override
	public void esegui(Partita partita) {
		IO io = partita.getConsole();
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(personaggio != null) {
			String msg = personaggio.saluta();
			io.mostraMessaggio(msg);
		}
		else{
			io.mostraMessaggio(MESSAGGIO_CHI);
		}

	}

}
