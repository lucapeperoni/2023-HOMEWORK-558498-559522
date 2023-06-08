package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi extends AbstractComando implements Comando {
	
	public ComandoPrendi() {}

	@Override
	public void esegui(Partita partita) {
		IO io = partita.getConsole();
		if (this.getParametro()==null)
			io.mostraMessaggio("Che attrezzo vuoi prendere dalla stanza?");
		else {
			//variabili di appoggio
			final Attrezzo a = partita.getStanzaCorrente().getAttrezzo(this.getParametro());
			final Borsa b = partita.getGiocatore().getBorsa();
			if(partita.getStanzaCorrente().hasAttrezzo(this.getParametro())) { //se esiste l'oggetto inserito nella stanza corrente
				
				if(b.getPeso() + a.getPeso() <= Borsa.DEFAULT_PESO_MAX_BORSA && partita.getStanzaCorrente().removeAttrezzo(this.getParametro())) { //e se non ho la borsa piena e l'ho eliminato
					b.addAttrezzo(a);//aggiungo l'attrezzo rimosso dalla stanza nella borsa del giocatore
					io.mostraMessaggio("Hai aggiunto '"+ this.getParametro() +"' nella borsa!");
				}
				else {
					if (b.getPeso() + a.getPeso() > b.getPesoMax()) //se ho la borsa piena
						io.mostraMessaggio("Hai la borsa piena lascia un attrezzo!");
				}
			}
			else //se non c'è l'oggetto nella stanza
				io.mostraMessaggio("Non esiste un attrezzo di nome "+ this.getParametro() +" in questa stanza");

		}
		
	}

}
