package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;

public class ComandoFine extends AbstractComando implements Comando {
	
	public static final String FINE = "fine";
	public static final String MESSAGGIO_FINE = "Grazie di aver giocato!";
	
	public ComandoFine() {}

	@Override
	public void esegui(Partita partita) {
		IO io = partita.getConsole();
		io.mostraMessaggio(MESSAGGIO_FINE); // si desidera smettere
		partita.setFinita();
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
//		return FINE;
//	}
}
