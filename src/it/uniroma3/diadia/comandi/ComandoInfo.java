package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoInfo extends AbstractComando implements Comando {
	
	public ComandoInfo() {}

	@Override
	public void esegui(Partita partita) {
		IO io = partita.getConsole();
		Borsa borsa = partita.getGiocatore().getBorsa();
		io.mostraMessaggio("INFORMAZIONI:");
		io.mostraMessaggio("Vite rimanenti: "+ partita.getGiocatore().getCfu());
		//stampa descrizione borsa 
		if(borsa.isEmpty())
			io.mostraMessaggio("La tua borsa e' vuota");
		else {
			io.mostraMessaggio("\nCONTENUTO BORSA:\n");
			io.mostraMessaggio("Ordinato per nome:");
			io.mostraMessaggio(borsa.getContenutoOrdinatoPerNome().toString().substring(1, borsa.getContenutoOrdinatoPerNome().toString().length()-1));
			io.mostraMessaggio("\nOrdinato per peso:");
			io.mostraMessaggio(borsa.getContenutoOrdinatoPerPeso().toString().substring(1, borsa.getContenutoOrdinatoPerPeso().toString().length()-1));
			io.mostraMessaggio("\nRaggruppato per peso:");
			io.mostraMessaggio(borsa.getContenutoRagguppatoPerPeso().toString().substring(1, borsa.getContenutoRagguppatoPerPeso().toString().length()-1));
		}
	}
	
}

