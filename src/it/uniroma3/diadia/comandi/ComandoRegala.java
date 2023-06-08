package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.personaggi.*;
import it.uniroma3.diadia.*;

public class ComandoRegala extends AbstractComando implements Comando {
	

	public ComandoRegala() {}

	@Override
	public void esegui(Partita partita) {
		IO io = partita.getConsole();
		if(this.getParametro() == null) {
			io.mostraMessaggio("Che attrezzo vuoi regalare?");
		}
		else {
			Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro()); 
			final AbstractPersonaggio p = partita.getStanzaCorrente().getPersonaggio();
			final Borsa b = partita.getGiocatore().getBorsa();
			if(b.hasAttrezzo(this.getParametro())) { 
				a = b.removeAttrezzo(this.getParametro()); 
				if(p.riceviRegalo(a, partita)!=null) { 
					io.mostraMessaggio(p.getNome() + " ha accettato il tuo dono!");
				}
				else { 
					io.mostraMessaggio("Non è stato possibile donare "+ this.getParametro());
					b.addAttrezzo(a);
				}
			}
			else { 
				io.mostraMessaggio("Non hai questo attrezzo nello zaino!");
			}
		}

	}

}
