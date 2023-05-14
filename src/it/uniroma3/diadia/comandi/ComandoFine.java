package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Grazie di aver giocato!");
		partita.setStatoPartita(false);
	}

	@Override
	public void setParametro(String param) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getNome() {
		return "fine";
	}

	@Override
	public String getParametro() {
		return null;
	}
	
	

}
