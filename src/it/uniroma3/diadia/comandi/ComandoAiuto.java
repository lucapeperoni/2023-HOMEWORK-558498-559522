package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	private String[] elencoComandi;
	
	public ComandoAiuto(String[] elencoComandi) {
		this.elencoComandi=elencoComandi;
	}
	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Comandi disponibili: ");
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		partita.getIO().mostraMessaggio("");
		
	}

	@Override
	public void setParametro(String param) {
	}

	@Override
	public String getNome() {
		return "aiuto";
	}

	@Override
	public String getParametro() {
		return null;
	}
}
