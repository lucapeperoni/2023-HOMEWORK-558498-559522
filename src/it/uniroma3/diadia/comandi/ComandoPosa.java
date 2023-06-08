package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa extends AbstractComando implements Comando {
	

	public ComandoPosa() {}
	

	@Override
	public void esegui(Partita partita) {
		IO io = partita.getConsole();
		if (this.getParametro()==null) {
			io.mostraMessaggio("Che oggetto vuoi posare nella stanza?");
		}
		else {
			//variabili di appoggio
			Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro()); 
			final Stanza s = partita.getStanzaCorrente();
			final Borsa b = partita.getGiocatore().getBorsa();
			if(b.hasAttrezzo(this.getParametro())) { //se ho l'attrezzo in borsa
				a = b.removeAttrezzo(this.getParametro()); //lo rimuovo e lo salvo nella variabile di appoggio 'a'
				if(s.addAttrezzo(a)) { //aggiungo 'a' alla stanza corrente
					io.mostraMessaggio("Hai posato '"+ this.getParametro() + "' nella stanza");
				}
				else { //se la stanza è già piena
					io.mostraMessaggio("Non è possibile posare questo oggetto qui!");
					b.addAttrezzo(a);
				}
			}
			else { //se non ho l'oggetto in borsa
				io.mostraMessaggio("Non hai questo attrezzo nello zaino!");
			}
		}
	}
	


}

