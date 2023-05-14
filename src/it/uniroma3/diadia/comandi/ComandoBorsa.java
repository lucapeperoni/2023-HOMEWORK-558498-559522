package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoBorsa implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio(partita.getGiocatore().getBorsa().toString());

	}

	@Override
	public void setParametro(String param) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getNome() {
		return "borsa";
	}

	@Override
	public String getParametro() {
		return null;
	}
	
	
	

}
