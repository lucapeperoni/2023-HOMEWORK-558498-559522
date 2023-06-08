package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;

public class ComandoAiuto extends AbstractComando implements Comando {

	private static final String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "info", "guarda", "interagisci", "saluta", "regala"};
	//private static final String AIUTO = "aiuto";
	
	public ComandoAiuto() {}
	
	public String toString(String[] comandi) {
		StringBuilder risultato = new StringBuilder();
    	for (int i=0; i<comandi.length; i++) {
    		risultato.append(comandi[i]+" ");
    	}
    	return risultato.toString();
    }
	
	
	@Override
	public void esegui(Partita partita) {
		IO io = partita.getConsole();
		io.mostraMessaggio(toString(elencoComandi));
	}

//	@Override
//	public void setParametro(String parametro) {
//	}
//
//	@Override
//	public String getParametro() {
//		return null;
//	}
//
//	@Override
//	public String getNome() {
//		return AIUTO;
//	}

	
}
