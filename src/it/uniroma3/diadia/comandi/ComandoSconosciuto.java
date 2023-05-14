package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSconosciuto implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Comando non esistente");
	}

	@Override
	public void setParametro(String param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getNome() {
		return "sconosciuto";
	}

	@Override
	public String getParametro() {
		return null;
	}
}
