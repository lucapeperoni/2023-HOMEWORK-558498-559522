package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;

	public ComandoPrendi(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}

	public void esegui(Partita partita) {
		IO io = partita.getIO();

		if(this.nomeAttrezzo==null) {
			io.mostraMessaggio("Digitare il nome dell'attrezzo che vuoi prendere");
			return;
		}else{
			Stanza stanzaCorrente=partita.getGiocatore().getStanzaCorrente();
			Borsa borsaGiocatore=partita.getGiocatore().getBorsa();
			if(stanzaCorrente.hasAttrezzo(this.nomeAttrezzo)) {
				if(borsaGiocatore.addAttrezzo(stanzaCorrente.getAttrezzo(this.nomeAttrezzo))){
					io.mostraMessaggio("Hai preso "+this.nomeAttrezzo);
					stanzaCorrente.removeAttrezzo(this.nomeAttrezzo);
				}else{
					io.mostraMessaggio("L'operazione non ha avuto successo. La borsa è piena");
				}
			}else{
				io.mostraMessaggio("L'attrezzo non è presente nella stanza corrente");
			}
		}
	}

	@Override
	public void setParametro(String param) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}
}
