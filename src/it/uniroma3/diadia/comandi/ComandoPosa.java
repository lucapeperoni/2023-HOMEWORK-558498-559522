package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {
	private IO io;
	String nomeAttrezzo;
	
	public ComandoPosa(String nomeAttrezzo){
		this.nomeAttrezzo = nomeAttrezzo;
		
	}
	
	@Override
	public void esegui(Partita partita) {
		this.io = partita.getIo();
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(a!=null) {
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			io.mostraMessaggio("Oggetto posato!");
		}
		else {
			io.mostraMessaggio("L' oggetto non puoi posarlo perche non lo hai nella borsa!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}

	@Override
	public void getParametro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getNome() {
		// TODO Auto-generated method stub
		
	}
}
