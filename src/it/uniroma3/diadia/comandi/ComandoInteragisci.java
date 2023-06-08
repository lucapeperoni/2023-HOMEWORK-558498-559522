package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.personaggi.*;

public class ComandoInteragisci extends AbstractComando implements Comando {

	private static final String MESSAGGIO_CON_CHI =
			"Con chi dovrei interagire?...";
	private String messaggio;
	
	
	public ComandoInteragisci() {}
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		IO io = partita.getConsole();
		if (personaggio!=null) {
			this.messaggio = personaggio.agisci(partita);
			io.mostraMessaggio(this.messaggio);

		} else io.mostraMessaggio(MESSAGGIO_CON_CHI);
	}
	
	
	public String getMessaggio() {
		return this.messaggio;
	}
	

}
