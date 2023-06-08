package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.*;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.*;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final public String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.\n"
			+ "Per sapere le vite rimanenti ed il contenuto della tua borsa usa il comando 'info'\n"
			+ "Per sapere in che stanza ti trovi usa il comando 'guarda'";
	

	private Partita partita;
	private IO console;

	public DiaDia(Labirinto builder, IO console) {
		this.partita = new Partita(builder, console);
		this.console = console;
	}

	public void gioca() {
		String istruzione; 

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
private boolean processaIstruzione(String istruzione) {
		IO io = this.partita.getConsole();
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva(); //cambiato da fabbricaDiComandiFisarmonica
		
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if(this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!!");
		}
		if(!this.partita.giocatoreIsVivo()) {
			io.mostraMessaggio("Hai esaurito i CFU!");
		}
		return this.partita.isFinita();
}



	public static void main(String[] argc) throws FileNotFoundException, FormatoFileNonValidoException {
		IO console = new IOConsole();
		Labirinto builder = new Labirinto();
		
		builder = builder.creaStanze();
		DiaDia gioco = new DiaDia(builder, console);
		try {
			gioco.gioca();
		} catch (Exception e) {
			console.mostraMessaggio("Errore inaspettato!");
		} 
	}
}
