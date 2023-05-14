package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando{
	String nomeAttrezzo;
	
	public ComandoPosa(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			partita.getIO().mostraMessaggio("Inserisci il nome dell'attrezzo da lasciare.");
		}else{
			Stanza stanzaCorrente=partita.getGiocatore().getStanzaCorrente();
			Borsa borsaGiocatore=partita.getGiocatore().getBorsa();
			if(borsaGiocatore.hasAttrezzo(nomeAttrezzo)) {
				if(stanzaCorrente.addAttrezzo(borsaGiocatore.getAttrezzo(nomeAttrezzo))){
					borsaGiocatore.removeAttrezzo(nomeAttrezzo);
					partita.getIO().mostraMessaggio("L'attrezzo è stato posato nella stanza");
				}else{
					partita.getIO().mostraMessaggio("L'attrezzo non può essere posato in questa stanza perché è già piena di altri attrezzi.");
					partita.getIO().mostraMessaggio("Posa l'attrezzo in un'altra stanza!");
				}
			}else{
				partita.getIO().mostraMessaggio("Questo oggetto non è presente nella borsa");
			}
		}
		
	}

	@Override
	public void setParametro(String param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}

}
